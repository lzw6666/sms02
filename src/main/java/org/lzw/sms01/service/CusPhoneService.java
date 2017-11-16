package org.lzw.sms01.service;

import org.lzw.sms01.dto.CusDTO;

public interface CusPhoneService {

    public void addCus(CusDTO dto);

    public CusDTO getCusById(Long cid);

    public CusDTO getCusFromToken(String token);

}
