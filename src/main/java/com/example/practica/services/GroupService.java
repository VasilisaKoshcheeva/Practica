package com.example.practica.services;

import com.example.practica.dto.GroupDTO;
import com.example.practica.entity.Group;
import com.example.practica.repositories.GroupRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GroupService {
    private final GroupRepo groupRepo;
    private final ConverterService converterService;


    public GroupService(GroupRepo gr, ConverterService converterService) {
        groupRepo = gr;
        this.converterService = converterService;
    }

    public Group getGroup(int id) {
        return groupRepo.findById(id).get();
    }

    public Group addGroup(GroupDTO groupDTO) {
        return groupRepo.save(converterService.converterGroupDTO(groupDTO));
    }

    public Group updateGroup(GroupDTO groupDTO) {
        if (groupRepo.findById(groupDTO.getId()).isPresent()) {
            return groupRepo.save(converterService.converterGroupDTOWithId(groupDTO));
        } else {
            return null;
        }
    }

    public boolean deleteGroup(int id) {
        Optional<Group> op = groupRepo.findById(id);
        if (!op.isPresent()) {
            return false;
        }
        groupRepo.delete(op.get());
        return true;
    }
}
