package com.accenture.taskwebapp.task;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private int Id;

    private String username;
    @NotBlank(message = "Please enter valid title")
    @Size(min=5, message = "Title should be atleast 5 characters")
    private String title;
    private String description;
    private  LocalDate targetDate;
    private boolean done;

    private LocalDateTime createdDate;
    private LocalDateTime updateDate;


    public Task(int id, String username,String title, String description, LocalDate targetDate, boolean done) {
        super();
        Id = id;
        this.username = username;
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;

    }

    public Task(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", targetDate='" + targetDate + '\'' +
                ", done=" + done +
                ", createdDate=" + createdDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
