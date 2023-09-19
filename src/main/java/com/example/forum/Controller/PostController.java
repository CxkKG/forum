package com.example.forum.Controller;

import com.example.forum.Comment;
import com.example.forum.Post;
import com.example.forum.Service.CommentService;
import com.example.forum.Service.PostService;
import com.example.forum.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/createPost")
    public String createPostPage() {
        return "createPost";
    }
    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Post post, HttpSession session) {
        User user = (User) session.getAttribute("user");
        post.setUser(user);
        postService.createPost(post);
        session.setAttribute("post",post);
        return "dashboard";
    }

    @PostMapping("/deletePost/{id}")
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "dashboard";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable int id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "postDetails";
    }

    @GetMapping("/addComment")
    public String createCommentPage(@ModelAttribute Comment comment) {
        commentService.createComment(comment);
        return "redirect:/post/" + comment.getPost().getId();
    }

    @PostMapping("/addComment")
    public String addComment(@ModelAttribute Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        comment.setUser(user);
        Post post = (Post) session.getAttribute("post");
        comment.setPost(post);
        commentService.createComment(comment);
        return "redirect:/post/" + comment.getPost().getId();
    }
}

