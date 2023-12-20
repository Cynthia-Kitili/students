package com.main.controller;

import com.main.model.request.StudentModel;
import com.main.service.StudentServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentServiceInterface studentServiceInterface;

    public StudentController(StudentServiceInterface studentServiceInterface) {
        this.studentServiceInterface = studentServiceInterface;
    }

    @GetMapping
    public List<StudentModel> getStudents(){
        return studentServiceInterface.getStudents();
    }

    @PostMapping
    public StudentModel addStudent(@RequestBody StudentModel studentModel){
        return studentServiceInterface.addStudent(studentModel);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentServiceInterface.deleteStudent(id);
    }

    @PutMapping("{id}")
    public void updateStudent( @PathVariable Long id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email){
        studentServiceInterface.updateStudent(id, name, email);

    }
}
