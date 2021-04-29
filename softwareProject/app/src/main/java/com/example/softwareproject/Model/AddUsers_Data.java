package com.example.softwareproject.Model;

import java.util.ArrayList;

public class AddUsers_Data {
  String result_status;
  int result_code;
  String
          Full_Name,
          Gender,
          phone_num,
          email,
          pass_word;

  public String getResult_status() {
    return result_status;
  }

  public void setResult_status(String result_status) {
    this.result_status = result_status;
  }

  public int getResult_code() {
    return result_code;
  }

  public void setResult_code(int result_code) {
    this.result_code = result_code;
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
