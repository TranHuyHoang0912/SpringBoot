package vn.daikajava.service.UserServiceImpl;

import org.springframework.stereotype.Service;
import vn.daikajava.dto.request.UserRequestDTO;
import vn.daikajava.service.UserService;
import vn.daikajava.exception.ResourceNotFoundException;
@Service
public class UserServiceImpl implements UserService {

    @Override
    public int addUser(UserRequestDTO requestDTO) {
        System.out.println("save user to db");
        if (!requestDTO.getFirstName().equals("hoang"))
        {
            throw new ResourceNotFoundException("Hoang ko ton tai");
        }
        return 0;
    }
}
