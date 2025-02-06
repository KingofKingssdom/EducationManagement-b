package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.Mark;
import com.laptrinhweb.Education.Repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    private MarkRepository markRepository;
    @Autowired
    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }
    // Phuong thuc save diem
    public Mark saveMark(Mark mark){
        return  markRepository.save(mark);
    }
    // Phuong thuc lay diem theo id Student
    public List<Object[]> findMarkByFilter(String classroom, String subjectName, String semesterName, String year) {
        return markRepository.findMarksByClassroomAndSubject(classroom, subjectName, semesterName, year);
    }
}
