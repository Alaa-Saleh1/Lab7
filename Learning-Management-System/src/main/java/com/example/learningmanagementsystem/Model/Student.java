package com.example.learningmanagementsystem.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "Id cannot be empty")
    private String studentId;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 4, max = 30)
    private String studentName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String studentEmail;

    private Course course;

}
