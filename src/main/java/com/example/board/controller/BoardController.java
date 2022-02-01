package com.example.board.controller;

import com.example.board.domain.Post;
import com.example.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private final PostService postService;

    @Autowired
    public BoardController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("form", new Post());
        setList(model, "create");
        return "layout";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("form") @Validated Post form, BindingResult result, Model model) {
        if(!result.hasErrors()){
            postService.createPost(form);
            model.addAttribute("form", new Post());
        }
        setList(model, "create");
        return "layout";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute("form") Post form, Model model) {
        form = postService.findPost(form.getId());
        model.addAttribute("form", form);
        setList(model, "update");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("form") @Validated Post form, BindingResult result, Model model) {
        if(!result.hasErrors()){
            postService.updatePost(form.getId(),form);
            model.addAttribute("form", new Post());
        }
        setList(model, "create");
        return "layout";
    }
    @GetMapping("/delete")
    public String delete(@ModelAttribute("form") Post form, Model model) {
        postService.deletePost(form.getId());
        model.addAttribute("form", new Post());
        setList(model, "create");
        return "layout";
    }

    private void setList(Model model, String path){

        model.addAttribute("list", postService.getAllPost());
        model.addAttribute("path", path);
    }


}
