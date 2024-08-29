package com.swino.exoproject.controller;

import com.swino.exoproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PutMapping("/tasks/{taskId}")
    public String updateTask(@PathVariable String taskId, @RequestParam String status) {
        projectService.updateTask(taskId, status);
        return "Task " + taskId + " updated to status: " + status;
    }

    @PutMapping("/{projectId}/status")
    public String updateProjectStatus(@PathVariable String projectId, @RequestParam String status) {
        projectService.updateProjectStatus(projectId, status);
        return "Project " + projectId + " updated to status: " + status;
    }
}