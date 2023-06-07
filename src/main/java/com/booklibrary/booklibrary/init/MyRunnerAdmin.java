package com.booklibrary.booklibrary.init;

import com.booklibrary.booklibrary.entity.Role;
import com.booklibrary.booklibrary.entity.User;
import com.booklibrary.booklibrary.repository.RoleRepository;
import com.booklibrary.booklibrary.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@Component
public class MyRunnerAdmin //implements CommandLineRunner {
{
  /*  private static final Logger logger = LoggerFactory.getLogger(MyRunnerAdmin.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        logger.info("start point to insert admin");
        User user = new User();
        user.setUsername("admin2");
        user.setEmail("admin2@gmail.com");
        // encrypt the password using spring security
        user.setPassword("$2a$10$c6MCS5BXQLv1WLM/uh/IWOyZwbgQu47CxuDzTss/gx4AaDIG1wLdC");
        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }
       *//* Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        logger.info("# of employees: {}", userRepository.count());
        user.setRoles(Arrays.asList(role));*//*
        user.setRoles((List<Role>) role);
        userRepository.save(user);
        logger.info("admin insert successfully");
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }*/
}
