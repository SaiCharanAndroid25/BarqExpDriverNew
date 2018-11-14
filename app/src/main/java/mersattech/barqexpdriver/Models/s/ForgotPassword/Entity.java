package mersattech.barqexpdriver.Models.s.ForgotPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Password")
    @Expose
    private Object password;
    @SerializedName("CreatedOn")
    @Expose
    private Object createdOn;
    @SerializedName("UpdatedOn")
    @Expose
    private String updatedOn;
    @SerializedName("UserTypesID")
    @Expose
    private Integer userTypesID;
    @SerializedName("ActivationCode")
    @Expose
    private String activationCode;
    @SerializedName("IsActivated")
    @Expose
    private Boolean isActivated;
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
    private String alternatePhoneNumber;
    @SerializedName("CityID")
    @Expose
    private Integer cityID;
    @SerializedName("CountryID")
    @Expose
    private Integer countryID;
    @SerializedName("Language")
    @Expose
    private Integer language;
    @SerializedName("Nationality_Id")
    @Expose
    private Object nationalityId;
    @SerializedName("DoB")
    @Expose
    private String doB;
    @SerializedName("DoB_Hijri")
    @Expose
    private String doBHijri;
    @SerializedName("DoB_Entered_Is_Hijri")
    @Expose
    private Boolean doBEnteredIsHijri;
    @SerializedName("Photograph_Id")
    @Expose
    private String photographId;
    @SerializedName("Block_Id")
    @Expose
    private Integer blockId;
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
    private Object driverId;
    @SerializedName("Bank_ID")
    @Expose
    private Object bankID;
    @SerializedName("Vehicle_ID")
    @Expose
    private Object vehicleID;
    @SerializedName("IsOnline")
    @Expose
    private Object isOnline;
    @SerializedName("DriverIsActive")
    @Expose
    private Boolean driverIsActive;
    @SerializedName("IsApproved")
    @Expose
    private Boolean isApproved;
    @SerializedName("CompanyID")
    @Expose
    private Object companyID;
    @SerializedName("DrivingLicenseExpirationDate")
    @Expose
    private Object drivingLicenseExpirationDate;
    @SerializedName("VehicleLicenseExpirationDate")
    @Expose
    private Object vehicleLicenseExpirationDate;
    @SerializedName("InsuranceExpirationDate")
    @Expose
    private Object insuranceExpirationDate;
    @SerializedName("LoginUserType")
    @Expose
    private Object loginUserType;
    @SerializedName("ExtensionCode")
    @Expose
    private Object extensionCode;
    @SerializedName("UserType")
    @Expose
    private UserType userType;
    @SerializedName("OldPassword")
    @Expose
    private Object oldPassword;
    @SerializedName("MobileNumberISExist")
    @Expose
    private Object mobileNumberISExist;
    @SerializedName("Latitude")
    @Expose
    private Integer latitude;
    @SerializedName("Lonitude")
    @Expose
    private Integer lonitude;
    @SerializedName("Address")
    @Expose
    private Object address;
    @SerializedName("access_token")
    @Expose
    private Object accessToken;
    @SerializedName("access_token_expiry")
    @Expose
    private String accessTokenExpiry;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Object getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Object createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Integer getUserTypesID() {
        return userTypesID;
    }

    public void setUserTypesID(Integer userTypesID) {
        this.userTypesID = userTypesID;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Boolean getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(Boolean isActivated) {
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

    public String getAlternatePhoneNumber() {
        return alternatePhoneNumber;
    }

    public void setAlternatePhoneNumber(String alternatePhoneNumber) {
        this.alternatePhoneNumber = alternatePhoneNumber;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Object getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Object nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getDoBHijri() {
        return doBHijri;
    }

    public void setDoBHijri(String doBHijri) {
        this.doBHijri = doBHijri;
    }

    public Boolean getDoBEnteredIsHijri() {
        return doBEnteredIsHijri;
    }

    public void setDoBEnteredIsHijri(Boolean doBEnteredIsHijri) {
        this.doBEnteredIsHijri = doBEnteredIsHijri;
    }

    public String getPhotographId() {
        return photographId;
    }

    public void setPhotographId(String photographId) {
        this.photographId = photographId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
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

    public Object getDriverId() {
        return driverId;
    }

    public void setDriverId(Object driverId) {
        this.driverId = driverId;
    }

    public Object getBankID() {
        return bankID;
    }

    public void setBankID(Object bankID) {
        this.bankID = bankID;
    }

    public Object getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Object vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Object getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Object isOnline) {
        this.isOnline = isOnline;
    }

    public Boolean getDriverIsActive() {
        return driverIsActive;
    }

    public void setDriverIsActive(Boolean driverIsActive) {
        this.driverIsActive = driverIsActive;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Object getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Object companyID) {
        this.companyID = companyID;
    }

    public Object getDrivingLicenseExpirationDate() {
        return drivingLicenseExpirationDate;
    }

    public void setDrivingLicenseExpirationDate(Object drivingLicenseExpirationDate) {
        this.drivingLicenseExpirationDate = drivingLicenseExpirationDate;
    }

    public Object getVehicleLicenseExpirationDate() {
        return vehicleLicenseExpirationDate;
    }

    public void setVehicleLicenseExpirationDate(Object vehicleLicenseExpirationDate) {
        this.vehicleLicenseExpirationDate = vehicleLicenseExpirationDate;
    }

    public Object getInsuranceExpirationDate() {
        return insuranceExpirationDate;
    }

    public void setInsuranceExpirationDate(Object insuranceExpirationDate) {
        this.insuranceExpirationDate = insuranceExpirationDate;
    }

    public Object getLoginUserType() {
        return loginUserType;
    }

    public void setLoginUserType(Object loginUserType) {
        this.loginUserType = loginUserType;
    }

    public Object getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(Object extensionCode) {
        this.extensionCode = extensionCode;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Object getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(Object oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Object getMobileNumberISExist() {
        return mobileNumberISExist;
    }

    public void setMobileNumberISExist(Object mobileNumberISExist) {
        this.mobileNumberISExist = mobileNumberISExist;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLonitude() {
        return lonitude;
    }

    public void setLonitude(Integer lonitude) {
        this.lonitude = lonitude;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Object accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenExpiry() {
        return accessTokenExpiry;
    }

    public void setAccessTokenExpiry(String accessTokenExpiry) {
        this.accessTokenExpiry = accessTokenExpiry;
    }
}
