package com.pick.you.usertkd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsertkdServiceImpl implements UsertkdService{

	@Autowired
	private UsertkdDao dao;

	@Override
	public void Lusertkd_Insert(LusertkdVO vo) {
		dao.Lusertkd_Insert(vo);
		
	}

	@Override
	public void Tusertkd_Insert(TusertkdVO vo) {
		dao.Tusertkd_Insert(vo);
		
	}

	@Override
	public List<LusertkdVO> Lusertkd_Login(LusertkdVO vo) {
		
		return dao.Lusertkd_Login(vo);
	}

	@Override
	public List<TusertkdVO> Tusertkd_Login(TusertkdVO vo) {
		// TODO Auto-generated method stub
		return dao.Tusertkd_Login(vo);
	}

	@Override
	public List<LusertkdVO> Lusertkd_List(LusertkdVO vo) {
		// TODO Auto-generated method stub
		return dao.Lusertkd_List(vo);
	}

	@Override
	public List<TusertkdVO> Tusertkd_List(TusertkdVO vo) {
		// TODO Auto-generated method stub
		return dao.Tusertkd_List(vo);
	}

	@Override
	public LusertkdVO Lusertkd_GetOne(LusertkdVO vo) {
		// TODO Auto-generated method stub
		return dao.Lusertkd_GetOne(vo);
	}

	@Override
	public TusertkdVO Tusertkd_GetOne(TusertkdVO vo) {
		// TODO Auto-generated method stub
		return dao.Tusertkd_GetOne(vo);
	}

	@Override
	public LusertkdVO laddr_GetOne(LusertkdVO vo) {
		// TODO Auto-generated method stub
		return dao.laddr_GetOne(vo);
	}

	@Override
	public TusertkdVO taddr_GetOne(TusertkdVO vo) {
		// TODO Auto-generated method stub
		return dao.taddr_GetOne(vo);
	}

	@Override
	public void luserEdit(LusertkdVO vo) {
		dao.luserEdit(vo);
		
	}

	@Override
	public void tuserEdit(TusertkdVO vo) {
		dao.tuserEdit(vo);
	}


}
