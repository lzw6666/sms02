package org.lzw.sms01.service;

public interface RedisService {
    public void setExp(String key,String value,Long time);
    public String get(String key);
    public void del(String key);
    public Long incr(String key);

    public void setObject(String key,String value);
    public Object getObject(String key);

}
