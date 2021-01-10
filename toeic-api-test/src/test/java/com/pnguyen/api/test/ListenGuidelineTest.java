package com.pnguyen.api.test;

import com.pnguyen.core.DAO.ListenGuidelineDAO;
import com.pnguyen.core.DAO.UserDAO;
import com.pnguyen.core.DAOImpl.ListenGuidelineDAOImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ListenGuidelineTest {

    ListenGuidelineDAO listenGuidelineDAO;
    @BeforeTest
    public void initData(){
        listenGuidelineDAO = new ListenGuidelineDAOImpl();
    }

    @Test
    public void testFindByProperties(){
        //ListenGuidelineDAO listenGuidelineDAO = new ListenGuidelineDAOImpl();
        //Object[] result = listenGuidelineDAO.findByProperty(null, null,null,null,4,2);

    }

    @Test
    public void checkApiFindByProperties(){
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("title","Bai hd 8");
        properties.put("content","Noi dung bai hd 8");
        Object[] objects = listenGuidelineDAO.findByProperty(properties, null,null,null,null);
    }
}
