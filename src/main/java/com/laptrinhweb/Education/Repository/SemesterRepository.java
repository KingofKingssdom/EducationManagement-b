package com.laptrinhweb.Education.Repository;

import com.laptrinhweb.Education.Model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester,Integer> {
}
