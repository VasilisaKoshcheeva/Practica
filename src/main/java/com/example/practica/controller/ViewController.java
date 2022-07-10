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

    @GetMapping("/updateCabinet")
    public String updateCabinet(){
        return "updateCabinet";
    }

    @GetMapping("/deleteCabinet")
    public String deleteCabinet(){
        return "deleteCabinet";
    }

    @GetMapping("/getCabinet")
    public String getCabinet(){
        return "getCabinet";
    }



    @GetMapping("/addGroup")
    public String addGroup(){
        return "addGroup";
    }

    @GetMapping("/updateGroup")
    public String updateGroup(){
        return "updateGroup";
    }

    @GetMapping("/deleteGroup")
    public String deleteGroup(){
        return "deleteGroup";
    }

    @GetMapping("/addSubject")
    public String addSubject(){
        return "addSubject";
    }

    @GetMapping("/updateSubject")
    public String updateSubject(){
        return "updateSubject";
    }

    @GetMapping("/deleteSubject")
    public String deleteSubject(){
        return "deleteSubject";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(){
        return "addTeacher";
    }

    @GetMapping("/updateTeacher")
    public String updateTeacher(){
        return "updateTeacher";
    }

    @GetMapping("/deleteTeacher")
    public String deleteTeacher(){
        return "deleteTeacher";
    }
}
