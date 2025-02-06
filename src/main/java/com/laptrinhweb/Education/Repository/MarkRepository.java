package com.laptrinhweb.Education.Repository;

import com.laptrinhweb.Education.Model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Query("SELECT s.fullName, s.classroom, s.idStudent, "
            + "m.fifteenMinutes, m.fortyFiveMinutes, m.semesterMark, "
            + "sub.subjectName, "
            +" se.semesterName, se.year "
            + "FROM Mark m "
            + "JOIN m.student s "
            + "JOIN m.subject sub "
            + "JOIN m.semester se "
            + "WHERE s.classroom = :classroom AND sub.subjectName = :subjectName AND se.semesterName=:semesterName AND se.year=:year")
    List<Object[]> findMarksByClassroomAndSubject(@Param("classroom") String classroom,
                                                  @Param("subjectName") String subjectName,
                                                  @Param("semesterName") String semesterName,
                                                  @Param("year") String year);
}
