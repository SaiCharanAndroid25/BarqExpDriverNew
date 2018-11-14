
package mersattech.barqexpdriver.Models.s.OrdersList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DeliveryRequestEntity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ShipmentName")
    @Expose
    private String shipmentName;
    @SerializedName("ShipmentValue")
    @Expose
    private double shipmentValue;
    @SerializedName("NumberofItems")
    @Expose
    private Integer numberofItems;
    @SerializedName("DeliveryStatusID")
    @Expose
    private Integer deliveryStatusID;
    @SerializedName("RequestCreatedDate")
    @Expose
    private String requestCreatedDate;
    @SerializedName("ReceiverName")
    @Expose
    private String receiverName;
    @SerializedName("ReceiverPhone")
    @Expose
    private String receiverPhone;
    @SerializedName("RecordCreatedByUserID")
    @Expose
    private Integer recordCreatedByUserID;
    @SerializedName("RequesterCompanyName")
    @Expose
    private String requesterCompanyName;
    @SerializedName("AlternateReceiverName")
    @Expose
    private String alternateReceiverName;
    @SerializedName("AlternateReceiverPhone")
    @Expose
    private String alternateReceiverPhone;
    @SerializedName("ReceiverAddressLine2")
    @Expose
    private String receiverAddressLine2;
    @SerializedName("ReceiverAddressLine1")
    @Expose
    private String receiverAddressLine1;
    @SerializedName("PickupStreetName")
    @Expose
    private String pickupStreetName;
    @SerializedName("PickupBuildingName")
    @Expose
    private String pickupBuildingName;
    @SerializedName("DeliveryRequestTrackingNumber")
    @Expose
    private String deliveryRequestTrackingNumber;
    @SerializedName("ReceiverLat")
    @Expose
    private Double receiverLat;
    @SerializedName("ReceiverLng")
    @Expose
    private Double receiverLng;
    @SerializedName("PickupLat")
    @Expose
    private Double pickupLat;
    @SerializedName("PickupLng")
    @Expose
    private Double pickupLng;
    @SerializedName("DeliveryTypeIndicater")
    @Expose
    private Integer deliveryTypeIndicater;
    @SerializedName("ReceiverEmail")
    @Expose
    private String receiverEmail;
    @SerializedName("PickupDate")
    @Expose
    private String pickupDate;
    @SerializedName("TotalShipmentCost")
    @Expose
    private double totalShipmentCost;
    @SerializedName("TotalShipmentVolume")
    @Expose
    private double totalShipmentVolume;
    @SerializedName("RecordUpdatedByUserID")
    @Expose
    private Integer recordUpdatedByUserID;
    @SerializedName("ShipmentContentTypeIndicator")
    @Expose
    private Integer shipmentContentTypeIndicator;
    @SerializedName("ServiceTypeIndicater")
    @Expose
    private Integer serviceTypeIndicater;
    @SerializedName("InternalStatusID")
    @Expose
    private Integer internalStatusID;
    @SerializedName("SecurityLevelIndicator")
    @Expose
    private Integer securityLevelIndicator;
    @SerializedName("GrossShipmentWeight")
    @Expose
    private double grossShipmentWeight;
    @SerializedName("RequestUpdatedDate")
    @Expose
    private String requestUpdatedDate;
    @SerializedName("IsShipmentCostPaidByReceiver")
    @Expose
    private Boolean isShipmentCostPaidByReceiver;
    @SerializedName("IsCOD")
    @Expose
    private Boolean isCOD;
    @SerializedName("CODValue")
    @Expose
    private Integer cODValue;
    @SerializedName("AdditionalInstructions")
    @Expose
    private String additionalInstructions;
    @SerializedName("DeliveryConfirmationOTP")
    @Expose
    private String deliveryConfirmationOTP;
    @SerializedName("FailureDropActionIndicator")
    @Expose
    private Integer failureDropActionIndicator;
    @SerializedName("ReceiverConfirmationOTP")
    @Expose
    private String receiverConfirmationOTP;
    @SerializedName("FailureDropCountryName")
    @Expose
    private String failureDropCountryName;
    @SerializedName("FailureDropCityName")
    @Expose
    private String failureDropCityName;
    @SerializedName("FailureDropBlockName")
    @Expose
    private String failureDropBlockName;
    @SerializedName("FailureDropAddress")
    @Expose
    private String failureDropAddress;
    @SerializedName("FailureDropLat")
    @Expose
    private Double failureDropLat;
    @SerializedName("FailureDropLng")
    @Expose
    private Double failureDropLng;
    @SerializedName("SenderName")
    @Expose
    private String senderName;
    @SerializedName("SenderPhone")
    @Expose
    private String senderPhone;
    @SerializedName("PickupCountryName")
    @Expose
    private String pickupCountryName;
    @SerializedName("PickupCityName")
    @Expose
    private String pickupCityName;
    @SerializedName("PickupBlockName")
    @Expose
    private String pickupBlockName;
    @SerializedName("ReceiverCountryName")
    @Expose
    private String receiverCountryName;
    @SerializedName("ReceiverCityName")
    @Expose
    private String receiverCityName;
    @SerializedName("ReceiverBlockName")
    @Expose
    private String receiverBlockName;
    @SerializedName("ShipmentCategoryType")
    @Expose
    private String shipmentCategoryType;
    @SerializedName("IsFinalDestination")
    @Expose
    private boolean isFinalDestination;
    @SerializedName("TripType")
    @Expose
    private String tripType;
    @SerializedName("FinalShippingCost")
    @Expose
    private Integer finalShippingCost;
    @SerializedName("CODCommissionFee")
    @Expose
    private Integer codcomissionfee;

    @SerializedName("deliveryRequestItemEntity")
    @Expose
    private ArrayList<DeliveryRequestItemEntity> deliveryRequestItemEntity = null;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getShipmentName() {
        return shipmentName;
    }

    public void setShipmentName(String shipmentName) {
        this.shipmentName = shipmentName;
    }

    public double getShipmentValue() {
        return shipmentValue;
    }

    public void setShipmentValue(double shipmentValue) {
        this.shipmentValue = shipmentValue;
    }

    public Integer getNumberofItems() {
        return numberofItems;
    }

    public void setNumberofItems(Integer numberofItems) {
        this.numberofItems = numberofItems;
    }

    public Integer getDeliveryStatusID() {
        return deliveryStatusID;
    }

    public void setDeliveryStatusID(Integer deliveryStatusID) {
        this.deliveryStatusID = deliveryStatusID;
    }

    public String getRequestCreatedDate() {
        return requestCreatedDate;
    }

    public void setRequestCreatedDate(String requestCreatedDate) {
        this.requestCreatedDate = requestCreatedDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Integer getRecordCreatedByUserID() {
        return recordCreatedByUserID;
    }

    public void setRecordCreatedByUserID(Integer recordCreatedByUserID) {
        this.recordCreatedByUserID = recordCreatedByUserID;
    }

    public String getRequesterCompanyName() {
        return requesterCompanyName;
    }

    public void setRequesterCompanyName(String requesterCompanyName) {
        this.requesterCompanyName = requesterCompanyName;
    }

    public String getAlternateReceiverName() {
        return alternateReceiverName;
    }

    public void setAlternateReceiverName(String alternateReceiverName) {
        this.alternateReceiverName = alternateReceiverName;
    }

    public String getAlternateReceiverPhone() {
        return alternateReceiverPhone;
    }

    public void setAlternateReceiverPhone(String alternateReceiverPhone) {
        this.alternateReceiverPhone = alternateReceiverPhone;
    }

    public String getReceiverAddressLine2() {
        return receiverAddressLine2;
    }

    public void setReceiverAddressLine2(String receiverAddressLine2) {
        this.receiverAddressLine2 = receiverAddressLine2;
    }

    public String getReceiverAddressLine1() {
        return receiverAddressLine1;
    }

    public void setReceiverAddressLine1(String receiverAddressLine1) {
        this.receiverAddressLine1 = receiverAddressLine1;
    }

    public String getPickupStreetName() {
        return pickupStreetName;
    }

    public void setPickupStreetName(String pickupStreetName) {
        this.pickupStreetName = pickupStreetName;
    }

    public String getPickupBuildingName() {
        return pickupBuildingName;
    }

    public void setPickupBuildingName(String pickupBuildingName) {
        this.pickupBuildingName = pickupBuildingName;
    }

    public String getDeliveryRequestTrackingNumber() {
        return deliveryRequestTrackingNumber;
    }

    public void setDeliveryRequestTrackingNumber(String deliveryRequestTrackingNumber) {
        this.deliveryRequestTrackingNumber = deliveryRequestTrackingNumber;
    }

    public Double getReceiverLat() {
        return receiverLat;
    }

    public void setReceiverLat(Double receiverLat) {
        this.receiverLat = receiverLat;
    }

    public Double getReceiverLng() {
        return receiverLng;
    }

    public void setReceiverLng(Double receiverLng) {
        this.receiverLng = receiverLng;
    }

    public Double getPickupLat() {
        return pickupLat;
    }

    public void setPickupLat(Double pickupLat) {
        this.pickupLat = pickupLat;
    }

    public Double getPickupLng() {
        return pickupLng;
    }

    public void setPickupLng(Double pickupLng) {
        this.pickupLng = pickupLng;
    }

    public Integer getDeliveryTypeIndicater() {
        return deliveryTypeIndicater;
    }

    public void setDeliveryTypeIndicater(Integer deliveryTypeIndicater) {
        this.deliveryTypeIndicater = deliveryTypeIndicater;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public double getTotalShipmentCost() {
        return totalShipmentCost;
    }

    public void setTotalShipmentCost(double totalShipmentCost) {
        this.totalShipmentCost = totalShipmentCost;
    }

    public double getTotalShipmentVolume() {
        return totalShipmentVolume;
    }

    public void setTotalShipmentVolume(double totalShipmentVolume) {
        this.totalShipmentVolume = totalShipmentVolume;
    }

    public Integer getRecordUpdatedByUserID() {
        return recordUpdatedByUserID;
    }

    public void setRecordUpdatedByUserID(Integer recordUpdatedByUserID) {
        this.recordUpdatedByUserID = recordUpdatedByUserID;
    }

    public Integer getShipmentContentTypeIndicator() {
        return shipmentContentTypeIndicator;
    }

    public void setShipmentContentTypeIndicator(Integer shipmentContentTypeIndicator) {
        this.shipmentContentTypeIndicator = shipmentContentTypeIndicator;
    }

    public Integer getServiceTypeIndicater() {
        return serviceTypeIndicater;
    }

    public void setServiceTypeIndicater(Integer serviceTypeIndicater) {
        this.serviceTypeIndicater = serviceTypeIndicater;
    }

    public Integer getInternalStatusID() {
        return internalStatusID;
    }

    public void setInternalStatusID(Integer internalStatusID) {
        this.internalStatusID = internalStatusID;
    }

    public Integer getSecurityLevelIndicator() {
        return securityLevelIndicator;
    }

    public void setSecurityLevelIndicator(Integer securityLevelIndicator) {
        this.securityLevelIndicator = securityLevelIndicator;
    }

    public double getGrossShipmentWeight() {
        return grossShipmentWeight;
    }

    public void setGrossShipmentWeight(double grossShipmentWeight) {
        this.grossShipmentWeight = grossShipmentWeight;
    }

    public String getRequestUpdatedDate() {
        return requestUpdatedDate;
    }

    public void setRequestUpdatedDate(String requestUpdatedDate) {
        this.requestUpdatedDate = requestUpdatedDate;
    }

    public Boolean getIsShipmentCostPaidByReceiver() {
        return isShipmentCostPaidByReceiver;
    }

    public void setIsShipmentCostPaidByReceiver(Boolean isShipmentCostPaidByReceiver) {
        this.isShipmentCostPaidByReceiver = isShipmentCostPaidByReceiver;
    }

    public Boolean getIsCOD() {
        return isCOD;
    }

    public void setIsCOD(Boolean isCOD) {
        this.isCOD = isCOD;
    }

    public Integer getCODValue() {
        return cODValue;
    }


    public void setCODValue(Integer cODValue) {
        this.cODValue = cODValue;
    }

    public String getAdditionalInstructions() {
        return additionalInstructions;
    }

    public void setAdditionalInstructions(String additionalInstructions) {
        this.additionalInstructions = additionalInstructions;
    }

    public String getDeliveryConfirmationOTP() {
        return deliveryConfirmationOTP;
    }

    public void setDeliveryConfirmationOTP(String deliveryConfirmationOTP) {
        this.deliveryConfirmationOTP = deliveryConfirmationOTP;
    }

    public Integer getFailureDropActionIndicator() {
        return failureDropActionIndicator;
    }

    public void setFailureDropActionIndicator(Integer failureDropActionIndicator) {
        this.failureDropActionIndicator = failureDropActionIndicator;
    }

    public String getReceiverConfirmationOTP() {
        return receiverConfirmationOTP;
    }

    public void setReceiverConfirmationOTP(String receiverConfirmationOTP) {
        this.receiverConfirmationOTP = receiverConfirmationOTP;
    }

    public String getFailureDropCountryName() {
        return failureDropCountryName;
    }

    public void setFailureDropCountryName(String failureDropCountryName) {
        this.failureDropCountryName = failureDropCountryName;
    }

    public String getFailureDropCityName() {
        return failureDropCityName;
    }

    public void setFailureDropCityName(String failureDropCityName) {
        this.failureDropCityName = failureDropCityName;
    }

    public String getFailureDropBlockName() {
        return failureDropBlockName;
    }

    public void setFailureDropBlockName(String failureDropBlockName) {
        this.failureDropBlockName = failureDropBlockName;
    }

    public String getFailureDropAddress() {
        return failureDropAddress;
    }

    public void setFailureDropAddress(String failureDropAddress) {
        this.failureDropAddress = failureDropAddress;
    }

    public Double getFailureDropLat() {
        return failureDropLat;
    }

    public void setFailureDropLat(Double failureDropLat) {
        this.failureDropLat = failureDropLat;
    }

    public Double getFailureDropLng() {
        return failureDropLng;
    }

    public void setFailureDropLng(Double failureDropLng) {
        this.failureDropLng = failureDropLng;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getPickupCountryName() {
        return pickupCountryName;
    }

    public void setPickupCountryName(String pickupCountryName) {
        this.pickupCountryName = pickupCountryName;
    }

    public String getPickupCityName() {
        return pickupCityName;
    }

    public void setPickupCityName(String pickupCityName) {
        this.pickupCityName = pickupCityName;
    }

    public String getPickupBlockName() {
        return pickupBlockName;
    }

    public void setPickupBlockName(String pickupBlockName) {
        this.pickupBlockName = pickupBlockName;
    }

    public String getReceiverCountryName() {
        return receiverCountryName;
    }

    public void setReceiverCountryName(String receiverCountryName) {
        this.receiverCountryName = receiverCountryName;
    }

    public String getReceiverCityName() {
        return receiverCityName;
    }

    public void setReceiverCityName(String receiverCityName) {
        this.receiverCityName = receiverCityName;
    }

    public String getReceiverBlockName() {
        return receiverBlockName;
    }

    public void setReceiverBlockName(String receiverBlockName) {
        this.receiverBlockName = receiverBlockName;
    }

    public ArrayList<DeliveryRequestItemEntity> getDeliveryRequestItemEntity() {
        return deliveryRequestItemEntity;
    }

    public void setDeliveryRequestItemEntity(ArrayList<DeliveryRequestItemEntity> deliveryRequestItemEntity) {
        this.deliveryRequestItemEntity = deliveryRequestItemEntity;
    }

    public String getShipmentCategoryType() {
        return shipmentCategoryType;
    }

    public void setShipmentCategoryType(String shipmentCategoryType) {
        this.shipmentCategoryType = shipmentCategoryType;
    }

    public boolean getIsFinalDestination() {
        return isFinalDestination;
    }

    public void setIsFinalDestination(boolean isFinalDestination) {
        this.isFinalDestination = isFinalDestination;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public Integer getFinalShippingCost() {
        return finalShippingCost;
    }

    public void setFinalShippingCost(Integer finalShippingCost) {
        this.finalShippingCost = finalShippingCost;
    }
    public Integer getCodcomissionfee() {
        return codcomissionfee;
    }

    public void setCodcomissionfee(Integer codcomissionfee) {
        this.codcomissionfee = codcomissionfee;
    }


}
