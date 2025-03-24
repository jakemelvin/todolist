package com.packt.todolist.service;

import java.util.List;

import com.packt.todolist.dto.TaskRequestDto;
import com.packt.todolist.model.Task;

public interface ITaskService {
  Task createTask(TaskRequestDto dto);

  List<Task> getAllTasks();

  List<Task> getTaskByStatus(String status);

  void deleteTask(Long taskId);

  Task updateTask(TaskRequestDto dto, Long taskId);
}
