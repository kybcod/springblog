package com.springblog.mapper;

import com.springblog.domain.memberBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface mapper01 {
    @Insert("""
            INSERT INTO member (member_id, password, email1,email2, birth, phone)
            VALUES (#{member_id}, #{password}, #{email1}, #{email2}, #{birth}, #{phone})
            """)
    int insert(memberBean bean);


    @Select("SELECT * FROM member")
    List<memberBean> select();
}
