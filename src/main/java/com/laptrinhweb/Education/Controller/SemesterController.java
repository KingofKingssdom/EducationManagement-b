package com.laptrinhweb.Education.Controller;

import com.laptrinhweb.Education.Model.Semester;
import com.laptrinhweb.Education.Service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semester")
@CrossOrigin(origins = "http://localhost:3000")
public class SemesterController {
    private SemesterService semesterService;
    @Autowired
    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }
    // Them hoc ki
    @PostMapping("/add")
    public ResponseEntity<?> addSemester(@RequestParam("semesterName") String semesterName,
                                         @RequestParam("year") String year){
        Semester semester = new Semester();
        semester.setSemesterName(semesterName);
        semester.setYear(year);
        Semester addSemester = semesterService.saveSemester(semester);
        return ResponseEntity.ok(addSemester);
    }
    // Dem so luong hoc ki
    @GetMapping("/count")
    public long countSemester(){
        return semesterService.countSemester();
    }
    // Lay toan bo hoc ki
    @GetMapping("/getAll")
    public List<Semester> getAllSemester(){
        return semesterService.findAllSemester();
    }
}
