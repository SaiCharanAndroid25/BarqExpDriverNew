
package mersattech.barqexpdriver.Models.s.Triptracking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("OrderTripSegmentID")
    @Expose
    private Object orderTripSegmentID;
    @SerializedName("OperationTime")
    @Expose
    private Object operationTime;
    @SerializedName("DriverLatitude")
    @Expose
    private Object driverLatitude;
    @SerializedName("DriverLongitude")
    @Expose
    private Object driverLongitude;
    @SerializedName("DriverUserID")
    @Expose
    private Object driverUserID;
    @SerializedName("DriverName")
    @Expose
    private Object driverName;
    @SerializedName("DeliveryOrderID")
    @Expose
    private Integer deliveryOrderID;
    @SerializedName("DeliveryRequestID")
    @Expose
    private Integer deliveryRequestID;
    @SerializedName("Distance")
    @Expose
    private Integer distance;
    @SerializedName("DriverGeolocation")
    @Expose
    private Object driverGeolocation;
    @SerializedName("startlocationlatitude")
    @Expose
    private Integer startlocationlatitude;
    @SerializedName("startlocationlongitude")
    @Expose
    private Integer startlocationlongitude;
    @SerializedName("endlocationlatitude")
    @Expose
    private Integer endlocationlatitude;
    @SerializedName("endlocationlongitude")
    @Expose
    private Integer endlocationlongitude;
    @SerializedName("OrderStatusIndicator")
    @Expose
    private Integer orderStatusIndicator;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Object getOrderTripSegmentID() {
        return orderTripSegmentID;
    }

    public void setOrderTripSegmentID(Object orderTripSegmentID) {
        this.orderTripSegmentID = orderTripSegmentID;
    }

    public Object getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Object operationTime) {
        this.operationTime = operationTime;
    }

    public Object getDriverLatitude() {
        return driverLatitude;
    }

    public void setDriverLatitude(Object driverLatitude) {
        this.driverLatitude = driverLatitude;
    }

    public Object getDriverLongitude() {
        return driverLongitude;
    }

    public void setDriverLongitude(Object driverLongitude) {
        this.driverLongitude = driverLongitude;
    }

    public Object getDriverUserID() {
        return driverUserID;
    }

    public void setDriverUserID(Object driverUserID) {
        this.driverUserID = driverUserID;
    }

    public Object getDriverName() {
        return driverName;
    }

    public void setDriverName(Object driverName) {
        this.driverName = driverName;
    }

    public Integer getDeliveryOrderID() {
        return deliveryOrderID;
    }

    public void setDeliveryOrderID(Integer deliveryOrderID) {
        this.deliveryOrderID = deliveryOrderID;
    }

    public Integer getDeliveryRequestID() {
        return deliveryRequestID;
    }

    public void setDeliveryRequestID(Integer deliveryRequestID) {
        this.deliveryRequestID = deliveryRequestID;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Object getDriverGeolocation() {
        return driverGeolocation;
    }

    public void setDriverGeolocation(Object driverGeolocation) {
        this.driverGeolocation = driverGeolocation;
    }

    public Integer getStartlocationlatitude() {
        return startlocationlatitude;
    }

    public void setStartlocationlatitude(Integer startlocationlatitude) {
        this.startlocationlatitude = startlocationlatitude;
    }

    public Integer getStartlocationlongitude() {
        return startlocationlongitude;
    }

    public void setStartlocationlongitude(Integer startlocationlongitude) {
        this.startlocationlongitude = startlocationlongitude;
    }

    public Integer getEndlocationlatitude() {
        return endlocationlatitude;
    }

    public void setEndlocationlatitude(Integer endlocationlatitude) {
        this.endlocationlatitude = endlocationlatitude;
    }

    public Integer getEndlocationlongitude() {
        return endlocationlongitude;
    }

    public void setEndlocationlongitude(Integer endlocationlongitude) {
        this.endlocationlongitude = endlocationlongitude;
    }

    public Integer getOrderStatusIndicator() {
        return orderStatusIndicator;
    }

    public void setOrderStatusIndicator(Integer orderStatusIndicator) {
        this.orderStatusIndicator = orderStatusIndicator;
    }

}
