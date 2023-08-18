package com.example.forum;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO comments (content, user_id, post_id) VALUES (#{content}, #{user.id}, #{post.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createComment(Comment comment);

    @Select("SELECT * FROM comments WHERE id = #{id}")
    Comment findById(Long id);
}
