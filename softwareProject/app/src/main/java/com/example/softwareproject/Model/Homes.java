package com.example.softwareproject.Model;

public class Homes {

  String Home_ID,
          Address,
          Rooms,
          Gender,
          Rent,
          Description,
          Owner_ID,
          reg_date;

  public static final String OBJECT_KEY = "info_object";

  public String getHome_ID() {
    return Home_ID;
  }

  public void setHome_ID(String home_ID) {
    Home_ID = home_ID;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public String getRooms() {
    return Rooms;
  }

  public void setRooms(String rooms) {
    Rooms = rooms;
  }

  public String getGender() {
    return Gender;
  }

  public void setGender(String gender) {
    Gender = gender;
  }

  public String getRent() {
    return Rent;
  }

  public void setRent(String rent) {
    Rent = rent;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    Description = description;
  }

  public String getOwner_ID() {
    return Owner_ID;
  }

  public void setOwner_ID(String owner_ID) {
    Owner_ID = owner_ID;
  }

  public String getReg_date() {
    return reg_date;
  }

  public void setReg_date(String reg_date) {
    this.reg_date = reg_date;
  }
}
