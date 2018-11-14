
package mersattech.barqexpdriver.Models.s.Registration.Driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("UserID")
    @Expose
    private int userID;
    @SerializedName("NumberOfTrips")
    @Expose
    private int numberOfTrips;
    @SerializedName("CreditedAmount")
    @Expose
    private float creditedAmount;
    @SerializedName("DepositAmount")
    @Expose
    private int depositAmount;
    @SerializedName("AddressDetails")
    @Expose
    private boolean addressDetails;
    @SerializedName("MyDetails")
    @Expose
    private boolean myDetails;
    @SerializedName("DriverIdentityDocument")
    @Expose
    private boolean driverIdentityDocument;
    @SerializedName("VehicleDetails")
    @Expose
    private boolean vehicleDetails;
    @SerializedName("BankDetails")
    @Expose
    private boolean bankDetails;
    @SerializedName("InsuranceAndLicenseDetails")
    @Expose
    private boolean insuranceAndLicenseDetails;
    @SerializedName("DrivingLicenseExpirationDate")
    @Expose
    private String drivingLicenseExpirationDate;
    @SerializedName("DrivingLicenseExpirationDate_Hijri")
    @Expose
    private String drivingLicenseExpirationDateHijri;
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
    @SerializedName("PhotographID")
    @Expose
    private String photographId;

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    public float getCreditedAmount() {
        return creditedAmount;
    }

    public void setCreditedAmount(float creditedAmount) {
        this.creditedAmount = creditedAmount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public boolean isAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(boolean addressDetails) {
        this.addressDetails = addressDetails;
    }

    public boolean isMyDetails() {
        return myDetails;
    }

    public void setMyDetails(boolean myDetails) {
        this.myDetails = myDetails;
    }

    public boolean isDriverIdentityDocument() {
        return driverIdentityDocument;
    }

    public void setDriverIdentityDocument(boolean driverIdentityDocument) {
        this.driverIdentityDocument = driverIdentityDocument;
    }

    public boolean isVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(boolean vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public boolean isBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(boolean bankDetails) {
        this.bankDetails = bankDetails;
    }

    public boolean isInsuranceAndLicenseDetails() {
        return insuranceAndLicenseDetails;
    }

    public void setInsuranceAndLicenseDetails(boolean insuranceAndLicenseDetails) {
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

    public String getPhotographId() {
        return photographId;
    }

    public void setPhotographId(String photographId) {
        this.photographId = photographId;
    }
}
