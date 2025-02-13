package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.Student;
import com.laptrinhweb.Education.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // Thêm học sinh
    public Student saveStudent (Student student, MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            student.setAvatar(file.getBytes());
        }
        Student saveStudent = studentRepository.save(student);
        // Them tai khoan mac dinh
        return saveStudent;
    }
    // Lấy toàn bộ học sinh
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    // Lấy hc sinh theo id
    public Student findStudentById(int id) {
        return  studentRepository.findById(id).orElseThrow();
    }
    // Cập nhập học sinh theo id
    public Student updateStudentById(int id, Student student, MultipartFile file){
        Student existingStudent = studentRepository.findById(id).orElseThrow();
        try{
            existingStudent.setIdStudent(student.getIdStudent());
            existingStudent.setFullName(student.getFullName());
            existingStudent.setBirth(student.getBirth());
            existingStudent.setGender(student.getGender());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhone(student.getPhone());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setStudyDay(student.getStudyDay());
            existingStudent.setAvatar(file.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return studentRepository.save(existingStudent);
    }
    // Lấy student theo idStudent
    public Student findStudentByIdStudent(String idStudent){
        return studentRepository.findByIdStudent(idStudent);
    }

    // Đém so luong học sinh
    public long countStudent(){
        return studentRepository.count();
    }
    // Tim kiem học sinh theo lop
    public List<Student> findStudentByClassroom (String classroom){
        return studentRepository.findStudentByClassroom(classroom);
    }
}
