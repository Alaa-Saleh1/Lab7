package com.example.learningmanagementsystem.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Instructor {
    @NotEmpty(message = "Id cannot be empty")
    private String instructorId;

    @NotEmpty(message = "Name cannot be empty")
    private String instructorName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String instructorEmail;

    @Positive
    private int instructorCourse = 0;

    private Course courses;


}
