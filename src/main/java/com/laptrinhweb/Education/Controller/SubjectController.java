package com.laptrinhweb.Education.Controller;

import com.laptrinhweb.Education.Model.Subject;
import com.laptrinhweb.Education.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private SubjectService subjectService;
    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    // Them danh sach mon hoc
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestParam("subjectId") String subjectId,
                                        @RequestParam("subjectName") String subjectName) {
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        subject.setSubjectName(subjectName);
        Subject addSubject = subjectService.saveSubject(subject);
        return ResponseEntity.ok(addSubject);
    }
    @GetMapping("/count")
    public long countSubject(){
        return subjectService.countSubject();
    }
    // Lay toan bo mon hoc
    @GetMapping("/getAll")
    public List<Subject> getAllSubject(){
        return subjectService.findAllSubject();
    }
}
