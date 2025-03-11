package vn.daikajava.controller;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.daikajava.configuration.Translator;
import vn.daikajava.dto.request.UserRequestDTO;
import vn.daikajava.dto.response.ResponseData;
import vn.daikajava.dto.response.ResponseError;
import vn.daikajava.service.UserService;
import vn.daikajava.service.UserServiceImpl.UserServiceImpl;

import java.util.List;
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO user){
        System.out.println("Request add user" + user.getFirstName());
                    return new ResponseData<>(HttpStatus.CREATED.value(), Translator.toLocale("user.add.success"), 1);
           }
    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO){
        System.out.println("User updated" + userId);
        return new ResponseData<>(Translator.toLocale("user.update.success"), HttpStatus.ACCEPTED.value());
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
