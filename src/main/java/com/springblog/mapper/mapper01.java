package com.springblog.mapper;

import com.springblog.domain.memberBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface mapper01 {
    @Insert("INSERT INTO member VALUES (#{c1}, #{c2}, #{c3}, #{c4}, #{c5}, #{c6})")
    int insert(memberBean bean);

    @Select("SELECT * FROM member")
    List<memberBean> select();
}
