package com.pnguyen.api.test;

import com.pnguyen.core.DAO.UserDAO;
import com.pnguyen.core.DAOImpl.UserDAOImpl;
import com.pnguyen.core.persistence.entity.UserEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Test
    public  void checkIsUserExist(){
        UserDAO userDAO = new UserDAOImpl();
        String name = "truongtunglam";
        String password = "123456";

        UserEntity entity = userDAO.isUserExist(name, password);
        if(entity != null){
            logger.error("login success");
        }else {
            logger.error("login fail");
        }
    }

    @Test
    public void checkFindRoleByUser(){
        UserDAO userDAO = new UserDAOImpl();
        String name = "truongtunglam";
        String password = "123456";

        UserEntity entity = userDAO.findRoleByUser(name, password);
        logger.error(entity.getRoleEntity().getRoleId()+"-"+entity.getRoleEntity().getName());
    }
}
