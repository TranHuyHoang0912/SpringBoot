package vn.daikajava.service;

import vn.daikajava.dto.request.UserRequestDTO;

public interface UserService {
    int addUser(UserRequestDTO requestDTO);
}
