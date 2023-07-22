package com.pick.you.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pick.you.product.ProductServiceImpl;
import com.pick.you.product.ProductVO;

@Controller
public class ProductController {
	String path = "";
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private ProductServiceImpl service;

	@PostConstruct
	public void init() {
		path = servletContext.getRealPath("/product/files/");
		System.out.println("===== path ===> " + path);
	}

	@RequestMapping(value = "/product_Insert.do")
	public String product_Insert(ProductVO vo) throws IllegalStateException, IOException {
		path = servletContext.getRealPath("/product/files/");
		LocalTime now = LocalTime.now();
		String TimeNow = now.format(DateTimeFormatter.ofPattern("HHmmss"));
		MultipartFile uploadFile = vo.getProduct_img();
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path + fileName);

		if (!uploadFile.isEmpty()) {
			if (f.exists()) {
				String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
				String extension = fileName.substring(fileName.lastIndexOf("."));
				fileName = onlyFileName + "_" + TimeNow + extension;
				uploadFile.transferTo(new File(path + fileName)); // 파일 저장
			} else {
				uploadFile.transferTo(new File(path + fileName));
			}
		} else {
			fileName = "space.png";
		}
		vo.setProduct_imgStr(fileName);
		service.product_Insert(vo);
		return "/productListAll.do";
	}

	@RequestMapping(value = "productListAll.do")
	public String productListAll(ProductVO vo, Model model) {
		System.out.println("Start:" + vo.getStart());
		
		int start = 0;
		if (vo.getStart() == 0) {
			start = 1;
		} else {
			start = vo.getStart();
		}

		int pageSize = 8;
		int pageListSize = 5;
		int totalCount = service.totalCount(vo);
		int totalPage = (int) (Math.ceil((double) totalCount / pageSize));
		;

		int nowPage = start / pageSize + 1;
		int listStartpage = (nowPage - 1) / pageListSize * pageListSize + 1;
		int listEndPage = listStartpage + pageListSize - 1;
		int endPage = (totalPage - 1) * pageSize + 1;

		vo.setStart(start);
		vo.setPageSize(pageSize);
		vo.setPageListSize(pageListSize);
		vo.setTotalCount(totalCount);
		vo.setTotalPage(totalPage);
		vo.setNowPage(nowPage);
		vo.setListStartpage(listStartpage);
		vo.setListEndPage(listEndPage);
		vo.setEndPage(endPage);
		
		model.addAttribute("m", vo);
		model.addAttribute("li", service.product_ListAll(vo));
		return "/product/product_list.jsp";
	}

	@RequestMapping(value = "MproductListAll.do")
	public String MproductListAll(ProductVO vo, Model model,HttpSession session) {
		
		String m_id = ( String )session.getAttribute("manager_id");
		vo.setUser_id(m_id);
		int start = 0;
		if (vo.getStart() == 0) {
			start = 1;
		} else {
			start = vo.getStart();
		}

		int pageSize = 8;
		int pageListSize = 5;
		int totalCount = service.totalCount(vo);
		int totalPage = (int) (Math.ceil((double) totalCount / pageSize));
		;

		int nowPage = start / pageSize + 1;
		int listStartpage = (nowPage - 1) / pageListSize * pageListSize + 1;
		int listEndPage = listStartpage + pageListSize - 1;
		int endPage = (totalPage - 1) * pageSize + 1;

		vo.setStart(start);
		vo.setPageSize(pageSize);
		vo.setPageListSize(pageListSize);
		vo.setTotalCount(totalCount);
		vo.setTotalPage(totalPage);
		vo.setNowPage(nowPage);
		vo.setListStartpage(listStartpage);
		vo.setListEndPage(listEndPage);
		vo.setEndPage(endPage);
		
		model.addAttribute("m", vo);
		model.addAttribute("li", service.product_ListAll(vo));
		

		return "/manager/Mproduct_list.jsp";
	}

	@RequestMapping(value = "product_GetOne.do")
	public ModelAndView product_GetOne(ProductVO vo, ModelAndView mav) {

		mav.addObject("m", service.product_GetOne(vo));
		mav.setViewName("/product/product_getone.jsp");
		return mav;
	}

	@RequestMapping(value = "Mproduct_GetOne.do")
	public ModelAndView Mproduct_GetOne(ProductVO vo, ModelAndView mav) {

		mav.addObject("m", service.product_GetOne(vo));
		mav.setViewName("/manager/Mproduct_getone.jsp");
		return mav;
	}

	@RequestMapping(value = "/cart_Insert.do")
	public String cart_Insert(ProductVO vo, HttpSession session) throws IllegalStateException, IOException {
		service.cart_Insert(vo);
		return "/productListAll.do";
	}

	@RequestMapping(value = "/product_Delete.do")
	public String product_Delete(ProductVO vo) throws IllegalStateException, IOException {
		File delF = new File(path + vo.getProduct_imgStr());

		if (!vo.getProduct_imgStr().equals("space.png")) {
			delF.delete();
		}
		service.product_Delete(vo);
		return "/productListAll.do";
	}

	@RequestMapping(value = "/productEdit.do")
	public String productEdit(ProductVO vo, HttpSession session) throws IllegalStateException, IOException {
		ProductVO m = service.product_GetOne(vo);
		LocalTime now = LocalTime.now();
		String TimeNow = now.format(DateTimeFormatter.ofPattern("HHmmss"));
		MultipartFile uploadFile = vo.getProduct_img();
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path + fileName);

		if (!uploadFile.isEmpty()) {
			File delF = new File(path + m.getProduct_imgStr());
			if (delF.exists()) {
				if (!m.getProduct_imgStr().equals("space.png")) {
					delF.delete();
				}
			}
			if (f.exists()) {
				String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
				String extension = fileName.substring(fileName.lastIndexOf("."));
				fileName = onlyFileName + "_" + TimeNow + extension;
				uploadFile.transferTo(new File(path + fileName)); // 파일 저장
			}
		}
		vo.setProduct_imgStr(fileName);
		service.productEdit(vo);

		return "/productListAll.do";
	}
}
