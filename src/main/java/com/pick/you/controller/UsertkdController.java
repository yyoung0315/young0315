package com.pick.you.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pick.you.usertkd.UsertkdServiceImpl;

import com.pick.you.usertkd.LusertkdVO;
import com.pick.you.usertkd.TusertkdVO;

@Controller
public class UsertkdController {

	@Autowired
	private UsertkdServiceImpl service;

	// 인설트
	@RequestMapping(value = "lusertkd_Insert.do")
	public String usertkd_Insert(LusertkdVO vo) {

		service.Lusertkd_Insert(vo);
		return "redirect:/usertkd/Lusertkd_login.jsp";
	}
	@RequestMapping(value = "tusertkd_Insert.do")
	public String tsertkd_Insert(TusertkdVO vo) {

		service.Tusertkd_Insert(vo);
		return "redirect:/usertkd/Tusertkd_login.jsp";
	}
	
	//이름이랑 아이디 띄우기 위해사용
	@RequestMapping(value="/luser_count.do")
	public  ModelAndView  member_count(LusertkdVO vo,ModelAndView mav) throws Exception {
		mav.addObject("m", service.Lusertkd_GetOne(vo));
		mav.setViewName("/usertkd/LuserEdit.jsp");			
		return mav;
	}
	
	//수정하기
	@RequestMapping(value = "luserEdit.do")
	public String luserEdit(LusertkdVO vo) {
		service.luserEdit(vo);
		return "redirect:/usertkd/UserUpdateSuccess.jsp";
	}
	
	//이름이랑 아이디 띄우기 위해사용
	@RequestMapping(value="/tuser_count.do")
	public  ModelAndView  member_count(TusertkdVO vo,ModelAndView mav) throws Exception {
		mav.addObject("m", service.Tusertkd_GetOne(vo));
		mav.setViewName("/usertkd/TuserEdit.jsp");			
		return mav;
	}
	
	//수정하기
	@RequestMapping(value = "tuserEdit.do")
	public String tuserEdit(TusertkdVO vo) {

		service.tuserEdit(vo);
		return "redirect:/usertkd/UserUpdateSuccess.jsp";
	}

	
	
	
	// 로그인
	@RequestMapping(value = "lusertkd_Login.do")
	public ModelAndView lusertkd_Login(LusertkdVO vo, ModelAndView mav, HttpSession session) {
		List<LusertkdVO> lusertkd_login = service.Lusertkd_Login(vo);
		if (!lusertkd_login.isEmpty()) {
			LusertkdVO luser = lusertkd_login.get(0);
			luser.getLuser_id();
			luser.getLuser_password();
			mav.addObject("m", luser);
			mav.setViewName("/index.jsp");
			String luser_id = luser.getLuser_id();
			session.setAttribute("luser_id", luser_id);
			return mav;
		} else {
			mav.setViewName("redirect:/usertkd/Lusertkd_login.jsp");
			return mav;
		}
	}

	// 로그인
	@RequestMapping(value = "tusertkd_Login.do")
	public ModelAndView tusertkd_Login(TusertkdVO vo, ModelAndView mav, HttpSession session) {
		List<TusertkdVO> tusertkd_login = service.Tusertkd_Login(vo);
		if (!tusertkd_login.isEmpty()) {
			TusertkdVO tuser = tusertkd_login.get(0);
			tuser.getTuser_id();
			tuser.getTuser_password();
			mav.addObject("m", tuser);
			mav.setViewName("/index.jsp");
			String tuser_id = tuser.getTuser_id();
			session.setAttribute("tuser_id", tuser_id);
			return mav;
		} else {
			mav.setViewName("redirect:/usertkd/Tusertkd_login.jsp");
			return mav;
		}
	}
	// 로그아웃 
	@RequestMapping(value = "usertkd_logout.do")
	public String usertkd_logout(HttpSession session) {
		session.invalidate();
		return "/index.jsp";
	}

	//listAll
	@RequestMapping(value = "lusertkd_List.do")
	public ModelAndView lusertkd_List(LusertkdVO vo, ModelAndView mav) {

		mav.addObject("li", service.Lusertkd_List(vo));
		mav.setViewName("/usertkd/Lusertkd_List.jsp");
		return mav;
	}
	
	//listAll
	@RequestMapping(value = "tusertkd_List.do")
	public ModelAndView tusertkd_List(TusertkdVO vo, ModelAndView mav) {

		mav.addObject("li", service.Tusertkd_List(vo));
		mav.setViewName("/usertkd/Tusertkd_List.jsp");
		return mav;
	}
	
	// 겟 원 
	@RequestMapping(value = "lusertkd_GetOne.do")
	String lusertkd_GetOne(LusertkdVO vo, Model model) {
		LusertkdVO luser = service.Lusertkd_GetOne(vo);
		model.addAttribute("ml", luser);

		vo.setLuser_addr(luser.getLuser_addr());
		vo.setLuser_id(luser.getLuser_id());
		LusertkdVO laddr = service.laddr_GetOne(vo);
		model.addAttribute("dl", laddr);

		return "/usertkd/Lusertkd_GetOne.jsp";
	}
	
	// 겟 원 
	@RequestMapping(value = "tusertkd_GetOne.do")
	String tusertkd_GetOne(TusertkdVO vo, Model model) {
		TusertkdVO tuser = service.Tusertkd_GetOne(vo);
		model.addAttribute("mt", tuser);

		vo.setTuser_addr(tuser.getTuser_addr());
		vo.setTuser_id(tuser.getTuser_id());
		TusertkdVO taddr = service.taddr_GetOne(vo);
		model.addAttribute("dt", taddr);

		return "/usertkd/Tusertkd_GetOne.jsp";
	}
}
