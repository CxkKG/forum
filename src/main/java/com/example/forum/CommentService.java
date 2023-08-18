package com.example.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public void createComment(Comment comment) {
        commentMapper.createComment(comment);
    }

    public Comment getCommentById(Long id) {
        return commentMapper.findById(id);
    }
}
