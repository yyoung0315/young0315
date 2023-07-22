package com.pick.you.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;


	@Override
	public void product_Insert(ProductVO vo) {
		mybatis.insert("ProductDao.PRODUTINSERT", vo);
		
	}
	
	@Override
	public List<ProductVO> product_ListAll(ProductVO vo) {
		
		return mybatis.selectList("ProductDao.PRODUTLISTALL");
	}

	@Override
	public ProductVO product_GetOne(ProductVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("ProductDao.PRODUTGETONE",vo);
	}

	@Override
	public void cart_Insert(ProductVO vo) {
		
		mybatis.insert("ProductDao.CARTINSERT", vo);
	}

	@Override
	public void product_edit(ProductVO vo) {
		if (vo.getProduct_imgStr() == "" || vo.getProduct_imgStr().equals("")) {
			Object args [] = {vo.getProduct_name(), vo.getProduct_price(), vo.getProduct_desc()};
			mybatis.update("ProductDao.PRODUTEDIT1", args);
		}else {
			Object args [] = {vo.getProduct_name(), vo.getProduct_price(),vo.getProduct_imgStr(), vo.getProduct_desc()};
			mybatis.update("ProductDao.PRODUTEDIT2", args);
		}
}

	@Override
	public int totalCount(ProductVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("ProductDao.TOTALCOUNT",vo);
	}

	@Override
	public void product_Delete(ProductVO vo) {
		mybatis.delete("ProductDao.PODUCTDELETE", vo);
		
	}

	@Override
	public void productEdit(ProductVO vo) {
		mybatis.update("ProductDao.PRODUCTEDIT", vo);
		
	}



}
