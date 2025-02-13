package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.Admin;
import com.laptrinhweb.Education.Model.Teacher;
import com.laptrinhweb.Education.Repository.AdminRepository;
import com.laptrinhweb.Education.Repository.TeacherRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final AdminRepository adminRepository;
    private final TeacherRepository teacherRepository;
    public CustomUserDetailsService(AdminRepository adminRepository, TeacherRepository teacherRepository) {
        this.adminRepository = adminRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElse(null);

        if (admin != null) {
            return new CustomUserDetails(admin);
        }

        Teacher teacher = teacherRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        return new CustomUserDetails(teacher);
    }
}
