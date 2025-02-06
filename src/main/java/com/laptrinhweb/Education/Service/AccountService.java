package com.laptrinhweb.Education.Service;

import com.laptrinhweb.Education.Model.*;
import com.laptrinhweb.Education.Repository.AccountReposiroty;
import com.laptrinhweb.Education.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountReposiroty accountRepository;
    private RoleRepository roleRepository;
    @Autowired
    public AccountService(AccountReposiroty accountRepository, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
    }
    public void saveAccountForAdmin(Admin admin) {
        Account account = new Account();
        account.setUsername(admin.getEmail());
        account.setPassword(admin.getIdAdmin());
        account.setAdmin(admin);
        Account saveAccount = accountRepository.save(account);
        // Luu Role
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        role.setAccount(saveAccount);
        roleRepository.save(role);
    }
    public void saveAccountForTeacher(Teacher teacher) {
        Account account = new Account();
        account.setUsername(teacher.getEmail());
        account.setPassword(teacher.getIdTeacher());
        account.setTeacher(teacher);
        Account saveAccount = accountRepository.save(account);
        // Luu Role
        Role role = new Role();
        role.setRoleName("TEACHER_ROLE");
        role.setAccount(saveAccount);
        roleRepository.save(role);
    }
    public void saveAccountStudent(Student student){
        Account account = new Account();
        account.setUsername(student.getEmail());
        account.setPassword(student.getIdStudent());
        account.setStudent(student);
        Account saveAccount = accountRepository.save(account);
        // Luu Role
        Role role = new Role();
        role.setRoleName("STUDENT_ROLE");
        role.setAccount(saveAccount);
        roleRepository.save(role);
    }

}
