package mersattech.barqexpdriver.Models.s.HistoryPackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryRequestDetail {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("PickupDate")
    @Expose
    private String pickupDate;
    @SerializedName("SenderAddress")
    @Expose
    private SenderAddress senderAddress;
    @SerializedName("RecieverDetails")
    @Expose
    private RecieverDetails recieverDetails;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
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
}
