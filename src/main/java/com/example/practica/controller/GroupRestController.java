package com.example.practica.controller;

import com.example.practica.dto.GroupDTO;
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
    public ResponseEntity<GroupDTO> getGroup(@PathVariable int id){
        return new ResponseEntity(groupService.getGroup(id), HttpStatus.OK);
    }
    @PostMapping("/group")
    public ResponseEntity<GroupDTO> addGroup(@RequestBody GroupDTO groupDTO){
        return new ResponseEntity(groupService.addGroup(groupDTO), HttpStatus.CREATED);
    }
    @PutMapping("/group")
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO groupDTO){
        return new ResponseEntity(groupService.updateGroup(groupDTO), HttpStatus.OK);
    }
    @DeleteMapping("/group/{id}")
    public ResponseEntity<GroupDTO>  deleteGroup(@PathVariable int id){
        boolean isRemoved = groupService.deleteGroup(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
