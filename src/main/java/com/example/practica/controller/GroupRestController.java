package com.example.practica.controller;

import com.example.practica.entity.Cabinet;
import com.example.practica.entity.Group;
import com.example.practica.services.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    }
    @PostMapping("/group")
    public ResponseEntity<Group> addGroup(@RequestBody Group group){
        return new ResponseEntity(groupService.addGroup(group), HttpStatus.CREATED);
    }
    @PutMapping("/group")
    public ResponseEntity<Group> updateGroup(@RequestBody Group group){
        return new ResponseEntity(groupService.updateGroup(group), HttpStatus.OK);
    }
    @DeleteMapping("/group/{id}")
    public ResponseEntity<Group>  deleteGroup(@PathVariable int id){
        boolean isRemoved = groupService.deleteGroup(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
