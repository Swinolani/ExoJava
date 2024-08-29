package com.swino.exoproject.service;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    public void updateTask(String taskId, String newStatus) {
        System.out.println("Task " + taskId + " updated to status: " + newStatus);
    }

    public void updateProjectStatus(String projectId, String newStatus) {
        System.out.println("Project " + projectId + " updated to status: " + newStatus);
    }
}