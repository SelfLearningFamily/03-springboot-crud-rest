package com.zbrickx.crudrest01.rest;

import com.zbrickx.crudrest01.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Student getStudent(@PathVariable int studentid){

        return students.get(studentid);
    }
}
