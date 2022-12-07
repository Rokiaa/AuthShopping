package com.online.shopping.FinalProject.service;

import com.online.shopping.FinalProject.dao.UserRepo;
import com.online.shopping.FinalProject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> user = userRepo.findByUsername(userName);

        System.out.println("userrrr "+user);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }




    public Users addUser(Users users){
        return userRepo.save(users);
    }
    public List<Users> findAllUsers(){
        return userRepo.findAll();
    }

}
