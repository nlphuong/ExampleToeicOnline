package com.pnguyen.controllers.admin;

import com.pnguyen.command.UserCommand;
import com.pnguyen.core.dto.UserDTO;
import com.pnguyen.core.service.UserService;
import com.pnguyen.core.sevice.impl.UserServiceImpl;
import com.pnguyen.core.web.utils.FormUtil;
import com.pnguyen.web.logic.common.WebConstant;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, req);
        UserDTO pojo = command.getPojo();
        UserService userService =  new UserServiceImpl();
        try{
            if(userService.isUserExist(pojo) != null){
                if (userService.findRoleByUser(pojo) != null && userService.findRoleByUser(pojo).getRoleDTO() != null){
                    if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)){
                        resp.sendRedirect("/admin-home.html");
                    }else if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)){
                        resp.sendRedirect("/home.html");
                    }
                }
            }
        }catch (NullPointerException e){
            logger.error(e.getMessage(), e);
            req.setAttribute(WebConstant.ALERT,WebConstant.TYPE_ERROR);
            req.setAttribute(WebConstant.MESSAGE_RESPONSE, "Tên hoặc mật khẩu sai ");
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(req, resp);
        }

    }
}
