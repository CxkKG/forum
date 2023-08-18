package com.example.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    private PostService postService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Post> publishedPosts = postService.getPublishedPosts();
        model.addAttribute("publishedPosts", publishedPosts);
        return "dashboard";
    }
}

