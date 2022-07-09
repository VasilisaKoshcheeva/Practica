package com.example.practica.controller;

import com.example.practica.entity.Group;
import com.example.practica.services.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/group-management")
public class GroupRestController {
    private final GroupService groupService;

    public GroupRestController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable int id){
        return new ResponseEntity(groupService.getGroup(id), HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
