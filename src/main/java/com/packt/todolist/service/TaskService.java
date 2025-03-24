package com.packt.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packt.todolist.dto.TaskRequestDto;
import com.packt.todolist.exceptions.ResourceNotFoundException;
import com.packt.todolist.mapper.TaskMapper;
import com.packt.todolist.model.Task;
import com.packt.todolist.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
  private final TaskRepository taskRepository;

  @Override
  public Task createTask(TaskRequestDto dto) {
    return taskRepository.save(TaskMapper.toEntity(dto));
  }

  @Override
  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  @Override
  public List<Task> getTaskByStatus(String status) {
    try {
      return taskRepository.findByStatus(status);
    } catch (Exception e) {
      throw new ResourceNotFoundException(e.getMessage());
    }
  }

  @Override
  public void deleteTask(Long taskId) {
    try {
      taskRepository.deleteById(taskId);
    } catch (ResourceNotFoundException e) {
      throw new ResourceNotFoundException("Task not found!");
    }
  }

  @Override
  public Task updateTask(TaskRequestDto dto, Long taskId) {
    Task taskToUpdate = taskRepository.findById(taskId)
        .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    taskToUpdate.setDescription(dto.getDescription());
    taskToUpdate.setStatus(dto.getStatus());
    taskToUpdate.setTitle(dto.getTitle());
    return taskRepository.save(taskToUpdate);
  }

}
