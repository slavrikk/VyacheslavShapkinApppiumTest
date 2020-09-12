package bean;

import com.google.gson.annotations.Expose;

public class DataBean {

  @Expose
  private String email;

  @Expose
  private String userName;

  @Expose
  private String password;

  public String getEmail() {
    return email;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }
}
