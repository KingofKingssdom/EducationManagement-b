package com.laptrinhweb.Education.Repository;

import com.laptrinhweb.Education.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByIdStudent(String idStudent);
    List<Student> findStudentByClassroom(String classroom);
}
