package com.main.service;

import com.main.model.request.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentServiceInterface {
    public List<StudentModel> getStudents();

    public StudentModel addStudent(StudentModel studentModel);

    public void deleteStudent(Long id);

    public void updateStudent(Long id, String name, String email);
}
