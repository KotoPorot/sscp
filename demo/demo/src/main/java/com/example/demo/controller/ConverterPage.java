package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientsRep;
import com.example.demo.service.SimpleConverter;
import com.example.demo.service.SimpleUserService;
import com.example.demo.service.SpelProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConverterPage {
    @Autowired
    private SimpleUserService userService;
    @Autowired
    private SimpleConverter<Client> converter;
    @Autowired
    private ClientsRep entityRep;
    @Autowired
    private SpelProcService sps;

    @GetMapping("/converter")
    public String showPage(Model model) throws IllegalAccessException {
        List<Client> users = entityRep.findAll();
        String initialData = converter.marshal(users, Client.class.getDeclaredFields());

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

    @GetMapping("/clients")
    public String getClients(Model model){
    List<Client> clients = entityRep.findAll();


    List<Client> spelResult = sps.createPresentationList(clients);


    model.addAttribute("clientsBefore", clients);
    model.addAttribute("clientsAfter", spelResult);
        return "clients";
    }

}
