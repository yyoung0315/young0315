package com.pick.you.pick;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PickServiceImpl implements PickService{

	@Autowired
	private PickDao dao;

	@Override
	public void pick_Insert(PickVO vo) {
		dao.pick_Insert(vo);
		
	}

	@Override
	public List<PickVO> pick_List(PickVO vo) {
		
		return dao.pick_List(vo);
	}

	@Override
	public PickVO pick_GetOne(PickVO vo) {
		// TODO Auto-generated method stub
		return dao.pick_GetOne(vo);
	}

	@Override
	public PickVO pick_Get(PickVO vo) {
		// TODO Auto-generated method stub
		return dao.pick_Get(vo);
	}



}
