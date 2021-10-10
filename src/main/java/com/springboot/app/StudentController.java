package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student

    @GetMapping("/student")
    // create method public - need to return student bean - method name getStudent
    //new Student is method
    public Student getStudent(){
        return new Student("Andrew", "Adhikari");

    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();
        students.add(new Student("Harry", "Jack"));
        students.add(new Student("Jordom", "Ranse"));
        students.add(new Student("Jack", "Dorse"));
        students.add(new Student("Lar", "Ry"));
        students.add(new Student("Andrew", "Adhikari"));
        students.add(new Student("Andrew", "Adhikari2"));
        return students;
    }

    //Handle path variable in a request
    //localhost:8080/students/3 ( 3 is path variable ) can be int or string
    //localhost:8080/student/Jack/Dorse

    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);

    }

    //build a rest api to handle query parameter
    // https://localhost:8080/student?firstname=Andrew&lastName=Adhikari
    @GetMapping("/student")
    public Student studentQueryParam(@RequestParam(name = "firstName") String firstName,
                                     @RequestParam(name= "lastName") String lastName){
        return new Student(firstName,lastName);
    }




}
