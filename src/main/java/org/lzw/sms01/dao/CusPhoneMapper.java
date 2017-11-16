package org.lzw.sms01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lzw.sms01.pojo.CusPhone;
import org.lzw.sms01.pojo.CusPhoneExample;

import java.util.List;

@Mapper
public interface CusPhoneMapper {
    int countByExample(CusPhoneExample example);

    int deleteByExample(CusPhoneExample example);

    int deleteByPrimaryKey(Long cid);

    int insert(CusPhone record);

    int insertSelective(CusPhone record);

    List<CusPhone> selectByExample(CusPhoneExample example);

    CusPhone selectByPrimaryKey(Long cid);
    CusPhone selectByToken(String token);

    int updateByExampleSelective(@Param("record") CusPhone record, @Param("example") CusPhoneExample example);

    int updateByExample(@Param("record") CusPhone record, @Param("example") CusPhoneExample example);

    int updateByPrimaryKeySelective(CusPhone record);

    int updateByPrimaryKey(CusPhone record);
}