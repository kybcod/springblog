package com.springblog.mapper;

import com.springblog.domain.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO member (email, password, nick_name)
            VALUES (#{email},#{password},#{nickName})
            """)
    void insert(Member member);


    @Select("""
            SELECT * FROM member ORDER BY id DESC
            """)
    List<Member> selectAll();

    @Select("""
            SELECT * FROM member WHERE id = #{id}
            """)
    Member selectById(Integer id);

    @Update("""
            UPDATE member
            SET password = #{password}, nick_name = #{nickName}
            WHERE id = #{id}
            """)
    int update(Member member);

    @Delete("""
            DELETE FROM member WHERE id = #{id}
            """)
    int deleteById(Integer id);

    @Select("""
            SELECT * FROM member WHERE email = #{email}
            """)
    Member selectByEmail(String email);

}
