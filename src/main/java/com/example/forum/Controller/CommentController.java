package com.example.forum.Controller;

import com.example.forum.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

}

