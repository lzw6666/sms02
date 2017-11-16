package org.lzw.sms01.action;

import org.lzw.sms01.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class VerifyAction {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/verfiy")
    @ResponseBody
    public Map<String,String> check(String mobile, String code){
        Map<String,String> map = new HashMap<String,String>();
        String serverCode = redisService.get(mobile);
        if (serverCode!=null) {
            if (code.equals(serverCode)) {
                redisService.del(mobile);
                map.put("status", "0");
                map.put("msg", "登陆成功");
            } else {
                Long incr = redisService.incr("error_" + mobile);
                if (incr >= 3) {
                    redisService.del(mobile);
                    redisService.del("error_" + mobile);
                    map.put("status", "1");
                    map.put("msg", "验证失败，请重新获取验证码");
                } else {
                    map.put("status", "2");
                    map.put("msg", "验证失败，,请重新验证,剩余"+(3-incr));
                }
            }
        }else{
            //为了当有限时间到了,清掉计数key
            redisService.del("error_" + mobile);
            map.put("status", "1");
            map.put("msg", "验证失败，请重新获取验证码");
        }
        return map;
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(String key){
        redisService.del(key);
        return "删除成功";
    }

    @RequestMapping("/index")
    public String index(String msg, Model model){
        model.addAttribute("msg",msg);
        return "index";
    }
}
