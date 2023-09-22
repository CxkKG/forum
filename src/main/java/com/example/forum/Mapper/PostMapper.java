package com.example.forum.Mapper;

import com.example.forum.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Insert("INSERT INTO posts (title, content, user_id) VALUES (#{title}, #{content}, #{user.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createPost(Post post);

    @Select("SELECT * FROM posts WHERE id = #{id}")
    Post findById(int id);

    @Delete("DELETE FROM posts WHERE id = #{id}")
    void deletePost(int id);

    @Select("SELECT * FROM posts WHERE is_published = true")
    List<Post> getPublishedPosts();

}