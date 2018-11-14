
package mersattech.barqexpdriver.Models.s.ModifyPreference;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("DriverUserID")
    @Expose
    private Integer driverUserID;
    @SerializedName("ServiceTypeIndicator")
    @Expose
    private Integer serviceTypeIndicator;
    @SerializedName("LocalCityID")
    @Expose
    private Integer localCityID;
    @SerializedName("DomesticFromCityID")
    @Expose
    private Integer domesticFromCityID;
    @SerializedName("DomesticToCityID")
    @Expose
    private Integer domesticToCityID;
    @SerializedName("AvailabilityFromTime")
    @Expose
    private String availabilityFromTime;
    @SerializedName("AvailabilityToTime")
    @Expose
    private String availabilityToTime;

    public Integer getDriverUserID() {
        return driverUserID;
    }

    public void setDriverUserID(Integer driverUserID) {
        this.driverUserID = driverUserID;
    }

    public Integer getServiceTypeIndicator() {
        return serviceTypeIndicator;
    }

    public void setServiceTypeIndicator(Integer serviceTypeIndicator) {
        this.serviceTypeIndicator = serviceTypeIndicator;
    }

    public Integer getLocalCityID() {
        return localCityID;
    }

    public void setLocalCityID(Integer localCityID) {
        this.localCityID = localCityID;
    }

    public Integer getDomesticFromCityID() {
        return domesticFromCityID;
    }

    public void setDomesticFromCityID(Integer domesticFromCityID) {
        this.domesticFromCityID = domesticFromCityID;
    }

    public Integer getDomesticToCityID() {
        return domesticToCityID;
    }

    public void setDomesticToCityID(Integer domesticToCityID) {
        this.domesticToCityID = domesticToCityID;
    }

    public String getAvailabilityFromTime() {
        return availabilityFromTime;
    }

    public void setAvailabilityFromTime(String availabilityFromTime) {
        this.availabilityFromTime = availabilityFromTime;
    }

    public String getAvailabilityToTime() {
        return availabilityToTime;
    }

    public void setAvailabilityToTime(String availabilityToTime) {
        this.availabilityToTime = availabilityToTime;
    }

}
