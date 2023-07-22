package com.pick.you.usertkd;

import lombok.Data;

@Data
public class LusertkdVO {
    private int lidx; 
    private String luser_id; //Primary key,
    private String luser_name;
    private String luser_password;
    private String luser_gender; 
    private String luser_learnday;
    private String luser_time;
    private String luser_phone;
    private String luser_addr; 
    private String luser_etc;
    
    
    private String metroName;
    private String metroOld;
    private String metroNew;
   
}
