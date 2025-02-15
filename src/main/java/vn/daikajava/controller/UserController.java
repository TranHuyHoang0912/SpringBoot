package vn.daikajava.controller;

import org.springframework.web.bind.annotation.*;
import vn.daikajava.dto.request.UserRequestDTO;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@RequestBody UserRequestDTO userDTO){
        return "User added";
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") int id, @RequestBody UserRequestDTO userDTO){
        System.out.println("User updated" + id);
        return "User updated";
    }
}
