package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Dto.MarkPostDto;
import com.laptrinhweb.Education.Model.Mark;
import com.laptrinhweb.Education.Model.Semester;
import com.laptrinhweb.Education.Model.Student;
import com.laptrinhweb.Education.Model.Subject;
import com.laptrinhweb.Education.Repository.MarkRepository;
import com.laptrinhweb.Education.Repository.SemesterRepository;
import com.laptrinhweb.Education.Repository.StudentRepository;
import com.laptrinhweb.Education.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    private MarkRepository markRepository;
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;
    private SemesterRepository semesterRepository;
    @Autowired
    public MarkService(MarkRepository markRepository, StudentRepository studentRepository, SubjectRepository subjectRepository, SemesterRepository semesterRepository) {
        this.markRepository = markRepository;
        this.studentRepository = studentRepository;
        this.semesterRepository = semesterRepository;
        this.subjectRepository = subjectRepository;
    }
    // Phuong thuc save diem
    public Mark saveMark(MarkPostDto markPostDto){
        Mark mark = new Mark();
        mark.setFifteenMinutes(markPostDto.getFifteenMinutes());
        mark.setFortyFiveMinutes(markPostDto.getFortyFiveMinutes());
        mark.setSemesterMark(markPostDto.getSemesterMark());

        Student student = studentRepository.findById(markPostDto.getStudentId()).orElseThrow();
        Subject subject = subjectRepository.findById(markPostDto.getSubjectId()).orElseThrow();
        Semester semester = semesterRepository.findById(markPostDto.getSemesterId()).orElseThrow();

        mark.setStudent(student);
        mark.setSubject(subject);
        mark.setSemester(semester);

        return markRepository.save(mark);
    }
    // Phuong thuc lay diem theo id Student
    public List<Object[]> findMarkByFilter(String classroom, String subjectName, String semesterName, String year) {
        return markRepository.findMarksByClassroomAndSubject(classroom, subjectName, semesterName, year);
    }
}
