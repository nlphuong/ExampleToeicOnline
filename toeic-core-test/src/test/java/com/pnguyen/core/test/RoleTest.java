package com.pnguyen.core.test;

import com.pnguyen.core.DAO.RoleDAO;
import com.pnguyen.core.DAOImpl.RoleDAOImpl;
import com.pnguyen.core.persistence.entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
    @Test
    public void checkFindAll(){
        RoleDAO roleDAO = new RoleDAOImpl();
        List<RoleEntity> list = roleDAO.findAll();
    }

    @Test
    public void checkUpdateRole(){
        RoleDAO roleDAO = new RoleDAOImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(2);
        roleEntity.setName("USER");
        roleDAO.update(roleEntity);
    }

    /*@Test
    public void checkSaveRole(){
        RoleDAO roleDAO = new RoleDAOImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(1);
        roleEntity.setName("ADMIN");
        RoleEntity roleEntity1 = new RoleEntity();
        roleEntity1.setRoleId(2);
        roleEntity1.setName("USER");
        roleDAO.save(roleEntity);
        roleDAO.save(roleEntity1);
    }*/

    @Test
    public void checkFindById(){
        RoleDAO roleDAO = new RoleDAOImpl();
        RoleEntity roleEntity = roleDAO.findById(1);

    }

    @Test
    public void checkFindByProperty(){
        RoleDAO roleDAO = new RoleDAOImpl();
        String property = null;
        Object value = null;
        String sortExpression = null;
        String sortDirection = null;

        Object[] objects = roleDAO.findByProperty(property,value,sortExpression,sortDirection);
    }

    /*@Test
    public void  checkDelete(){
        List<Integer> listId = new ArrayList<Integer>();
        listId.add(1);
        listId.add(2);
        RoleDAO roleDAO = new RoleDAOImpl();
        Integer count = roleDAO.delete(listId);
    }*/
}
