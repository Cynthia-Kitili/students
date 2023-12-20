package com.main.repo;

import com.main.model.request.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Long> {
    @Query("SELECT s FROM StudentModel s WHERE s.email = ?1")
    Optional<StudentModel> findStudentModelByEmail(String email);

}
