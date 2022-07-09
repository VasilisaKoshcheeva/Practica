package com.example.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/addCabinet")
    public String addCabinet(){
        return "addCabinet";
    }
    @GetMapping("/addSchedule")
    public String addSchedule(){
        return "addSchedule";
    }
}
