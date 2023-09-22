package com.example.forum.Service;

import com.example.forum.Comment;
import com.example.forum.Mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public void createComment(Comment comment) {
        commentMapper.createComment(comment);
    }

    public List<Comment> getCommentsByPostId(int postId) {
        return commentMapper.getCommentsByPostId(postId);
    }
}
