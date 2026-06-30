package com.zerto.myblog.mapper;

import com.zerto.myblog.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("SELECT * FROM project ORDER BY id DESC")
    List<Project> findAll();

    @Select("SELECT * FROM project WHERE id = #{id}")
    Project findById(Integer id);

    @Insert("INSERT INTO project(name, description, tech_stack, github_url, image_url) " +
            "VALUES(#{name}, #{description}, #{techStack}, #{githubUrl}, #{imageUrl}) " +
            "RETURNING id")  // PostgreSQL 用 RETURNING 返回自增主键
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Project project);

    @Update("UPDATE project SET name=#{project.name}, description=#{project.description}, tech_stack=#{project.techStack}, " +
            "github_url=#{project.githubUrl}, image_url=#{project.imageUrl} WHERE id=#{project.id}")
    int update(@Param("project") Project project);

    @Delete("DELETE FROM project WHERE id = #{id}")
    int deleteById(Integer id);
}