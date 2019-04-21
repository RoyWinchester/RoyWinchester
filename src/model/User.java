package model;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable {


    private String userid;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String address;
    private String post;
    private String email;
    private Integer type;
    private Date regtime;
    private Date logintime;
    private Set orderses = new HashSet(0);

    public Date getLogintime() {
        return this.logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getRegtime() {
        return this.regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return this.post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Constructors

    /** default constructor */
    public User() {
    }

    /** minimal constructor */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** full constructor */
    public User(String username, String password, String sex, Integer type,
                Set orderses) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.type = type;
        this.orderses = orderses;
    }

    // Property accessors

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Set getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set orderses) {
        this.orderses = orderses;
    }

}
