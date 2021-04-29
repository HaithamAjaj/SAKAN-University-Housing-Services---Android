package com.example.softwareproject.Model;

public class Users {
  String User_ID,
  Full_Name,
  Gender,
  phone_num,
  email,
  pass_word;

  public String getUser_ID() {
    return User_ID;
  }

  public void setUser_ID(String user_ID) {
    User_ID = user_ID;
  }

  public String getFull_Name() {
    return Full_Name;
  }

  public void setFull_Name(String full_Name) {
    Full_Name = full_Name;
  }

  public String getGender() {
    return Gender;
  }

  public void setGender(String gender) {
    Gender = gender;
  }

  public String getPhone_num() {
    return phone_num;
  }

  public void setPhone_num(String phone_num) {
    this.phone_num = phone_num;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPass_word() {
    return pass_word;
  }

  public void setPass_word(String pass_word) {
    this.pass_word = pass_word;
  }
}
