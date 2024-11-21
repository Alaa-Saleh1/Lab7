package com.example.learningmanagementsystem.LMSController;

import com.example.learningmanagementsystem.ApiResponse.ApiResponse;
import com.example.learningmanagementsystem.Model.Course;
import com.example.learningmanagementsystem.Model.Instructor;
import com.example.learningmanagementsystem.Model.Student;
import com.example.learningmanagementsystem.Service.LMSService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/learning-management-system")
public class LMSController {

   private final LMSService lmsService;

   //CRUD Student

    @GetMapping("/student/get")
    public ResponseEntity<?> getStudent() {
        ArrayList students = lmsService.getStudent();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/student/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        lmsService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated = lmsService.updateStudent(id, student);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        boolean idDeleted = lmsService.deleteStudent(id);
        if (idDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @GetMapping("/student/search/{id}")
    public ResponseEntity<?> searchStudent(@PathVariable String id) {
        Student isfound = lmsService.searchStudentById(id);
        if (isfound == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
        }
        return ResponseEntity.status(200).body(isfound);
    }

    @GetMapping("/student/havecourses")
    public ResponseEntity<?> havecourses() {
        ArrayList<Student> haveCourses = lmsService.haveCourses();
        return ResponseEntity.status(200).body(haveCourses);
    }

    @PutMapping("/student/addcoursebystudent/{idstudent}/{idcourse}")
    public ResponseEntity<?> addCourseByStudent(@PathVariable String idstudent, @PathVariable String idcourse) {
        boolean isadd=lmsService.addCoursebyStudent(idstudent,idcourse);
        if (isadd) {
            return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }



    //crud instructor

    @GetMapping("/instructor/get")
    public ResponseEntity<?> getInstructor() {
        ArrayList instructor = lmsService.getInstructor();
        return ResponseEntity.status(200).body(instructor);
    }

    @PostMapping("/instructor/add")
    public ResponseEntity<?> addInstructor(@RequestBody @Valid Instructor instructor, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        lmsService.addInstructors(instructor);
        return ResponseEntity.status(200).body(new ApiResponse("Instructor added successfully"));
    }

    @PutMapping("/instructor/update/{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable String id, @RequestBody @Valid Instructor instructor, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated = lmsService.updateInstructor(id, instructor);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Instructor updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @DeleteMapping("/instructor/delete/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable String id) {
        boolean idDeleted = lmsService.deleteInstructor(id);
        if (idDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Instructor deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @GetMapping("/instructor/search/{id}")
    public ResponseEntity<?> searchById(@PathVariable String id) {
        Instructor isfound = lmsService.searchInstructorById(id);
        if (isfound == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Instructor not found"));
        }
        return ResponseEntity.status(200).body(isfound);
    }

    @PutMapping("/instructor/{instructorId}/{courseId}")
    public ResponseEntity<?> RegistrationCourse(@PathVariable String instructorId, @PathVariable String courseId) {
        boolean registration = lmsService.RegistrationCourse(instructorId, courseId);
        if (registration) {
            return ResponseEntity.status(200).body(new ApiResponse("Course registration successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
    }

    @GetMapping("/instructor/have-course")
    public ResponseEntity<?> haveCourse() {
        ArrayList<Instructor> have_course=lmsService.instructorHaveCourse();
        return ResponseEntity.status(200).body(have_course);
    }

    //crud course

    @GetMapping("/course/get")
    public ResponseEntity<?> getCourse() {
        ArrayList course = lmsService.getCourse();
        return ResponseEntity.status(200).body(course);
    }

    @PostMapping("/course/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course, Errors errors) {
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        lmsService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/course/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable String id, @RequestBody @Valid Course course, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated = lmsService.updateCourse(id, course);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @DeleteMapping("/course/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id) {
        boolean idDeleted = lmsService.deleteCourse(id);
        if (idDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @GetMapping("/course/search/{id}")
    public ResponseEntity<?> searchCourseById(@PathVariable String id) {
        Course course = lmsService.searchCourseById(id);
        if (course == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
        }
        return ResponseEntity.status(200).body(course);
    }

    @GetMapping("/course/fully")
    public ResponseEntity<?> courseFully() {
        ArrayList<Course> fully= lmsService.coursefully();
        return ResponseEntity.status(200).body(fully);
    }

    @GetMapping("/course/instructor/{id}")
    public ResponseEntity<?> instructorOfCourse(@PathVariable String id) {
        Instructor instructor = lmsService.instructorOfCourse(id);
        if (instructor == null) {
            return ResponseEntity.status(400).body(new ApiResponse("There is no instructor for this course"));
        }
        return ResponseEntity.status(200).body(instructor);
    }




}
