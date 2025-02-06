package com.laptrinhweb.Education.Controller;

import com.laptrinhweb.Education.Model.Teacher;
import com.laptrinhweb.Education.Service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    //    Thêm giáo viên
    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@Valid
                                        @RequestParam("idTeacher") String idTeacher,
                                        @RequestParam("fullName") String fullName,
                                        @RequestParam("birthDay") String birirthDay,
                                        @RequestParam("gender") String gender,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("email") String email,
                                        @RequestParam("classroom") String classroom,
                                        @RequestParam("address") String address,
                                        @RequestParam("workDay") String workDay,
                                        @RequestParam("subject") String subject,
                                        @RequestParam(value = "avatar",  required = false) MultipartFile avtar
    ){
        try{
            Teacher teacher = new Teacher();
            teacher.setIdTeacher(idTeacher);
            teacher.setFullName(fullName);
            teacher.setBirthDay(birirthDay);
            teacher.setGender(gender);
            teacher.setPhone(phone);
            teacher.setEmail(email);
            teacher.setClassroom(classroom);
            teacher.setAddress(address);
            teacher.setWorkDay(workDay);
            teacher.setSubject(subject);
            Teacher addTeacher = teacherService.saveTeacher(teacher,avtar);
            return ResponseEntity.ok(addTeacher);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Failed to upload avatar");
    }
    // Cập nhập theo Id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacherById(@PathVariable int id,
                                               @RequestParam("idTeacher") String idTeacher,
                                               @RequestParam("fullName") String fullName,
                                               @RequestParam("birthDay") String birthDay,
                                               @RequestParam("gender") String gender,
                                               @RequestParam("phone") String phone,
                                               @RequestParam("email") String email,
                                               @RequestParam("classroom") String classroom,
                                               @RequestParam("address") String address,
                                               @RequestParam("workDay") String workDay,
                                               @RequestParam("subject") String subject,
                                               @RequestParam(value = "avatar", required = false) MultipartFile avatar
    ){
        Teacher existingTeacher = teacherService.findTeacherById(id);
        if(existingTeacher == null){
            return ResponseEntity.notFound().build();
        }
        try {
            existingTeacher.setIdTeacher(idTeacher);
            existingTeacher.setFullName(fullName);
            existingTeacher.setBirthDay(birthDay);
            existingTeacher.setGender(gender);
            existingTeacher.setPhone(phone);
            existingTeacher.setEmail(email);
            existingTeacher.setClassroom(classroom);
            existingTeacher.setAddress(address);
            existingTeacher.setWorkDay(workDay);
            existingTeacher.setSubject(subject);

            Teacher addTeacher = teacherService.saveTeacher(existingTeacher,avatar);
            return ResponseEntity.ok(addTeacher);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Failed to upload avatar");
    }
    // Lấy giáo viên theo itTeacher
    @GetMapping("/getId/{idTeacher}")
    public Teacher getTeacherByIdTeacher(@PathVariable String idTeacher){
        return teacherService.findTeacherByidTeacher(idTeacher);
    }
    // Lấy toàn bộ giao vien
    @GetMapping("/getAll")
    public List<Teacher> getAllTeacher(){
        return teacherService.findAll();
    }
    // Lay theo id
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id){
        return teacherService.findTeacherById(id);
    }
    // Dem so luong giao vien
    @GetMapping("/count")
    public long countTeacher(){
        return teacherService.countTeacher();
    }
}
