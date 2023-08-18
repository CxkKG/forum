package com.example.forum;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/createComment")
    public String createComment(@ModelAttribute Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        comment.setUser(user);
        commentService.createComment(comment);

        // Redirect back to the post page where the comment was created
        return "redirect:/post/" + comment.getPost().getId();
    }

}

