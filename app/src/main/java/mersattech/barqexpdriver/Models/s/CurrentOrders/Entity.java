package mersattech.barqexpdriver.Models.s.CurrentOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entity {

    @SerializedName("DRCounts")
    @Expose
    private Integer dRCounts;
    @SerializedName("deliveryRequestDetails")
    @Expose
    private java.util.ArrayList<DeliveryRequestDetail> deliveryRequestDetails = null;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("CreatedDatetime")
    @Expose
    private String createdDatetime;
    @SerializedName("OrderStatus")
    @Expose
    private String orderStatus;
    @SerializedName("isAllDRsPickedUp")
    @Expose
    private String isAllDRsPickedUp;


    public Integer getDRCounts() {
        return dRCounts;
    }

    public void setDRCounts(Integer dRCounts) {
        this.dRCounts = dRCounts;
    }

    public java.util.ArrayList<DeliveryRequestDetail> getDeliveryRequestDetails() {
        return deliveryRequestDetails;
    }

    public void setDeliveryRequestDetails(java.util.ArrayList<DeliveryRequestDetail> deliveryRequestDetails) {
        this.deliveryRequestDetails = deliveryRequestDetails;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(String createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getIsAllDRsPickedUp() {
        return isAllDRsPickedUp;
    }

    public void setIsAllDRsPickedUp(String isAllDRsPickedUp) {
        this.isAllDRsPickedUp = isAllDRsPickedUp;
    }




}
