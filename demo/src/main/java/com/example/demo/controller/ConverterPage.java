package com.example.demo.controller;

import com.example.demo.entity.SimpleTestEntity;
import com.example.demo.entity.SimpleUser;
import com.example.demo.repository.TestEntityRep;
import com.example.demo.service.SimpleConverter;
import com.example.demo.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ConverterPage {
    @Autowired
    private SimpleUserService userService;
    @Autowired
    private SimpleConverter<SimpleTestEntity> converter;
    @Autowired
    private TestEntityRep entityRep;

    @GetMapping("/")
    public String showPage(Model model) throws IllegalAccessException {
        List<SimpleTestEntity> users = entityRep.findAll();
        String initialData = converter.marshal(users, SimpleTestEntity.class.getDeclaredFields());

        model.addAttribute("input", initialData);
        model.addAttribute("output", "");
        return "converter-page";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("inputText")String input, Model model){
        String result = converter.convertValToUpCase(input);
        model.addAttribute("input", input);
        model.addAttribute("output", result);
        return "converter-page";
    }
}
