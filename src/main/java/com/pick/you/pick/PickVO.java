package com.pick.you.pick;

import lombok.Data;

@Data
public class PickVO {
	private int pidx;
	private String luser_id ;
	private String tuser_id ;
	private String luser_gender ;
	private String luser_learnday ;
	private String luser_time;
	private String luser_addr;
    private String luser_etc;
    
    private String metroName;
    private String metroOld;
    private String metroNew;
   
}
