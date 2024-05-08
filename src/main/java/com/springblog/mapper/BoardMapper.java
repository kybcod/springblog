package com.springblog.mapper;

import com.springblog.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
            INSERT INTO board (title, content, member_id)
            VALUES (#{title}, #{content}, #{memberId})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Board board);

    @Select("SELECT b.id, b.title, m.nick_name writer FROM board b JOIN member m ON b.member_id = m.id ORDER BY id DESC")
    List<Board> selectAll();

    @Select("""
            SELECT b.id, b.title, b.content, b.inserted, m.nick_name writer, m.id member_id
            FROM board b JOIN member m 
                ON b.member_id = m.id 
            WHERE b.id = #{id}
            """)
    Board selectById(Integer id);

    @Select("SELECT * FROM board WHERE title LIKE CONCAT('%', #{keyword}, '%')")
    Board selectByTitle(String title);

    @Update("""
            UPDATE board
            SET title = #{title}, content = #{content}
            WHERE id = #{id}
            """)
    int update(Board board);

    @Delete("DELETE FROM board WHERE id = #{id}")
    int delete(Integer id);

    @Delete("DELETE FROM board WHERE member_id = #{id}")
    int deleteByMemberId(Integer id);

    @Select("""
            SELECT b.id, b.title, m.nick_name writer
            FROM board b JOIN member m ON b.member_id = m.id
            ORDER BY id DESC LIMIT #{offset}, 10
            """)
    List<Board> selectAllByPage(int offset);


    @Select("""
            SELECT COUNT(*) FROM board
            """)
    int countAll();


}
