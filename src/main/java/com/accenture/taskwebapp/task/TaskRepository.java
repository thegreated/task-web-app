package com.accenture.taskwebapp.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    public List<Task> findByUsername(String username);
}
