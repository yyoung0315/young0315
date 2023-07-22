package com.pick.you.usertkd;

import java.util.List;

public interface UsertkdService {
	void Lusertkd_Insert(LusertkdVO vo);
	void Tusertkd_Insert(TusertkdVO vo);
	
	void luserEdit(LusertkdVO vo);
	void tuserEdit(TusertkdVO vo);
	
	
	List<LusertkdVO> Lusertkd_Login(LusertkdVO vo);
	List<TusertkdVO> Tusertkd_Login(TusertkdVO vo);
	
	List<LusertkdVO> Lusertkd_List(LusertkdVO vo);
	List<TusertkdVO> Tusertkd_List(TusertkdVO vo);
	
	LusertkdVO Lusertkd_GetOne(LusertkdVO vo);
	TusertkdVO Tusertkd_GetOne(TusertkdVO vo);
	
	LusertkdVO laddr_GetOne(LusertkdVO vo);
	TusertkdVO taddr_GetOne(TusertkdVO vo);

}
