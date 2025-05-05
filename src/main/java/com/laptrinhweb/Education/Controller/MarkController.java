package com.laptrinhweb.Education.Controller;

import com.laptrinhweb.Education.Dto.MarkPostDto;
import com.laptrinhweb.Education.Model.Mark;
import com.laptrinhweb.Education.Model.Semester;
import com.laptrinhweb.Education.Model.Student;
import com.laptrinhweb.Education.Model.Subject;
import com.laptrinhweb.Education.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
@CrossOrigin(origins = "http://localhost:3000")
public class MarkController {
    private MarkService markService;
    @Autowired
    public MarkController(MarkService markService) {
        this.markService = markService;
    }
    // Phuong thuc them diem
    @PostMapping("/add")
    public Mark addMark(@RequestBody MarkPostDto markPostDto){
        return markService.saveMark(markPostDto);
    }
    // Lay diem join vơi bảng student
    @GetMapping("/student/filter")
    public ResponseEntity<List<Object[]>> findMarkByFilter(
            @RequestParam String classroom,
            @RequestParam String subjectName,
            @RequestParam String semesterName,
            @RequestParam String year
    ) {
        List<Object[]> marks = markService.findMarkByFilter(classroom, subjectName, semesterName, year);
        return ResponseEntity.ok(marks);
    }
}
