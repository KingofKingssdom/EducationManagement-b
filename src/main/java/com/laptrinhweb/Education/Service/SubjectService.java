package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.Subject;
import com.laptrinhweb.Education.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;
    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    // Them list mon hoc
    public Subject saveSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    // Dem so luong mon hoc
    public long countSubject(){
        return subjectRepository.count();
    }
    // Lay toan bo mon hoc
    public List<Subject> findAllSubject (){
        return  subjectRepository.findAll();
    }
}
