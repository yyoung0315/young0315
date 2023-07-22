package com.pick.you.product;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
    private String user_id;
	private int product_id;   //상품번호 (PK)
	private String product_name; //상품이름
	private int product_price;  // 상품 가격
	private String product_desc; //상품 상세설명
	private String product_imgStr; // 상품 사진명
	private MultipartFile product_img; // 실제 사진파일
	private String amount; 
	
	private int rownum;
	private int rnum;

	private  int  pageSize;
	private  int  pageListSize;
	private  int  totalCount;
	private  int  totalPage;
	private  int  start;
	private  int  nowPage;
	private  int  listStartpage;
	private  int  listEndPage;
	private  int  endPage;
}
