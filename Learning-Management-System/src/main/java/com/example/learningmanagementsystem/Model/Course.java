package com.example.learningmanagementsystem.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Course {
    @NotEmpty(message = "Id cannot be empty")
    private String courseId;

    @NotEmpty(message = "Name of course cannot be empty")
    @Size(min = 4, max = 30)
    private String courseName;

    @Size(min = 20, max = 120)
    private String courseDescription;

    @Max(value = 25 , message = "course cannot be more than 25 student")
    private int courseCapacity;

    private Instructor instructor;



}
