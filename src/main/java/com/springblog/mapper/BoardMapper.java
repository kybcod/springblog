package com.springblog.mapper;

import com.springblog.domain.Board;
import com.springblog.domain.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
    INSERT INTO board (title, content, writer)
    VALUES (#{title}, #{content}, #{writer})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Board board);

    @Select("SELECT * FROM board ORDER BY id DESC")
    List<Board> selectAll();

    @Select("SELECT * FROM board WHERE id = #{id}")
    Board selectById(Integer id);

    @Update("""
            UPDATE board
            SET title = #{title}, content = #{content}, writer = #{writer}
            WHERE id = #{id}
            """)
    int update(Board board);

    @Delete("DELETE FROM board WHERE id = #{id}")
    int delete(Integer id);
}
