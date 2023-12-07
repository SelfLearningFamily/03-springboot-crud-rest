package com.zbrickx.crudrest01.rest;

import com.zbrickx.crudrest01.Student;
import com.zbrickx.crudrest01.response.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;
    //PostConstruct only get called once after the bean is created
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("zaki","Siddiqui"));
        students.add(new Student("Abdul","Hadi"));
        students.add(new Student("Saad","Ullah"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){


        return students;
    }

    @GetMapping("/students/{studentid}")
    public Student getStudent(@PathVariable int studentid) {
        if(studentid < 0 || studentid >= students.size())
            throw new StudentNotFoundException("student id not found_ "+studentid);
        return students.get(studentid);
    }


}
