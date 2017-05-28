package com.ck.mcs;

public class Users {
	private String ID;
	private String Name;
	private String Pwd;
	private String Email;
	private String Tel;
	private String CreateTime;
	private String Picture;
	
	public String getID() {
		return ID;
	}
	public void setID(String userID) {
		this.ID = userID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String userName) {
		this.Name = userName;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String userPwd) {
		this.Pwd = userPwd;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String userEmail) {
		this.Email = userEmail;
	}
    public String getTel() {
        return Tel;
    }
    public void setTel(String tel) {
        Tel = tel;
    }
    public String getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }
    /**
     * @return the picture
     */
    public String getPicture() {
        return Picture;
    }
    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        Picture = picture;
    }
	
}
