package com.pick.you.product;

import java.util.List;

public interface ProductService {

	List<ProductVO> product_ListAll(ProductVO vo);
	void product_Insert(ProductVO vo);
	ProductVO product_GetOne(ProductVO vo);

	void cart_Insert(ProductVO vo);
	
	void product_edit(ProductVO vo);
	
	int  totalCount(ProductVO vo);
	
	void product_Delete(ProductVO vo);
	void productEdit(ProductVO vo);
	
}
