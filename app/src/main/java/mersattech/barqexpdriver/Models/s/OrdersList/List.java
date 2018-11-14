
package mersattech.barqexpdriver.Models.s.OrdersList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("deliveryorderid")
    @Expose
    private Integer deliveryorderid;
    @SerializedName("DeliveryRequestId")
    @Expose
    private Integer deliveryRequestId;
    @SerializedName("DeliveryRequestShippingStatusIndicator")
    @Expose
    private Integer deliveryRequestShippingStatusIndicator;
    @SerializedName("DriverUserId")
    @Expose
    private Integer driverUserId;
    @SerializedName("OrderStatusIndicator")
    @Expose
    private Integer orderStatusIndicator;
    @SerializedName("deliveryRequestEntity")
    @Expose
    private DeliveryRequestEntity deliveryRequestEntity;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getDeliveryorderid() {
        return deliveryorderid;
    }

    public void setDeliveryorderid(Integer deliveryorderid) {
        this.deliveryorderid = deliveryorderid;
    }

    public Integer getDeliveryRequestId() {
        return deliveryRequestId;
    }

    public void setDeliveryRequestId(Integer deliveryRequestId) {
        this.deliveryRequestId = deliveryRequestId;
    }

    public Integer getDeliveryRequestShippingStatusIndicator() {
        return deliveryRequestShippingStatusIndicator;
    }

    public void setDeliveryRequestShippingStatusIndicator(Integer deliveryRequestShippingStatusIndicator) {
        this.deliveryRequestShippingStatusIndicator = deliveryRequestShippingStatusIndicator;
    }

    public Integer getDriverUserId() {
        return driverUserId;
    }

    public void setDriverUserId(Integer driverUserId) {
        this.driverUserId = driverUserId;
    }

    public Integer getOrderStatusIndicator() {
        return orderStatusIndicator;
    }

    public void setOrderStatusIndicator(Integer orderStatusIndicator) {
        this.orderStatusIndicator = orderStatusIndicator;
    }

    public DeliveryRequestEntity getDeliveryRequestEntity() {
        return deliveryRequestEntity;
    }

    public void setDeliveryRequestEntity(DeliveryRequestEntity deliveryRequestEntity) {
        this.deliveryRequestEntity = deliveryRequestEntity;
    }

}
