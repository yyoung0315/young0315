package com.pick.you.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;

	@Override
	public List<ProductVO> product_ListAll(ProductVO vo) {
		
		return dao.product_ListAll(vo);
	}

	@Override
	public void product_Insert(ProductVO vo) {
		dao.product_Insert(vo);
		
	}

	@Override
	public ProductVO product_GetOne(ProductVO vo) {
		
		return dao.product_GetOne(vo);
	}

	@Override
	public void cart_Insert(ProductVO vo) {
		dao.cart_Insert(vo);
		
	}

	@Override
	public void product_edit(ProductVO vo) {
		dao.product_edit(vo);
		
	}

	@Override
	public int totalCount(ProductVO vo) {
		// TODO Auto-generated method stub
		return dao.totalCount(vo);
	}

	@Override
	public void product_Delete(ProductVO vo) {
		dao.product_Delete(vo);
		
	}

	@Override
	public void productEdit(ProductVO vo) {
		dao.productEdit(vo);
		
	}
	
}
