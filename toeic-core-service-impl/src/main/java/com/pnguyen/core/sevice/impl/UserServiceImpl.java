package com.pnguyen.core.sevice.impl;

import com.pnguyen.core.DAO.UserDAO;
import com.pnguyen.core.DAOImpl.UserDAOImpl;
import com.pnguyen.core.dto.UserDTO;
import com.pnguyen.core.persistence.entity.UserEntity;
import com.pnguyen.core.service.UserService;
import com.pnguyen.core.utils.UserBeanUtil;

public class UserServiceImpl implements UserService {

    @Override
    public UserDTO isUserExist(UserDTO dto) {
        UserDAO userDAO = new UserDAOImpl();
        UserEntity entity = userDAO.isUserExist(dto.getName(),dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    @Override
    public UserDTO findRoleByUser(UserDTO dto) {
        UserDAO userDAO = new UserDAOImpl();
        UserEntity entity = userDAO.findRoleByUser(dto.getName(), dto.getPassword());
        return  UserBeanUtil.entity2Dto(entity);
    }
}
