package com.example.learningmanagementsystem.Service;

import com.example.learningmanagementsystem.Model.Course;
import com.example.learningmanagementsystem.Model.Instructor;
import com.example.learningmanagementsystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LMSService {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Instructor> instructors = new ArrayList<>();


    //CRED of student

    public ArrayList<Student> getStudent() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(String id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchStudentById(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) {
                return students.get(i);
            }
        }
        return null;
    }

    public ArrayList<Student> haveCourses() {
        ArrayList<Student> studentCourse = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCourse()!=null) {
                studentCourse.add(students.get(i));
            }
        }
        return studentCourse;
    }

    public boolean addCoursebyStudent(String studentId, String courseId) {

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < courses.size(); j++) {
                if (students.get(i).getStudentId().equals(studentId) && courses.get(j).getCourseId().equals(courseId)) {
                    students.get(i).setCourse(courses.get(j));
                    courses.get(j).setCourseCapacity(courses.get(j).getCourseCapacity()-1);
                    return true;
                }
            }
        }
        return false;
    }



    //CRED of Instructor

    public ArrayList<Instructor> getInstructor() {
        return instructors;
    }

    public void addInstructors(Instructor instructor) {
        instructors.add(instructor);
    }

    public boolean updateInstructor(String id, Instructor instructor) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getInstructorId().equals(id)) {
                instructors.set(i, instructor);
                return true;
            }
        }
        return false;
    }

    public boolean deleteInstructor(String id) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getInstructorId().equalsIgnoreCase(id)) {
                instructors.remove(i);
                return true;
            }
        }
        return false;
    }


    public Instructor searchInstructorById(String Id) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getInstructorId().equals(Id)) {
                return instructors.get(i);
            }
        }
        return null;
    }

    public boolean RegistrationCourse(String instructorId, String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < instructors.size(); j++) {
                if (courses.get(i).getCourseId().equals(courseId) && instructors.get(j).getInstructorId().equals(instructorId)) {
                    instructors.get(j).setInstructorCourse(instructors.get(j).getInstructorCourse() + 1);
                    instructors.get(j).setCourses(courses.get(i));
                    courses.get(i).setInstructor(instructors.get(j));
                    return true;
                }
            }
        }
        return true;
    }

    public ArrayList instructorHaveCourse() {
        ArrayList<Instructor> instructorhaveCourse = new ArrayList<>();
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getInstructorCourse()>0) {
                instructorhaveCourse.add(instructors.get(i));
            }
        }
        return instructorhaveCourse;
    }


    //CRED of course

    public ArrayList<Course> getCourse() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean updateCourse(String id, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(id)) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(id)) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public Course searchCourseById(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(id)) {
                return courses.get(i);
            }
        }
        return null;
    }

    public ArrayList<Course> coursefully() {
        ArrayList<Course> coursesfully = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseCapacity()==25) {
                coursesfully.add(courses.get(i));
            }
        }
        return coursesfully;
    }

    public Instructor instructorOfCourse(String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(courseId)) {
                if (courses.get(i).getInstructor()!=null) {
                    return courses.get(i).getInstructor();
                }
            }
        }
        return null;
    }





}
