package com.online.shopping.FinalProject.controler;

import com.online.shopping.FinalProject.entity.Order;
import com.online.shopping.FinalProject.entity.Users;
import com.online.shopping.FinalProject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users>users= userService.findAllUsers();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/add")
    public Users addUser(@RequestBody Users user){
        user.setId(0);
        userService.addUser(user);
        return  user;
    }
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }


}
