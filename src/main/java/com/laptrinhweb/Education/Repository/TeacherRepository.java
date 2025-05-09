package com.laptrinhweb.Education.Repository;

import com.laptrinhweb.Education.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherByIdTeacher(String idTeacher);
    Optional<Teacher> findByUsernameOrEmail(String username, String email);
}
