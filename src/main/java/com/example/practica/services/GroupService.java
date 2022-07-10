package com.example.practica.services;

import com.example.practica.entity.Cabinet;
import com.example.practica.entity.Group;
import com.example.practica.repositories.GroupRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GroupService {
    private GroupRepo groupRepo;

    public GroupService(GroupRepo gr){
        groupRepo = gr;
    }
    public Group getGroup(int id){
        return groupRepo.findById(id).get();
    }
    public Group addGroup(Group group){
        return groupRepo.save(group);
    }
    public Group updateGroup(Group group){
        if(groupRepo.findById(group.getId()).isPresent()){
            return groupRepo.save(group);
        }
        else{
            return null;
        }
    }
    public boolean deleteGroup(int id){
        Optional<Group> op = groupRepo.findById(id);
        if(!op.isPresent()){
            return false;
        }
        groupRepo.delete(op.get());
        return true;
    }
}
