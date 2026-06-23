package com.zerto.myblog.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Project {
    private Integer id;
    private String name;
    private String description;
    private String techStack;
    private String githubUrl;
    private String imageUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}