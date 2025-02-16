package vn.daikajava.controller;

import org.springframework.web.bind.annotation.*;
import vn.daikajava.dto.request.UserRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @PostMapping(value = "/", headers = "apiKey=v1.0")
    @RequestMapping( method = RequestMethod.POST, path = "/", headers = "apiKey=v1.0")
    public String addUser(@RequestBody UserRequestDTO userDTO){
        return "User added";
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO){
        System.out.println("User updated" + userId);
        return "User updated";
    }
    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status){
        System.out.println("Request to change status of user " + userId);
        return "User changed status";
    }
    @DeleteMapping("/{userId}")
        public String deleteUser(@PathVariable int userId){
            System.out.println("Request to delete user " + userId);
            return "User deleted";
    }
    @GetMapping("/{userId}")
        public UserRequestDTO getUser(@PathVariable int userId){
        System.out.println("Request to get user " + userId);
        return new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234");
    }
    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(
            @RequestParam(required = false) String email,
            @RequestParam( defaultValue = "0") int pageNo,
            @RequestParam( defaultValue = "10") int pageSize) {
        return List.of(new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234"),
                new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234"));
    }
}
