package com.pnguyen.controllers.admin;

import com.pnguyen.command.ListenGuidelineCommand;
import com.pnguyen.core.common.utils.UploadUtil;
import com.pnguyen.core.dto.ListenGuidelineDTO;
import com.pnguyen.core.service.ListenGuidelineService;
import com.pnguyen.core.sevice.impl.ListenGuidelineServiceImpl;
import com.pnguyen.core.web.utils.FormUtil;
import com.pnguyen.core.web.utils.RequestUtil;
import com.pnguyen.web.logic.common.WebConstant;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html","/admin-guideline-listen-edit.html"})
public class ListenGuideLineController extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    private ListenGuidelineService guidelineService = new ListenGuidelineServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ListenGuidelineCommand command = FormUtil.populate(ListenGuidelineCommand.class, req);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
        HttpSession session = req.getSession();
        /*command.setMaxPageItems(2);
        RequestUtil.initSearchBean(req, command);
        Object[] objects = guidelineService.findListenGuidelineByProperties(null, null, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));*/
        /*req.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
        req.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.success"));*/
        if (session!=null){
            req.setAttribute(WebConstant.ALERT, session.getAttribute(WebConstant.ALERT));
            req.setAttribute(WebConstant.MESSAGE_RESPONSE, session.getAttribute(WebConstant.MESSAGE_RESPONSE));
        }
        req.setAttribute(WebConstant.LIST_ITEMS, command);
        if(command.getUrlType()!=null && command.getUrlType().equals(WebConstant.URL_LIST)){
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(req,resp);
        }else if(command.getUrlType()!=null && command.getUrlType().equals(WebConstant.URL_EDIT)){
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(req,resp);
        }

        session.removeAttribute(WebConstant.ALERT);
        session.removeAttribute(WebConstant.MESSAGE_RESPONSE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListenGuidelineCommand command = new ListenGuidelineCommand();
        UploadUtil uploadUtil = new UploadUtil();
        ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");
        HttpSession session = req.getSession();
        Set<String> titleValue = buildSetValuesListenGuideline();
        try {
            Object[] objects = uploadUtil.writeOrUpdateFile(req, titleValue, WebConstant.LISTENGUIDELINE);
            Map<String, String> mapValue = (Map<String, String>) objects[3];
            command = returnValuesListenGuidelineCommand(titleValue, command, mapValue);

            session.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("label.guideline.listen.add.success"));
        } catch (FileUploadException e) {
            logger.error(e.getMessage(),e);
            session.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("label.error"));
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            session.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("label.error"));
        }

        resp.sendRedirect("/admin-guideline-listen-list.html?urlType=url_list");
    }

    private ListenGuidelineCommand returnValuesListenGuidelineCommand(Set<String> titleValue, ListenGuidelineCommand command, Map<String, String> mapValue) {
        for (String item :
                titleValue) {
            if (mapValue.containsKey(item)){
                if (item.equals("pojo.title")){
                    command.getPojo().setTitle(mapValue.get(item));
                }else if (item.equals("pojo.content")){
                    command.getPojo().setContent(mapValue.get(item));
                }

            }
        }
        return command;
    }

    private Set<String> buildSetValuesListenGuideline() {
        Set<String> returnValue = new HashSet<>();
        returnValue.add("pojo.title");
        returnValue.add("pojo.content");
        return returnValue;
    }
}
