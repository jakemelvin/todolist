package com.packt.todolist.mapper;

import com.packt.todolist.dto.TaskRequestDto;
import com.packt.todolist.model.Task;

public class TaskMapper {
  public static Task toEntity(TaskRequestDto dto) {
    Task newTask = new Task();
    newTask.setDescription(dto.getDescription());
    newTask.setTitle(dto.getTitle());
    newTask.setStatus(dto.getStatus());
    return newTask;
  }
}
