package com.accenture.taskwebapp.task;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TaskController {

    TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @RequestMapping("list-task")
    public String  listAllTask(ModelMap model){
        List<Task> task = taskRepository.findByUsername(getLoggedInUsername());
        model.addAttribute("task",task);
        model.put("title","List Taks");

        return "listTask";
    }

    @RequestMapping(value="add-task", method = RequestMethod.GET)
    public String viewaAddTask(ModelMap model)
    {
        String username = getLoggedInUsername();
        Task todo = new Task(0,username,"","", LocalDate.now().plusYears(1),false);
        model.put("task",todo);
        model.put("title","Add Task");
        return "task";
    }

    @RequestMapping(value="add-task",method = RequestMethod.POST)
    public String addTask(ModelMap model , @Valid Task task, BindingResult result)
    {
        if(result.hasErrors()){

            return "task";
        }

        String username = getLoggedInUsername();
        task.setUsername(username);
        task.setCreatedDate(LocalDateTime.now());
        taskRepository.save(task);

        model.put("title","Add todos");
        return "redirect:list-task";
    }

    @RequestMapping(value = "update-task", method = RequestMethod.GET)
    public String showUpdateTask(@RequestParam int id,ModelMap model)
    {
        Task task = taskRepository.findById(id).get();
        model.put("task",task);
        return "task";

    }

    @RequestMapping(value="update-task", method = RequestMethod.POST)
    public String updateTask( ModelMap model, @Valid Task task, BindingResult result)
    {
        if(result.hasErrors()){
            return "task";
        }

        String username = getLoggedInUsername();
        task.setUsername(username);
        taskRepository.save(task);

        return "redirect:list-task";
    }


    @RequestMapping(value= "delete-task")
    public String deleteTask(@RequestParam int id){

        taskRepository.deleteById(id);

        return "redirect:list-task";
    }

    private static String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }



}

