package com.example.board.controller;

import com.example.board.domain.Post;
import com.example.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final PostService postService;

    @Autowired
    public BoardController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model) {
        setList(model, new Post(),"create");
        return "layout";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("form") Post form, Model model) {
        postService.createPost(form);
        setList(model, new Post(),"create");
        return "layout";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute("form") Post form, Model model) {
        form = postService.findPost(form.getId());
        setList(model, form,"update");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("form") Post form, Model model) {
        postService.updatePost(form.getId(),form);
        setList(model, new Post(),"create");
        return "layout";
    }
    @GetMapping("/delete")
    public String delete(@ModelAttribute("form") Post form, Model model) {
        postService.deletePost(form.getId());
        setList(model, new Post(),"create");
        return "layout";
    }

    private Model setList(Model model, Post post, String path){
        model.addAttribute("form", post);
        model.addAttribute("list", postService.getAllPost());
        model.addAttribute("path", path);
        return null;
    }
}
