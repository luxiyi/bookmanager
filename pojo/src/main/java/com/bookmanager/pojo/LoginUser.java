package com.bookmanager.pojo;

import java.io.Serializable;

public class LoginUser implements Serializable {

  private static final long serialVersionUID = -4747060271344691281L;

  private String luser;

  private String pass;

  private String confirm;

  private Integer flag;

  public LoginUser() {
  }

  public LoginUser(String luser, String pass, String confirm, Integer flag) {
      this.luser = luser;
      this.pass = pass;
      this.confirm = confirm;
      this.flag = flag;
  }

  public String getLuser() {
      return luser;
  }

  public void setLuser(String luser) {
      this.luser = luser;
  }

  public String getPass() {
      return pass;
  }

  public void setPass(String pass) {
      this.pass = pass;
  }

  public String getConfirm() {
      return confirm;
  }

  public void setConfirm(String confirm) {
      this.confirm = confirm;
  }

  public Integer getFlag() {
      return flag;
  }

  public void setFlag(Integer flag) {
      this.flag = flag;
  }
}