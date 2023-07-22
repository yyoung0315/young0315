package com.pick.you.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao dao;

	@Override
	public void insert(CartVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public List<CartVO> getCartList(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.getCartList(vo);
	}

	@Override
	public void delete(CartVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}

	@Override
	public void update(CartVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public int sumMoney(String user_id) {
		// TODO Auto-generated method stub
		return dao.sumMoney(user_id);
	}

	@Override
	public int countCart(int product_id, String user_id) {
		// TODO Auto-generated method stub
		return dao.countCart(product_id, user_id);
	}

	@Override
	public int selectcidxCount(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.selectcidxCount(vo);
	}

	@Override
	public void cartAllDelete(CartVO vo) {
		// TODO Auto-generated method stub
		dao.cartAllDelete(vo);
	}

}
