package com.main.service.serviceImpl;

import com.main.model.request.StudentModel;
import com.main.repo.StudentRepo;
import com.main.service.StudentServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentServiceInterface {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentModel> getStudents(){
        return studentRepo.findAll();
    }

    @Override
    public StudentModel addStudent(StudentModel studentModel) {
        Optional<StudentModel> studentModelOptional = studentRepo.findStudentModelByEmail(studentModel.getEmail());
        if(studentModelOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        return studentRepo.save(studentModel);
    }

    @Override
    public void deleteStudent(Long id) {
        boolean exists = studentRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("student with id" + id + "does not exist.");
        }
        studentRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        StudentModel studentModel = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + id + "does not exist"
                ));
        if(name != null && name.length() >0 && !Objects.equals(studentModel.getName(), name)){
            studentModel.setName(name);
        }
        if(email != null && email.length() >0 && !Objects.equals(studentModel.getEmail(), email)){
            Optional<StudentModel> studentModelOptional = studentRepo.findStudentModelByEmail(studentModel.getEmail());
            if (studentModelOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            studentModel.setEmail(email);
        }

    }
}
