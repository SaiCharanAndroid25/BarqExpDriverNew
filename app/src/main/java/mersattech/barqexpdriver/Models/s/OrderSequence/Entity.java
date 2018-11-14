
package mersattech.barqexpdriver.Models.s.OrderSequence;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("DriverUserID")
    @Expose
    private Integer driverUserID;
    @SerializedName("DeliveryOrderID")
    @Expose
    private Integer deliveryOrderID;
    @SerializedName("TripStartTime")
    @Expose
    private String tripStartTime;
    @SerializedName("TripEndTime")
    @Expose
    private Object tripEndTime;
    @SerializedName("TripSegmentID")
    @Expose
    private Integer tripSegmentID;
    @SerializedName("DeliveryOrderStatusIndicator")
    @Expose
    private Integer deliveryOrderStatusIndicator;
    @SerializedName("OrderTripSegmentEntity")
    @Expose
    private ArrayList<OrderTripSegmentEntity> orderTripSegmentEntity = null;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getDriverUserID() {
        return driverUserID;
    }

    public void setDriverUserID(Integer driverUserID) {
        this.driverUserID = driverUserID;
    }

    public Integer getDeliveryOrderID() {
        return deliveryOrderID;
    }

    public void setDeliveryOrderID(Integer deliveryOrderID) {
        this.deliveryOrderID = deliveryOrderID;
    }

    public String getTripStartTime() {
        return tripStartTime;
    }

    public void setTripStartTime(String tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    public Object getTripEndTime() {
        return tripEndTime;
    }

    public void setTripEndTime(Object tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public Integer getTripSegmentID() {
        return tripSegmentID;
    }

    public void setTripSegmentID(Integer tripSegmentID) {
        this.tripSegmentID = tripSegmentID;
    }

    public Integer getDeliveryOrderStatusIndicator() {
        return deliveryOrderStatusIndicator;
    }

    public void setDeliveryOrderStatusIndicator(Integer deliveryOrderStatusIndicator) {
        this.deliveryOrderStatusIndicator = deliveryOrderStatusIndicator;
    }

    public ArrayList<OrderTripSegmentEntity> getOrderTripSegmentEntity() {
        return orderTripSegmentEntity;
    }

    public void setOrderTripSegmentEntity(ArrayList<OrderTripSegmentEntity> orderTripSegmentEntity) {
        this.orderTripSegmentEntity = orderTripSegmentEntity;
    }

}
