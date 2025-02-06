package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.Semester;
import com.laptrinhweb.Education.Repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {
    private SemesterRepository semesterRepository;
    @Autowired
    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }
    // them hoc ki
    public Semester saveSemester (Semester semester){
        return semesterRepository.save(semester);
    }
    // Dem so luong học kì
    public long countSemester(){
        return semesterRepository.count();
    }
    // Lay toan bo hoc ki
    public List<Semester> findAllSemester(){
        return semesterRepository.findAll();
    }
}
