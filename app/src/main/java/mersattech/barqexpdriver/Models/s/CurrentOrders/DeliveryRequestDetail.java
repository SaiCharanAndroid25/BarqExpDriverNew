package mersattech.barqexpdriver.Models.s.CurrentOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeliveryRequestDetail {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("DRTrackingNumber")
    @Expose
    private String dRTrackingNumber;
    @SerializedName("CompanyName")
    @Expose
    private Object companyName;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("PickupDate")
    @Expose
    private String pickupDate;
    @SerializedName("FinalShippingCost")
    @Expose
    private Integer finalShippingCost;
    @SerializedName("CODAmount")
    @Expose
    private Integer cODAmount;
    @SerializedName("InvertoryStatus")
    @Expose
    private Integer invertoryStatus;
    @SerializedName("IsDelivered")
    @Expose
    private Boolean isDelivered;
    @SerializedName("DeliveryStatusID")
    @Expose
    private Integer deliveryStatusID;
    @SerializedName("CheckOutStatus")
    @Expose
    private Integer CheckOutStatus;
    @SerializedName("SenderAddress")
    @Expose
    private SenderAddress senderAddress;
    @SerializedName("RecieverDetails")
    @Expose
    private RecieverDetails recieverDetails;
    @SerializedName("deliveryRequestItem")
    @Expose
    private java.util.ArrayList<DeliveryRequestItem> deliveryRequestItem = null;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getDRTrackingNumber() {
        return dRTrackingNumber;
    }

    public void setDRTrackingNumber(String dRTrackingNumber) {
        this.dRTrackingNumber = dRTrackingNumber;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Integer getFinalShippingCost() {
        return finalShippingCost;
    }

    public void setFinalShippingCost(Integer finalShippingCost) {
        this.finalShippingCost = finalShippingCost;
    }

    public Integer getCODAmount() {
        return cODAmount;
    }

    public void setCODAmount(Integer cODAmount) {
        this.cODAmount = cODAmount;
    }

    public Integer getInvertoryStatus() {
        return invertoryStatus;
    }

    public void setInvertoryStatus(Integer invertoryStatus) {
        this.invertoryStatus = invertoryStatus;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public Integer getDeliveryStatusID() {
        return deliveryStatusID;
    }

    public void setDeliveryStatusID(Integer deliveryStatusID) {
        this.deliveryStatusID = deliveryStatusID;
    }

    public Integer getCheckOutStatus() {
        return CheckOutStatus;
    }

    public void setCheckOutStatus(Integer CheckOutStatus) {
        this.CheckOutStatus = CheckOutStatus;
    }

    public SenderAddress getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(SenderAddress senderAddress) {
        this.senderAddress = senderAddress;
    }

    public RecieverDetails getRecieverDetails() {
        return recieverDetails;
    }

    public void setRecieverDetails(RecieverDetails recieverDetails) {
        this.recieverDetails = recieverDetails;
    }

    public java.util.ArrayList<DeliveryRequestItem> getDeliveryRequestItem() {
        return deliveryRequestItem;
    }

    public void setDeliveryRequestItem(java.util.ArrayList<DeliveryRequestItem> deliveryRequestItem) {
        this.deliveryRequestItem = deliveryRequestItem;
    }
}
