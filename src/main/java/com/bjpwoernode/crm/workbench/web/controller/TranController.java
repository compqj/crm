package com.bjpwoernode.crm.workbench.web.controller;


import com.bjpwoernode.crm.settings.domain.User;
import com.bjpwoernode.crm.settings.service.UserService;
import com.bjpwoernode.crm.settings.service.impl.UserServiceImpl;
import com.bjpwoernode.crm.utils.DateTimeUtil;
import com.bjpwoernode.crm.utils.PrintJson;
import com.bjpwoernode.crm.utils.ServiceFactory;
import com.bjpwoernode.crm.utils.UUIDUtil;
import com.bjpwoernode.crm.vo.PaginationVo;
import com.bjpwoernode.crm.workbench.domain.*;
import com.bjpwoernode.crm.workbench.service.ActivityService;
import com.bjpwoernode.crm.workbench.service.ClueService;
import com.bjpwoernode.crm.workbench.service.CustomerService;
import com.bjpwoernode.crm.workbench.service.impl.ActivityServiceImpl;
import com.bjpwoernode.crm.workbench.service.impl.ClueServiceImpl;
import com.bjpwoernode.crm.workbench.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到交易控制器");
        String path = request.getServletPath();

        if("/workbench/transaction/add.do".equals(path)){

            add(request,response);

        }else if("/workbench/transaction/getCustomerName.do".equals(path)){

            getCustomerName(request,response);

        }
    }

    private void getCustomerName(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得客户名称列表(按照客户名称进行模糊查询)");
        String name = request.getParameter("name");
        CustomerService cs = (CustomerService) ServiceFactory.getService(new CustomerServiceImpl());

        List<String> sList = cs.getCustomerName(name);
        PrintJson.printJsonObj(response,sList);

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到跳转到交易添加页的操作");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        List<User> uList = us.getUserList();

        request.setAttribute("uList",uList);
        request.getRequestDispatcher("/workbench/transaction/save.jsp").forward(request,response);

    }


}
