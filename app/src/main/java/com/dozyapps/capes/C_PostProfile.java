package com.dozyapps.capes;

public class C_PostProfile {

   public String company_name;
 
    public String contact;
    public String emailid;

    public C_PostProfile(String company_name, String contact, String emailid) {
        this.company_name = company_name;
     
        this.contact = contact;
        this.emailid = emailid;
    }



    public C_PostProfile(String company_name, String contact) {
    }
}
