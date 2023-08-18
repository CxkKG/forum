package com.example.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public void createPost(Post post) {
        postMapper.createPost(post);
    }

    public Post getPostById(Long id) {
        return postMapper.findById(id);
    }

    public void deletePost(Long id) {
        postMapper.deletePost(id);
    }

    public List<Post> getPublishedPosts() {
        return postMapper.getPublishedPosts();
    }
}
