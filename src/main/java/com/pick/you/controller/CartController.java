package com.pick.you.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pick.you.cart.CartServiceImpl;
import com.pick.you.cart.CartVO;

@Controller
public class CartController {

	@Autowired
	private CartServiceImpl service;

	// 카트 insert
	@RequestMapping(value = "cartInsert.do")
	String cartInsert(CartVO vo, HttpSession session) {
		String user_id = null;
		if (session.getAttribute("luser_id") != null) {
			user_id = (String) session.getAttribute("luser_id");
			vo.setUser_id(user_id);
		} else if (session.getAttribute("tuser_id") != null) {
			user_id = (String) session.getAttribute("tuser_id");
			vo.setUser_id(user_id);
		}
		// 현재 사용자가 동일 물품을 구매한 내역이 있는지 확인
		int count = service.countCart(vo.getProduct_id(), user_id);
		if (count == 0) {
			// 동일 상품이 없으면 장바구니 추가
			service.insert(vo);
		} else {
			// 동일 상품 구매시 수량 추가(변경)
			service.update(vo);
		}
		return "/cart.do";
	}

	// 2. 장바구니 목록보기
	@RequestMapping("/cart.do")
	String cart(CartVO vo, HttpSession session) throws Exception {
		String user_id = null;
		if (session.getAttribute("luser_id") != null) {
			user_id = (String) session.getAttribute("luser_id");
			vo.setUser_id(user_id);
		} else if (session.getAttribute("tuser_id") != null) {
			user_id = (String) session.getAttribute("tuser_id");
			vo.setUser_id(user_id);
		}
		session.setAttribute("li", service.getCartList(vo));
		session.setAttribute("sumMoney", service.sumMoney(user_id));

		return "cart/cart_List.jsp";
	}

	@RequestMapping(value = "cartUpdate.do")
	String cartUpdate(@RequestParam String[] cidx, @RequestParam String[] user_id, @RequestParam String[] product_id,
			@RequestParam String[] amount) throws Exception {
		for (int i = 0; i < cidx.length; i++) {
			CartVO vo = new CartVO();
			vo.setCidx(Integer.parseInt(cidx[i]));
			vo.setAmount(Integer.parseInt(amount[i]));
			service.update(vo);
		}
		return "redirect:selectcidxCount.do?cidx=" + cidx[cidx.length - 1];
	}

	@RequestMapping(value = "CartDelete.do")
	public String CartDelete(CartVO vo) {
		service.delete(vo);
		
		return "/cart.do";
	}
	
	@RequestMapping(value = "selectcidxCount.do")
	String selectcidxCount(CartVO vo, ModelAndView mav) {
		int cnt = service.selectcidxCount(vo);
		if (cnt==0) {
			return "/cart/cartNo.jsp";
		} else {
			return "cart.do";
		}
	}
	
	@RequestMapping(value = "cartOrder.do")
	public String cartOrder(CartVO vo) {
		service.cartAllDelete(vo);
		
		return "/cart/SuccessOrder.jsp";
	}
}
