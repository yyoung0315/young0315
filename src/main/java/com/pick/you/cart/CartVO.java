package com.pick.you.cart;

import lombok.Data;

@Data
public class CartVO {
	private int cidx;
    private String user_id;
	private int product_id;   //상품번호 (PK)
	private String product_name; //상품이름
	private int product_price;  // 상품 가격
	private int amount;
	
}
