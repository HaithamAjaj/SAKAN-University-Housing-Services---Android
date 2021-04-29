package com.example.softwareproject.Model;

public class HomeDetails {
  String ownerHomeName,ownerPhoneNumber,ownerHomeSite,numberOfRooms,housePrice,homeDescription;
  String gender ;
  int homeImage ;

  public HomeDetails() {
  }

  public HomeDetails(String ownerHomeName, String ownerPhoneNumber, String ownerHomeSite, String numberOfRooms,
                     String housePrice, String homeDescription, String gender, long homeID) {
    this.ownerHomeName = ownerHomeName;
    this.ownerPhoneNumber = ownerPhoneNumber;
    this.ownerHomeSite = ownerHomeSite;
    this.numberOfRooms = numberOfRooms;
    this.housePrice = housePrice;
    this.homeDescription = homeDescription;
    this.gender = gender;
    this.homeID = homeID;
  }

  long homeID;

  public long getHomeID() {
    return homeID;
  }

  public void setHomeID(long homeID) {
    this.homeID = homeID;
  }

  public HomeDetails(String ownerHomeName, String ownerPhoneNumber, String ownerHomeSite, String numberOfRooms,
                     String housePrice, String homeDescription, String gender, int homeImage, long homeID) {
    this.ownerHomeName = ownerHomeName;
    this.ownerPhoneNumber = ownerPhoneNumber;
    this.ownerHomeSite = ownerHomeSite;
    this.numberOfRooms = numberOfRooms;
    this.housePrice = housePrice;
    this.homeDescription = homeDescription;
    this.gender = gender;
    this.homeImage = homeImage;
    this.homeID = homeID;
  }

  public String getOwnerHomeName() {
    return ownerHomeName;
  }

  public void setOwnerHomeName(String ownerHomeName) {
    this.ownerHomeName = ownerHomeName;
  }

  public String getOwnerPhoneNumber() {
    return ownerPhoneNumber;
  }

  public void setOwnerPhoneNumber(String ownerPhoneNumber) {
    this.ownerPhoneNumber = ownerPhoneNumber;
  }

  public String getOwnerHomeSite() {
    return ownerHomeSite;
  }

  public void setOwnerHomeSite(String ownerHomeSite) {
    this.ownerHomeSite = ownerHomeSite;
  }

  public String getNumberOfRooms() {
    return numberOfRooms;
  }

  public void setNumberOfRooms(String numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }

  public String getHousePrice(String s) {
    return housePrice;
  }

  public void setHousePrice(String housePrice) {
    this.housePrice = housePrice;
  }

  public String getHomeDescription() {
    return homeDescription;
  }

  public void setHomeDescription(String homeDescription) {
    this.homeDescription = homeDescription;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getHomeImage() {
    return homeImage;
  }

  public void setHomeImage(int homeImage) {
    this.homeImage = homeImage;
  }
}
