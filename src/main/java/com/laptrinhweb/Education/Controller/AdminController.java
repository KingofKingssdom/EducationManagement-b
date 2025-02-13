package com.laptrinhweb.Education.Controller;

import com.laptrinhweb.Education.Model.Admin;
import com.laptrinhweb.Education.Service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAdmin(@Valid
                                      @RequestParam("idAdmin") String idAdmin,
                                      @RequestParam("fullName") String fullName,
                                      @RequestParam("birthDay") String birthDay,
                                      @RequestParam("gender") String gender,
                                      @RequestParam("email") String email,
                                      @RequestParam("phone") String phone,
                                      @RequestParam("address") String address,
                                      @RequestParam("workDay") String workDay,
                                      @RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam(value = "avatar", required = false) MultipartFile avatar
    ){
        try{
            Admin admin = new Admin();
            admin.setIdAdmin(idAdmin);
            admin.setFullName(fullName);
            admin.setBirthDay(birthDay);
            admin.setEmail(email);
            admin.setPhone(phone);
            admin.setWorkDay(workDay);
            admin.setAddress(address);
            admin.setGender(gender);
            admin.setUsername(username);
            admin.setPassword(password);
            Admin addAdmin = adminService.saveAdmin(admin,avatar);
            return ResponseEntity.ok(addAdmin);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Failed to upload avatar");
    }
    // Lay theo id

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.findById(id);
    }
    // Cap nhap theo id

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAdminById (@PathVariable int id,
                                              @RequestParam("idAdmin") String idAdmin,
                                              @RequestParam("fullName") String fullName,
                                              @RequestParam("birthDay") String birthDay,
                                              @RequestParam("gender") String gender,
                                              @RequestParam("email") String email,
                                              @RequestParam("phone") String phone,
                                              @RequestParam("workDay") String workDay,
                                              @RequestParam("address") String address,
                                              @RequestParam(value = "avatar", required = false) MultipartFile avatar){
        Admin existingAdmin = adminService.findById(id);
        if(existingAdmin == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            existingAdmin.setIdAdmin(idAdmin);
            existingAdmin.setEmail(email);
            existingAdmin.setWorkDay(workDay);
            existingAdmin.setPhone(phone);
            existingAdmin.setBirthDay(birthDay);
            existingAdmin.setGender(gender);
            existingAdmin.setAddress(address);
            existingAdmin.setFullName(fullName);
            Admin addAdmin = adminService.saveAdmin(existingAdmin,avatar);
            return ResponseEntity.ok(addAdmin);
        } catch (IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Fail save avatar");
    }

    // Lay tat ca admin

    @GetMapping("/getAll")
    public List<Admin> getAllAdmin(){
        return adminService.findAllAdmin();
    }
    // Dem so luong admin

    @GetMapping("/count")
    public long countAdmin(){
        return adminService.countAdmin();
    }
}
