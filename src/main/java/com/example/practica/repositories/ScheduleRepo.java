package com.example.practica.repositories;

import com.example.practica.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {
    Schedule findById(int id);
}