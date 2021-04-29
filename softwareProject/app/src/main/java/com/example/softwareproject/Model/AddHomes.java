package com.example.softwareproject.Model;

public class AddHomes {
  String result_status;
  int code ;
  String Address,
  Rooms,
  Gender,
  Rent,
  Description,
  Owner_ID;

  public String getResult_status() {
    return result_status;
  }

  public void setResult_status(String result_status) {
    this.result_status = result_status;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
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
}
