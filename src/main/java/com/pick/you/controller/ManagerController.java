package com.pick.you.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pick.you.manager.ManagerServiceImpl;
import com.pick.you.manager.ManagerVO;


@Controller
public class ManagerController {
	
	@Autowired
	private ManagerServiceImpl service;
	
	@RequestMapping(value = "manager_Login.do")
	public ModelAndView manager_Login(ManagerVO vo,ModelAndView mav,HttpSession session) {
		if(vo.getManager_id().equals("admin") && vo.getManager_password().equals("77777")) {
			mav.addObject("m",service.Manager_Login(vo));
			mav.setViewName("/index.jsp");
			String m_id = vo.getManager_id();
			session.setAttribute("m_id",m_id);
			return mav;
		}else {
			mav.setViewName("/manager/manager_login.jsp");
			return mav;
		}
	}
	
	@RequestMapping(value = "manager_logout.do")
	public String manager_logout(HttpSession session) {
	session.invalidate();
	return "/index.jsp";
	}
	
}
