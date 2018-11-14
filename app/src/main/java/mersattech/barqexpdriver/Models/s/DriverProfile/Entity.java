package mersattech.barqexpdriver.Models.s.DriverProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("StreetName")
    @Expose
    private String streetName;
    @SerializedName("BuildingNumber")
    @Expose
    private String buildingNumber;
    @SerializedName("UserID")
    @Expose
    private Integer userID;
    @SerializedName("NumberOfTrips")
    @Expose
    private Integer numberOfTrips;
    @SerializedName("CreditedAmount")
    @Expose
    private Double creditedAmount;
    @SerializedName("DepositAmount")
    @Expose
    private Integer depositAmount;
    @SerializedName("AddressDetails")
    @Expose
    private Boolean addressDetails;
    @SerializedName("MyDetails")
    @Expose
    private Boolean myDetails;
    @SerializedName("DriverIdentityDocument")
    @Expose
    private Boolean driverIdentityDocument;
    @SerializedName("VehicleDetails")
    @Expose
    private Boolean vehicleDetails;
    @SerializedName("BankDetails")
    @Expose
    private Boolean bankDetails;
    @SerializedName("InsuranceAndLicenseDetails")
    @Expose
    private Boolean insuranceAndLicenseDetails;
    @SerializedName("DrivingLicenseExpirationDate")
    @Expose
    private String drivingLicenseExpirationDate;
    @SerializedName("DrivingLicenseExpirationDate_Hijri")
    @Expose
    private String drivingLicenseExpirationDateHijri;
    @SerializedName("PhotographID")
    @Expose
    private String photographID;
    @SerializedName("VehicleLicenseExpirationDate")
    @Expose
    private String vehicleLicenseExpirationDate;
    @SerializedName("VehicleLicenseExpirationDate_Hijri")
    @Expose
    private String vehicleLicenseExpirationDateHijri;
    @SerializedName("InsuranceExpirationDate")
    @Expose
    private String insuranceExpirationDate;
    @SerializedName("InsuranceExpirationDate_Hijri")
    @Expose
    private String insuranceExpirationDateHijri;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(Integer numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    public Double getCreditedAmount() {
        return creditedAmount;
    }

    public void setCreditedAmount(Double creditedAmount) {
        this.creditedAmount = creditedAmount;
    }

    public Integer getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Integer depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Boolean getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(Boolean addressDetails) {
        this.addressDetails = addressDetails;
    }

    public Boolean getMyDetails() {
        return myDetails;
    }

    public void setMyDetails(Boolean myDetails) {
        this.myDetails = myDetails;
    }

    public Boolean getDriverIdentityDocument() {
        return driverIdentityDocument;
    }

    public void setDriverIdentityDocument(Boolean driverIdentityDocument) {
        this.driverIdentityDocument = driverIdentityDocument;
    }

    public Boolean getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(Boolean vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public Boolean getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(Boolean bankDetails) {
        this.bankDetails = bankDetails;
    }

    public Boolean getInsuranceAndLicenseDetails() {
        return insuranceAndLicenseDetails;
    }

    public void setInsuranceAndLicenseDetails(Boolean insuranceAndLicenseDetails) {
        this.insuranceAndLicenseDetails = insuranceAndLicenseDetails;
    }

    public String getDrivingLicenseExpirationDate() {
        return drivingLicenseExpirationDate;
    }

    public void setDrivingLicenseExpirationDate(String drivingLicenseExpirationDate) {
        this.drivingLicenseExpirationDate = drivingLicenseExpirationDate;
    }

    public String getDrivingLicenseExpirationDateHijri() {
        return drivingLicenseExpirationDateHijri;
    }

    public void setDrivingLicenseExpirationDateHijri(String drivingLicenseExpirationDateHijri) {
        this.drivingLicenseExpirationDateHijri = drivingLicenseExpirationDateHijri;
    }

    public String getPhotographID() {
        return photographID;
    }

    public void setPhotographID(String photographID) {
        this.photographID = photographID;
    }

    public String getVehicleLicenseExpirationDate() {
        return vehicleLicenseExpirationDate;
    }

    public void setVehicleLicenseExpirationDate(String vehicleLicenseExpirationDate) {
        this.vehicleLicenseExpirationDate = vehicleLicenseExpirationDate;
    }

    public String getVehicleLicenseExpirationDateHijri() {
        return vehicleLicenseExpirationDateHijri;
    }

    public void setVehicleLicenseExpirationDateHijri(String vehicleLicenseExpirationDateHijri) {
        this.vehicleLicenseExpirationDateHijri = vehicleLicenseExpirationDateHijri;
    }

    public String getInsuranceExpirationDate() {
        return insuranceExpirationDate;
    }

    public void setInsuranceExpirationDate(String insuranceExpirationDate) {
        this.insuranceExpirationDate = insuranceExpirationDate;
    }

    public String getInsuranceExpirationDateHijri() {
        return insuranceExpirationDateHijri;
    }

    public void setInsuranceExpirationDateHijri(String insuranceExpirationDateHijri) {
        this.insuranceExpirationDateHijri = insuranceExpirationDateHijri;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
