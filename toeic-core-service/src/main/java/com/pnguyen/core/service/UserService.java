package com.pnguyen.core.service;

import com.pnguyen.core.dto.UserDTO;

public interface UserService {
    UserDTO isUserExist(UserDTO dto);

    UserDTO findRoleByUser(UserDTO dto);
}
