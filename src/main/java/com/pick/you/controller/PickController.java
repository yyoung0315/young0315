package com.pick.you.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pick.you.pick.PickServiceImpl;
import com.pick.you.pick.PickVO;
@Controller
public class PickController {

	@Autowired
	private PickServiceImpl service;


	
	// pick 인설트
	@RequestMapping(value = "pick_Insert.do")
	public String pick_Insert(PickVO vo, HttpSession session,Model model) {
		
		PickVO Lpick = service.pick_GetOne(vo);
		
		vo.setLuser_id(Lpick.getLuser_id());
		vo.setLuser_gender(Lpick.getLuser_gender());
		vo.setLuser_learnday(Lpick.getLuser_learnday());
		vo.setLuser_time(Lpick.getLuser_time());
		vo.setLuser_addr(Lpick.getLuser_addr());
		vo.setLuser_etc(Lpick.getLuser_etc());
		
		service.pick_Insert(vo);
		
		return "/match/SuccessTMatch.jsp";
	
	}
	
	//listAll
	@RequestMapping(value = "pick_List.do")
	public ModelAndView pick_List(PickVO vo, ModelAndView mav) {

		mav.addObject("li", service.pick_List(vo));
		mav.setViewName("/pick/pick_List.jsp");
		return mav;
	}
	
}
