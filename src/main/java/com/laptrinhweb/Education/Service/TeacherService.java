package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.Role;
import com.laptrinhweb.Education.Model.Teacher;
import com.laptrinhweb.Education.Repository.RoleRepository;
import com.laptrinhweb.Education.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
    //    Thêm giáo viên
    @Transactional
    public Teacher saveTeacher(Teacher teacher, MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            teacher.setAvatar(file.getBytes());
        }
        // Luu giao vien truoc
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        // 1. Kiểm tra và tạo Role
        Role teacherRole = roleRepository.findByName("ROLE_TEACHER").orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName("ROLE_TEACHER");
            return roleRepository.save(newRole);
        });

        // 2. Gán Role cho Admin
        Set<Role> roles = new HashSet<>();  // Sử dụng HashSet để tránh trùng lặp
        roles.add(teacherRole);
        teacher.setRoles(roles);
        Teacher saveTeacher = teacherRepository.save(teacher);
        // Luu tai khoan tu dong
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
