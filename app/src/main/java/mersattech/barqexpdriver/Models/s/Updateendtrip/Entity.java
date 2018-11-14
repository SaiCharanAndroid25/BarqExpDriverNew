
package mersattech.barqexpdriver.Models.s.Updateendtrip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("TripMasterID")
    @Expose
    private Object tripMasterID;
    @SerializedName("StartTime")
    @Expose
    private Object startTime;
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
    private Object startLocationLatitude;
    @SerializedName("StartLocationLongitude")
    @Expose
    private Object startLocationLongitude;
    @SerializedName("EndLocationLatitude")
    @Expose
    private Object endLocationLatitude;
    @SerializedName("EndLocationLongitude")
    @Expose
    private Object endLocationLongitude;
    @SerializedName("ActualTravelTime")
    @Expose
    private Object actualTravelTime;
    @SerializedName("TripSegmentType")
    @Expose
    private Object tripSegmentType;
    @SerializedName("TripSegmentStatusIndicator")
    @Expose
    private Object tripSegmentStatusIndicator;
    @SerializedName("TripSegmentSequenceNumber")
    @Expose
    private Object tripSegmentSequenceNumber;
    @SerializedName("DeliveryRequestID")
    @Expose
    private Object deliveryRequestID;
    @SerializedName("DeliveryRequestTrackingNumber")
    @Expose
    private Object deliveryRequestTrackingNumber;
    @SerializedName("CompanyName")
    @Expose
    private Object companyName;
    @SerializedName("Status")
    @Expose
    private Object status;
    @SerializedName("DeliveryStatusId")
    @Expose
    private Object deliveryStatusId;
    @SerializedName("DeliveryRequestReturnReasonID")
    @Expose
    private int deliveryRequestReturnReasonID;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Object getTripMasterID() {
        return tripMasterID;
    }

    public void setTripMasterID(Object tripMasterID) {
        this.tripMasterID = tripMasterID;
    }

    public Object getStartTime() {
        return startTime;
    }

    public void setStartTime(Object startTime) {
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

    public Object getStartLocationLatitude() {
        return startLocationLatitude;
    }

    public void setStartLocationLatitude(Object startLocationLatitude) {
        this.startLocationLatitude = startLocationLatitude;
    }

    public Object getStartLocationLongitude() {
        return startLocationLongitude;
    }

    public void setStartLocationLongitude(Object startLocationLongitude) {
        this.startLocationLongitude = startLocationLongitude;
    }

    public Object getEndLocationLatitude() {
        return endLocationLatitude;
    }

    public void setEndLocationLatitude(Object endLocationLatitude) {
        this.endLocationLatitude = endLocationLatitude;
    }

    public Object getEndLocationLongitude() {
        return endLocationLongitude;
    }

    public void setEndLocationLongitude(Object endLocationLongitude) {
        this.endLocationLongitude = endLocationLongitude;
    }

    public Object getActualTravelTime() {
        return actualTravelTime;
    }

    public void setActualTravelTime(Object actualTravelTime) {
        this.actualTravelTime = actualTravelTime;
    }

    public Object getTripSegmentType() {
        return tripSegmentType;
    }

    public void setTripSegmentType(Object tripSegmentType) {
        this.tripSegmentType = tripSegmentType;
    }

    public Object getTripSegmentStatusIndicator() {
        return tripSegmentStatusIndicator;
    }

    public void setTripSegmentStatusIndicator(Object tripSegmentStatusIndicator) {
        this.tripSegmentStatusIndicator = tripSegmentStatusIndicator;
    }

    public Object getTripSegmentSequenceNumber() {
        return tripSegmentSequenceNumber;
    }

    public void setTripSegmentSequenceNumber(Object tripSegmentSequenceNumber) {
        this.tripSegmentSequenceNumber = tripSegmentSequenceNumber;
    }

    public Object getDeliveryRequestID() {
        return deliveryRequestID;
    }

    public void setDeliveryRequestID(Object deliveryRequestID) {
        this.deliveryRequestID = deliveryRequestID;
    }

    public Object getDeliveryRequestTrackingNumber() {
        return deliveryRequestTrackingNumber;
    }

    public void setDeliveryRequestTrackingNumber(Object deliveryRequestTrackingNumber) {
        this.deliveryRequestTrackingNumber = deliveryRequestTrackingNumber;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(Object deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
    }

    public int getDeliveryRequestReturnReasonID() {
        return deliveryRequestReturnReasonID;
    }

    public void setDeliveryRequestReturnReasonID(int deliveryRequestReturnReasonID) {
        this.deliveryRequestReturnReasonID = deliveryRequestReturnReasonID;
    }
}
