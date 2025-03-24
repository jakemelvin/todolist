package com.packt.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.todolist.dto.TaskRequestDto;
import com.packt.todolist.exceptions.ResourceNotFoundException;
import com.packt.todolist.response.ApiResponse;
import com.packt.todolist.service.ITaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/tasks")
public class TaskController {
  private final ITaskService taskService;

  @GetMapping
  public ResponseEntity<ApiResponse> getAllTasks() {
    return ResponseEntity.ok(new ApiResponse("Task fetched", taskService.getAllTasks()));
  }

  @GetMapping("/get-by")
  public ResponseEntity<ApiResponse> getTasksByStatus(@RequestParam String status) {
    try {
      return ResponseEntity
          .ok(new ApiResponse("Task fetched by status: " + status, taskService.getTaskByStatus(status)));
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
    }
  }

  @DeleteMapping("/delete")
  public ResponseEntity<ApiResponse> deleteTask(@RequestParam Long taskId) {
    try {
      taskService.deleteTask(taskId);
      return ResponseEntity.ok(new ApiResponse("Task deleted successfully", null));
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
    }
  }

  @PostMapping("/create")
  public ResponseEntity<ApiResponse> createTask(@RequestBody TaskRequestDto dto) {
    return ResponseEntity.ok(new ApiResponse("Task created!", taskService.createTask(dto)));
  }

  @PutMapping("/update")
  public ResponseEntity<ApiResponse> updateTask(@RequestParam Long taskId, @RequestBody TaskRequestDto dto) {
    try {
      return ResponseEntity.ok(new ApiResponse("Task updated!", taskService.updateTask(dto, taskId)));
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
    }
  }
}
