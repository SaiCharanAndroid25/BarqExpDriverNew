package mersattech.barqexpdriver.Models.s.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("Password")
    @Expose
    private Object password;
    @SerializedName("CreatedOn")
    @Expose
    private String createdOn;
    @SerializedName("UpdatedOn")
    @Expose
    private String updatedOn;
    @SerializedName("UserTypesID")
    @Expose
    private int userTypesID;
    @SerializedName("ActivationCode")
    @Expose
    private String activationCode;
    @SerializedName("IsActivated")
    @Expose
    private boolean isActivated;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("AlternatePhoneNumber")
    @Expose
    private String alternateMobileNumber;
    @SerializedName("CityID")
    @Expose
    private Object cityID;
    @SerializedName("CountryID")
    @Expose
    private int countryID;
    @SerializedName("Language")
    @Expose
    private int language;
    @SerializedName("Nationality_Id")
    @Expose
    private Object nationalityId;
    @SerializedName("DoB")
    @Expose
    private Object doB;
    @SerializedName("DoB_Hijri")
    @Expose
    private String doBHijri;
    @SerializedName("DoB_Entered_Is_Hijri")
    @Expose
    private boolean doBEnteredIsHijri;
    @SerializedName("Photograph_Id")
    @Expose
    private String photographId;
    @SerializedName("Block_Id")
    @Expose
    private int blockId;
    @SerializedName("StreetName")
    @Expose
    private String streetName;
    @SerializedName("BuildingNumber")
    @Expose
    private String buildingNumber;
    @SerializedName("ProfilePhoto")
    @Expose
    private Object profilePhoto;
    @SerializedName("Driver_Id")
    @Expose
    private int driverId;
    @SerializedName("Bank_ID")
    @Expose
    private Object bankID;
    @SerializedName("Vehicle_ID")
    @Expose
    private int vehicleID;
    @SerializedName("IsOnline")
    @Expose
    private boolean isOnline;
    @SerializedName("access_token")
    @Expose
    private String token;

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getAlternateMobileNumber() {
        return alternateMobileNumber;
    }

    public void setAlternateMobileNumber(String alternateMobileNumber) {
        this.alternateMobileNumber = alternateMobileNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public int getUserTypesID() {
        return userTypesID;
    }

    public void setUserTypesID(int userTypesID) {
        this.userTypesID = userTypesID;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public boolean isIsActivated() {
        return isActivated;
    }

    public void setIsActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Object getCityID() {
        if (cityID == null) {
            return "0";
        }
        return cityID;
    }

    public void setCityID(Object cityID) {
        this.cityID = cityID;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public Object getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Object nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Object getDoB() {
        return doB;
    }

    public void setDoB(Object doB) {
        this.doB = doB;
    }

    public String getDoBHijri() {
        return doBHijri;
    }

    public void setDoBHijri(String doBHijri) {
        this.doBHijri = doBHijri;
    }

    public boolean isDoBEnteredIsHijri() {
        return doBEnteredIsHijri;
    }

    public void setDoBEnteredIsHijri(boolean doBEnteredIsHijri) {
        this.doBEnteredIsHijri = doBEnteredIsHijri;
    }

    public String getPhotographId() {
        return photographId;
    }

    public void setPhotographId(String photographId) {
        this.photographId = photographId;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Object getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Object profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public Object getBankID() {
        return bankID;
    }

    public void setBankID(Object bankID) {
        this.bankID = bankID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
}
