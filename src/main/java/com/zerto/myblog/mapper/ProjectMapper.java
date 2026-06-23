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
            "VALUES(#{name}, #{description}, #{techStack}, #{githubUrl}, #{imageUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Project project);

    @Update("UPDATE project SET name=#{name}, description=#{description}, tech_stack=#{techStack}, " +
            "github_url=#{githubUrl}, image_url=#{imageUrl} WHERE id=#{id}")
    int update(Project project);

    @Delete("DELETE FROM project WHERE id = #{id}")
    int deleteById(Integer id);
}