package com.example.forum.Service;

import com.example.forum.Comment;
import com.example.forum.Mapper.CommentMapper;
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
