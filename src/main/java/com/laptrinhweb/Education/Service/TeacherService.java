package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.Teacher;
import com.laptrinhweb.Education.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    private AccountService accountService;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository, AccountService accountService) {
        this.teacherRepository = teacherRepository;
        this.accountService = accountService;
    }
    //    Thêm giáo viên
    @Transactional
    public Teacher saveTeacher(Teacher teacher, MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            teacher.setAvatar(file.getBytes());
        }
        // Luu giao vien truoc
        Teacher saveTeacher = teacherRepository.save(teacher);
        // Luu tai khoan tu dong
        accountService.saveAccountForTeacher(saveTeacher);
        return  saveTeacher;
    }
    // Lấy theo id
    public Teacher findTeacherById(int id){
        return teacherRepository.findById(id).orElseThrow();
    }

    // Cập nhập theo id
    public Teacher updateById(int id,Teacher teacher, MultipartFile file) throws IOException {
        Teacher existingTeacher = teacherRepository.findById(id).orElseThrow();
        if(existingTeacher == null){
            return existingTeacher;
        }
        try {
            existingTeacher.setIdTeacher(teacher.getIdTeacher());
            existingTeacher.setFullName(teacher.getFullName());
            existingTeacher.setBirthDay(teacher.getBirthDay());
            existingTeacher.setBirthDay(teacher.getBirthDay());
            existingTeacher.setGender(teacher.getGender());
            existingTeacher.setPhone(teacher.getPhone());
            existingTeacher.setEmail(teacher.getEmail());
            existingTeacher.setClassroom(teacher.getClassroom());
            existingTeacher.setAddress(teacher.getAddress());
            existingTeacher.setWorkDay(teacher.getWorkDay());
            existingTeacher.setSubject(teacher.getSubject());
            existingTeacher.setAvatar(file.getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }
        return teacherRepository.save(existingTeacher);
    }
    // Lấy theo IdTeacher
    public Teacher findTeacherByidTeacher (String idTeacher){
        return teacherRepository.findTeacherByIdTeacher(idTeacher);
    }
    // Lấy tat ca giáo vien
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
    // Dem so giao vien
    public long countTeacher(){
        return teacherRepository.count();
    }
}
