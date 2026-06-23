package com.zerto.myblog.service;

import com.zerto.myblog.entity.Project;
import com.zerto.myblog.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    public List<Project> findAll() {
        return projectMapper.findAll();
    }

    public Project findById(Integer id) {
        return projectMapper.findById(id);
    }

    public void add(Project project) {
        projectMapper.insert(project);
    }

    public void update(Project project) {
        projectMapper.update(project);
    }

    public void delete(Integer id) {
        projectMapper.deleteById(id);
    }
}