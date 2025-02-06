package com.laptrinhweb.Education.Controller;

import com.laptrinhweb.Education.Model.Mark;
import com.laptrinhweb.Education.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {
    private MarkService markService;
    @Autowired
    public MarkController(MarkService markService) {
        this.markService = markService;
    }
    // Phuong thuc them truong vao anh
    @PostMapping("/add")
    public Mark addMark(@RequestParam Mark mark){
        return markService.saveMark(mark);
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
