package com.pick.you.pick;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PickDaoImpl implements PickDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;



	@Override
	public void pick_Insert(PickVO vo) {
		mybatis.insert("PickDao.PICK_INSERT",vo);
		
	}

	@Override
	public List<PickVO> pick_List(PickVO vo) {
		
		return mybatis.selectList("PickDao.PICK_LIST", vo);
	}

	@Override
	public PickVO pick_GetOne(PickVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("PickDao.PICK_GETONE", vo);
	}

	@Override
	public PickVO pick_Get(PickVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("PickDao.PICK_GET", vo);
	}


}
