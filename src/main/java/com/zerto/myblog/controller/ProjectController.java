package com.zerto.myblog.controller;

import com.zerto.myblog.config.AuthRequired;
import com.zerto.myblog.dto.Result;
import com.zerto.myblog.entity.Project;
import com.zerto.myblog.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // 获取所有项目
    @GetMapping
    public Result<List<Project>> list() {
        return Result.success(projectService.findAll());
    }

    // 获取单个项目
    @GetMapping("/{id}")
    public Result<Project> getById(@PathVariable Integer id) {
        return Result.success(projectService.findById(id));
    }

    @PostMapping
    @AuthRequired
    public Result<Void> add(@RequestBody Project project) {
        projectService.add(project);
        return Result.success(null);
    }

    @PutMapping("/{id}")
    @AuthRequired
    public Result<Void> update(@PathVariable Integer id, @RequestBody Project project) {
        project.setId(id);
        projectService.update(project);
        return Result.success(null);
    }

    @DeleteMapping("/{id}")
    @AuthRequired
    public Result<Void> delete(@PathVariable Integer id) {
        projectService.delete(id);
        return Result.success(null);
    }
}