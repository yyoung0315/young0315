package com.pick.you.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insert(CartVO vo) {

		mybatis.insert("CART.insert", vo);
		
	}

	@Override
	public List<CartVO> getCartList(CartVO vo) {
	
		return mybatis.selectList("CART.getCartList", vo);
	}

	@Override
	public void delete(CartVO vo) {
	
		mybatis.delete("CART.delete", vo);
	}

	@Override
	public void update(CartVO vo) {
	
		mybatis.update("CART.update", vo);
	}

	@Override
	public int sumMoney(String user_id) {
	
		return mybatis.selectOne("CART.sumMoney", user_id);
	}

	@Override
	public int countCart(int product_id, String user_id) {

		Map<String, Object> map = new HashMap<String, Object>();
			map.put("user_id", user_id) ;
			map.put("product_id", product_id) ;
		
		return mybatis.selectOne("CART.countCart", map);
	}

	@Override
	public int selectcidxCount(CartVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("CART.userCart", vo);
	}

	@Override
	public void cartAllDelete(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("CART.cartAllDelete", vo);
	}
}
