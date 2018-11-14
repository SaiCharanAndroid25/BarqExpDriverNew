
package mersattech.barqexpdriver.Models.s.OrderSequence;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderTripSegmentEntity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("TripMasterID")
    @Expose
    private Integer tripMasterID;
    @SerializedName("StartTime")
    @Expose
    private String startTime;
    @SerializedName("EndTime")
    @Expose
    private Object endTime;
    @SerializedName("EstimatedTravelTime")
    @Expose
    private Object estimatedTravelTime;
    @SerializedName("EstimatedDistance")
    @Expose
    private Object estimatedDistance;
    @SerializedName("ActualDistanceTravelled")
    @Expose
    private Object actualDistanceTravelled;
    @SerializedName("StartLocationLatitude")
    @Expose
    private Double startLocationLatitude;
    @SerializedName("StartLocationLongitude")
    @Expose
    private Double startLocationLongitude;
    @SerializedName("EndLocationLatitude")
    @Expose
    private Double endLocationLatitude;
    @SerializedName("EndLocationLongitude")
    @Expose
    private Double endLocationLongitude;
    @SerializedName("ActualTravelTime")
    @Expose
    private Object actualTravelTime;
    @SerializedName("TripSegmentType")
    @Expose
    private String tripSegmentType;
    @SerializedName("TripSegmentStatusIndicator")
    @Expose
    private Integer tripSegmentStatusIndicator;
    @SerializedName("TripSegmentSequenceNumber")
    @Expose
    private Integer tripSegmentSequenceNumber;
    @SerializedName("DeliveryRequestID")
    @Expose
    private Integer deliveryRequestID;
    @SerializedName("DeliveryRequestTrackingNumber")
    @Expose
    private String deliveryRequestTrackingNumber;
    @SerializedName("CompanyName")
    @Expose
    private String companyName;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("DeliveryStatusId")
    @Expose
    private Integer deliveryStatusId;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getTripMasterID() {
        return tripMasterID;
    }

    public void setTripMasterID(Integer tripMasterID) {
        this.tripMasterID = tripMasterID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public Object getEstimatedTravelTime() {
        return estimatedTravelTime;
    }

    public void setEstimatedTravelTime(Object estimatedTravelTime) {
        this.estimatedTravelTime = estimatedTravelTime;
    }

    public Object getEstimatedDistance() {
        return estimatedDistance;
    }

    public void setEstimatedDistance(Object estimatedDistance) {
        this.estimatedDistance = estimatedDistance;
    }

    public Object getActualDistanceTravelled() {
        return actualDistanceTravelled;
    }

    public void setActualDistanceTravelled(Object actualDistanceTravelled) {
        this.actualDistanceTravelled = actualDistanceTravelled;
    }

    public Double getStartLocationLatitude() {
        return startLocationLatitude;
    }

    public void setStartLocationLatitude(Double startLocationLatitude) {
        this.startLocationLatitude = startLocationLatitude;
    }

    public Double getStartLocationLongitude() {
        return startLocationLongitude;
    }

    public void setStartLocationLongitude(Double startLocationLongitude) {
        this.startLocationLongitude = startLocationLongitude;
    }

    public Double getEndLocationLatitude() {
        return endLocationLatitude;
    }

    public void setEndLocationLatitude(Double endLocationLatitude) {
        this.endLocationLatitude = endLocationLatitude;
    }

    public Double getEndLocationLongitude() {
        return endLocationLongitude;
    }

    public void setEndLocationLongitude(Double endLocationLongitude) {
        this.endLocationLongitude = endLocationLongitude;
    }

    public Object getActualTravelTime() {
        return actualTravelTime;
    }

    public void setActualTravelTime(Object actualTravelTime) {
        this.actualTravelTime = actualTravelTime;
    }

    public String getTripSegmentType() {
        return tripSegmentType;
    }

    public void setTripSegmentType(String tripSegmentType) {
        this.tripSegmentType = tripSegmentType;
    }

    public Integer getTripSegmentStatusIndicator() {
        return tripSegmentStatusIndicator;
    }

    public void setTripSegmentStatusIndicator(Integer tripSegmentStatusIndicator) {
        this.tripSegmentStatusIndicator = tripSegmentStatusIndicator;
    }

    public Integer getTripSegmentSequenceNumber() {
        return tripSegmentSequenceNumber;
    }

    public void setTripSegmentSequenceNumber(Integer tripSegmentSequenceNumber) {
        this.tripSegmentSequenceNumber = tripSegmentSequenceNumber;
    }

    public Integer getDeliveryRequestID() {
        return deliveryRequestID;
    }

    public void setDeliveryRequestID(Integer deliveryRequestID) {
        this.deliveryRequestID = deliveryRequestID;
    }

    public String getDeliveryRequestTrackingNumber() {
        return deliveryRequestTrackingNumber;
    }

    public void setDeliveryRequestTrackingNumber(String deliveryRequestTrackingNumber) {
        this.deliveryRequestTrackingNumber = deliveryRequestTrackingNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(Integer deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
    }

}
