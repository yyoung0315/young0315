package com.pick.you.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pick.you.match.MatchServiceImpl;
import com.pick.you.match.MatchVO;



@Controller
public class MatchController {
	@Autowired
	private MatchServiceImpl service;

	@RequestMapping(value ="/match_Insert.do")
	String match_Insert(MatchVO vo) {
		MatchVO getT = service.Match_GetOne(vo);
		vo.setTuser_gender(getT.getTuser_gender());
		vo.setTuser_learnday(getT.getTuser_learnday());
		vo.setTuser_time(getT.getTuser_time());
		vo.setTuser_addr(getT.getTuser_addr());
		service.Match_Insert(vo);
		return "/match/SuccessMatch.jsp";
		
	}
	
	//listAll
	@RequestMapping(value = "match_List.do")
	public ModelAndView match_List(MatchVO vo, ModelAndView mav) {

		mav.addObject("li", service.match_List(vo));
		mav.setViewName("/match/match_List.jsp");
		return mav;
	}
}
