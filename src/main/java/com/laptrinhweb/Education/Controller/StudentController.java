package com.laptrinhweb.Education.Controller;

import com.laptrinhweb.Education.Model.Student;
import com.laptrinhweb.Education.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // Thêm học sinh
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid
                                        @RequestParam("idStudent") String idStudent,
                                        @RequestParam("fullName") String fullName,
                                        @RequestParam("birth") String birth,
                                        @RequestParam("gender") String gender,
                                        @RequestParam("email") String email,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("classroom") String classroom,
                                        @RequestParam("studyDay") String studyDay,
                                        @RequestParam("address") String address,
                                        @RequestParam(value = "avatar", required = false) MultipartFile avatar){
        try{
            Student student = new Student();
            student.setIdStudent(idStudent);
            student.setFullName(fullName);
            student.setBirth(birth);
            student.setGender(gender);
            student.setEmail(email);
            student.setPhone(phone);
            student.setClassroom(classroom);
            student.setStudyDay(studyDay);
            student.setAddress(address);
            Student addStudent = studentService.saveStudent(student,avatar);
            return ResponseEntity.ok(addStudent);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Failed to upload avatar");
    }

    // Lấy toan bộ học sinh
    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return studentService.findAllStudent();
    }
    // Lấy học sinh theo id
    @GetMapping("/{id}")
    private Student getStudentById(@PathVariable int id){
        return studentService.findStudentById(id);
    }
    // Cập nhập học sinh theo id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable int id,
                                               @RequestParam("idStudent") String idStudent,
                                               @RequestParam("fullName") String fullName,
                                               @RequestParam("birth") String birth,
                                               @RequestParam("gender") String gender,
                                               @RequestParam("email") String email,
                                               @RequestParam("phone") String phone,
                                               @RequestParam("classroom") String classroom,
                                               @RequestParam("studyDay") String studyDay,
                                               @RequestParam("address") String address,
                                               @RequestParam(value = "avatar", required = false) MultipartFile avatar) {
        Student existingStudent = studentService.findStudentById(id);
        if(existingStudent == null){
            return  ResponseEntity.notFound().build();
        }
        try {
            existingStudent.setIdStudent(idStudent);
            existingStudent.setFullName(fullName);
            existingStudent.setBirth(birth);
            existingStudent.setGender(gender);
            existingStudent.setEmail(email);
            existingStudent.setPhone(phone);
            existingStudent.setClassroom(classroom);
            existingStudent.setStudyDay(studyDay);
            existingStudent.setAddress(address);

            Student updateStudent = studentService.saveStudent(existingStudent, avatar);
            return ResponseEntity.ok(updateStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Failed to upload avatar");
    }

    // Lấy student theo idStudent
    @GetMapping("/getId/{idStudent}")
    public Student getSegetStudentByIdStudent(@PathVariable String idStudent) {
        return studentService.findStudentByIdStudent(idStudent);
    }
    // Lay so luong hoc sinh
    @GetMapping("/count")
    public long countStudents(){
        return studentService.countStudent();
    }
    // Tim kiem hoc sinh theo lop
    @GetMapping("/getClassroom/{classroom}")
    public List<Student> getStudentByClassroom(@PathVariable String classroom){
        return studentService.findStudentByClassroom(classroom);
    }
}
