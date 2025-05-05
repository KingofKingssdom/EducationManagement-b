package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.Admin;
import com.laptrinhweb.Education.Model.Role;
import com.laptrinhweb.Education.Repository.AdminRepository;
import com.laptrinhweb.Education.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    private RoleRepository roleRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }
    // Them admin
    @Transactional
    public Admin saveAdmin(Admin admin, MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            admin.setAvatar(file.getBytes());
        }

        // 1. Kiểm tra và tạo Role
        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName("ROLE_ADMIN");
            return roleRepository.save(newRole);
        });

        // 2. Gán Role cho Admin
        Set<Role> roles = new HashSet<>();  // Sử dụng HashSet để tránh trùng lặp
        roles.add(adminRole);
        admin.setRoles(roles);
        Admin saveAdmin = adminRepository.save(admin);
        return  saveAdmin;
    }
    // Lay theo id
    public Admin findById(int id){
        return adminRepository.findById(id).orElseThrow();
    }
    // Cap nhap admin
    public Admin updateById (int id, Admin admin, MultipartFile file) throws IOException {
        Admin  existingAdmin = adminRepository.findById(id).orElseThrow();
        if(existingAdmin == null){
            return existingAdmin;
        }
        try {
            existingAdmin.setIdAdmin(admin.getIdAdmin());
            existingAdmin.setGender(admin.getGender());
            existingAdmin.setAddress(admin.getAddress());
            existingAdmin.setPhone(admin.getPhone());
            existingAdmin.setEmail(admin.getEmail());
            existingAdmin.setWorkDay(admin.getWorkDay());
            existingAdmin.setFullName(admin.getFullName());
            existingAdmin.setBirthDay(admin.getBirthDay());
            existingAdmin.setAvatar(file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminRepository.save(existingAdmin);

    }

    // Lấy  tất ca admin
    public List<Admin> findAllAdmin(){
        return adminRepository.findAll();
    }

    // Dem so luong admin
    public long countAdmin(){
        return adminRepository.count();
    }
}
