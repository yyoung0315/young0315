package com.pick.you.pick;

import java.util.List;

public interface PickDao {
	
	void pick_Insert(PickVO vo);
	List<PickVO> pick_List(PickVO vo);
	PickVO pick_Get(PickVO vo);
	
	PickVO pick_GetOne(PickVO vo);
	
}
