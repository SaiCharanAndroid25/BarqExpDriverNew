package mersattech.barqexpdriver.Models.s.HistoryPackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("CreatedDatetime")
    @Expose
    private String createdDatetime;
    @SerializedName("OrderStatus")
    @Expose
    private String orderStatus;
    @SerializedName("DRCounts")
    @Expose
    private Integer dRCounts;
    @SerializedName("deliveryRequestDetails")
    @Expose
    private java.util.List<DeliveryRequestDetail> deliveryRequestDetails = null;

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

    public Integer getDRCounts() {
        return dRCounts;
    }

    public void setDRCounts(Integer dRCounts) {
        this.dRCounts = dRCounts;
    }

    public java.util.List<DeliveryRequestDetail> getDeliveryRequestDetails() {
        return deliveryRequestDetails;
    }

    public void setDeliveryRequestDetails(java.util.List<DeliveryRequestDetail> deliveryRequestDetails) {
        this.deliveryRequestDetails = deliveryRequestDetails;
    }
}
