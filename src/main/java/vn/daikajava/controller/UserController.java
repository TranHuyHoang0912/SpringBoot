package vn.daikajava.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.daikajava.dto.request.UserRequestDTO;
import vn.daikajava.dto.response.ResponseData;
import vn.daikajava.dto.response.ResponseSuccess;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO user){
        System.out.println("Request add user " + user.getFirstName());
        return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
    }
    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO){
        System.out.println("User updated" + userId);
        return new ResponseData<>("User updated successfully", HttpStatus.ACCEPTED.value());
    }
    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status){
        System.out.println("Request to change status of user " + userId);
        return new ResponseData<>("User status changed to " + status, HttpStatus.ACCEPTED.value());
    }
    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@PathVariable @Min(1) int userId){
        System.out.println("Request to delete user " + userId);
        return new ResponseData<>("User deleted successfully", HttpStatus.NO_CONTENT.value());
    }
    @GetMapping("/{userId}")
        public ResponseData<UserRequestDTO> getUser(@PathVariable int userId){
        System.out.println("Request to get user " + userId);
        return new ResponseData<>(HttpStatus.OK.value(), "user", new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234"));
    }
    @GetMapping("/list")
        public ResponseData<List<UserRequestDTO>> getAllUsers(
            @RequestParam(required = false) String email,
            @RequestParam( defaultValue = "0") int pageNo,
            @RequestParam( defaultValue = "10") int pageSize) {
        return new ResponseData<>(HttpStatus.OK.value(), "user", List.of(new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234"),
                new UserRequestDTO("Hoang", "Huy", "1234@mail", "1234")));
    }
}
