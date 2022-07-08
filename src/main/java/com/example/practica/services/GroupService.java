package com.example.practica.services;

import com.example.practica.entity.Group;
import com.example.practica.repositories.GroupRepo;
import org.springframework.stereotype.Service;


@Service
public class GroupService {
    private GroupRepo groupRepo;

    public GroupService(GroupRepo gr){
        groupRepo = gr;
    }
    public Group getGroup(int id){
        return groupRepo.findById(id);
    }
}
