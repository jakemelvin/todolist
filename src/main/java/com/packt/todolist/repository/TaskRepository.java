package com.packt.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packt.todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

  List<Task> findByStatus(String status);
  
}
