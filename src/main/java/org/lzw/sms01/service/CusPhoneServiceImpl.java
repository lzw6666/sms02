package org.lzw.sms01.service;

import org.lzw.sms01.dao.CusPhoneMapper;
import org.lzw.sms01.dto.CusDTO;
import org.lzw.sms01.pojo.CusPhone;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CusPhoneServiceImpl implements CusPhoneService {
    @Autowired
    private CusPhoneMapper cusPhoneMapper;

    @Autowired
    private RedisService redisService;
    @Override
    public void addCus(CusDTO dto) {
        CusPhone cusPhone = new CusPhone();
        BeanUtils.copyProperties(dto,cusPhone);
        cusPhoneMapper.insert(cusPhone);
    }

    @Override
    public CusDTO getCusById(Long cid) {
        CusPhone cusPhone = cusPhoneMapper.selectByPrimaryKey(cid);
        CusDTO cusDTO = new CusDTO();
        BeanUtils.copyProperties(cusPhone,cusDTO);
        return cusDTO;
    }

    @Override
    public CusDTO getCusFromToken(String token) {
        Object object = redisService.getObject(token);
        if (object==null){

            CusPhone cusPhone = cusPhoneMapper.selectByToken(token);
            CusDTO cusDTO = new CusDTO();
            BeanUtils.copyProperties(cusPhone,cusDTO);
            return cusDTO;
        }
        return ((CusDTO) object);
    }
}
