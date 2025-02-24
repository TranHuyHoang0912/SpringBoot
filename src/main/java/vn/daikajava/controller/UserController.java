package vn.daikajava.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.daikajava.dto.request.UserRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @PostMapping(value = "/", headers = "apiKey=v1.0")
//    @RequestMapping( method = RequestMethod.POST, path = "/", headers = "apiKey=v1.0")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public int addUser(@Valid @RequestBody UserRequestDTO userDTO){
        return 1;
    }
    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO){
        System.out.println("User updated" + userId);
        return "User updated";
    }
    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status){
        System.out.println("Request to change status of user " + userId);
        return "User changed status";
    }
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public String deleteUser(@PathVariable @Min(1) int userId){
            System.out.println("Request to delete user " + userId);
            return "User deleted";
    }
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
        public UserRequestDTO getUser(@PathVariable int userId){
        System.out.println("Request to get user " + userId);
        return new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234");
    }
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<UserRequestDTO> getAllUsers(
            @RequestParam(required = false) String email,
            @RequestParam( defaultValue = "0") int pageNo,
            @RequestParam( defaultValue = "10") int pageSize) {
        return List.of(new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234"),
                new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234"));
    }
}
