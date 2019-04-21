package model;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Admin implements java.io.Serializable {

    private String adminid;
    private String adminname;
    private String password;

    public String getAdminid(){
        return this.adminid;
    }

    public void setAdminid(String adminid){
        this.adminid=adminid;
    }

    public String getAdminname()
    {
        return this.adminname;
    }

    public void setAdminname(String adminname)
    {
        this.adminname=adminname;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

}



