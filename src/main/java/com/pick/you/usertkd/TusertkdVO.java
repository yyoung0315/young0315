package com.pick.you.usertkd;

import lombok.Data;

@Data
public class TusertkdVO {
    private int tidx; 
    private String tuser_id; //Primary key,
    private String tuser_name;
    private String tuser_password;
    private String tuser_gender; 
    private String tuser_learnday;
    private String tuser_time;
    private String tuser_phone;
    private String tuser_addr; 
    private String tuser_etc;
    
    
    private String metroName;
    private String metroOld;
    private String metroNew;
   
}
