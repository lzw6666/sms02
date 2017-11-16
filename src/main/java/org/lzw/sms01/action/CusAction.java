package org.lzw.sms01.action;

import org.lzw.sms01.dto.CusDTO;
import org.lzw.sms01.service.CusPhoneService;
import org.lzw.sms01.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class CusAction {

    @Autowired
    private CusPhoneService cusPhoneService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/prereg")
    public String pre(Model model){
        String token = UUID.randomUUID().toString();
        model.addAttribute("token",token);
        return "registercus";
    }
    @RequestMapping("/register")
    @ResponseBody
    public String register(CusDTO cusDTO){
        cusPhoneService.addCus(cusDTO);
        return "ok";
    }

    @RequestMapping("/getCus")
    @ResponseBody
    public CusDTO getCus(String token){
        CusDTO cusFromToken = cusPhoneService.getCusFromToken(token);
        return cusFromToken;
    }

}
