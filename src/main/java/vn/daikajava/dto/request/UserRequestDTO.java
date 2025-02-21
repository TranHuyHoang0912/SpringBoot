package vn.daikajava.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import vn.daikajava.util.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static vn.daikajava.util.Gender.*;

public class UserRequestDTO implements Serializable {
    @NotBlank(message = "firsrName must be not blank")
    private String firstName;
    @NotNull(message = "lastName must be not null")
    private String lastName;
    @Email(message = "email invalid format")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "phone invalid format")
    @PhoneNumber
    private String phone;
    @NotNull(message = "dateOfBirth must be not null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateOfBirth;
//    @NotEmpty(message = "permission is not empty")
//    private List<String> permission;
    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE" )
    private UserStatus userStatus;
//    @NotNull
    @GenderSubset(anyOf = {MALE, FEMALE, OTHER})
    private Gender gender;
    @NotNull(message = "type must be not null")
    @EnumValue(name = "type", enumClass = UserType.class)
    private String type;

    public UserRequestDTO(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public @NotNull(message = "dateOfBirth must be not null") Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "dateOfBirth must be not null") Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public String getType(){
        return type;
    }
}


