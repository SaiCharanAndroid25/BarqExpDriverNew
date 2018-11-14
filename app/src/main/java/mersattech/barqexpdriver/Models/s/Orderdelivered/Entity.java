
package mersattech.barqexpdriver.Models.s.Orderdelivered;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ShipmentName")
    @Expose
    private Object shipmentName;
    @SerializedName("ShipmentValue")
    @Expose
    private Object shipmentValue;
    @SerializedName("NumberofItems")
    @Expose
    private Object numberofItems;
    @SerializedName("DeliveryStatusID")
    @Expose
    private Object deliveryStatusID;
    @SerializedName("RequestCreatedDate")
    @Expose
    private Object requestCreatedDate;
    @SerializedName("ReceiverName")
    @Expose
    private Object receiverName;
    @SerializedName("ReceiverPhone")
    @Expose
    private Object receiverPhone;
    @SerializedName("ReceiverCountryID")
    @Expose
    private Object receiverCountryID;
    @SerializedName("ReceiverCityID")
    @Expose
    private Object receiverCityID;
    @SerializedName("ReceiverBlockID")
    @Expose
    private Object receiverBlockID;
    @SerializedName("RecordCreatedByUserID")
    @Expose
    private Object recordCreatedByUserID;
    @SerializedName("RequesterCompanyID")
    @Expose
    private Object requesterCompanyID;
    @SerializedName("AlternateReceiverName")
    @Expose
    private Object alternateReceiverName;
    @SerializedName("AlternateReceiverPhone")
    @Expose
    private Object alternateReceiverPhone;
    @SerializedName("ReceiverAddressLine2")
    @Expose
    private Object receiverAddressLine2;
    @SerializedName("ReceiverAddressLine1")
    @Expose
    private Object receiverAddressLine1;
    @SerializedName("PickupCountryID")
    @Expose
    private Object pickupCountryID;
    @SerializedName("PickupCityID")
    @Expose
    private Object pickupCityID;
    @SerializedName("PickupBlockID")
    @Expose
    private Object pickupBlockID;
    @SerializedName("PickupStreetName")
    @Expose
    private Object pickupStreetName;
    @SerializedName("PickupBuildingName")
    @Expose
    private Object pickupBuildingName;
    @SerializedName("DeliveryRequestTrackingNumber")
    @Expose
    private Object deliveryRequestTrackingNumber;
    @SerializedName("ReceiverLat")
    @Expose
    private Object receiverLat;
    @SerializedName("ReceiverLng")
    @Expose
    private Object receiverLng;
    @SerializedName("PickupLat")
    @Expose
    private Object pickupLat;
    @SerializedName("PickupLng")
    @Expose
    private Object pickupLng;
    @SerializedName("DeliveryTypeIndicater")
    @Expose
    private Object deliveryTypeIndicater;
    @SerializedName("ReceiverEmail")
    @Expose
    private Object receiverEmail;
    @SerializedName("PickupDate")
    @Expose
    private Object pickupDate;
    @SerializedName("TotalShipmentCost")
    @Expose
    private Object totalShipmentCost;
    @SerializedName("TotalShipmentVolume")
    @Expose
    private Object totalShipmentVolume;
    @SerializedName("CreatedYear")
    @Expose
    private Object createdYear;
    @SerializedName("CreatedMonth")
    @Expose
    private Object createdMonth;
    @SerializedName("CreatedDay")
    @Expose
    private Object createdDay;
    @SerializedName("RecordUpdatedByUserID")
    @Expose
    private Object recordUpdatedByUserID;
    @SerializedName("ShipmentContentTypeIndicator")
    @Expose
    private Object shipmentContentTypeIndicator;
    @SerializedName("ServiceTypeIndicater")
    @Expose
    private Object serviceTypeIndicater;
    @SerializedName("InternalStatusID")
    @Expose
    private Object internalStatusID;
    @SerializedName("SecurityLevelIndicator")
    @Expose
    private Object securityLevelIndicator;
    @SerializedName("GrossShipmentWeight")
    @Expose
    private Object grossShipmentWeight;
    @SerializedName("RequestUpdatedDate")
    @Expose
    private Object requestUpdatedDate;
    @SerializedName("IsShipmentCostPaidByReceiver")
    @Expose
    private Object isShipmentCostPaidByReceiver;
    @SerializedName("IsCOD")
    @Expose
    private Object isCOD;
    @SerializedName("CODValue")
    @Expose
    private Object cODValue;
    @SerializedName("AdditionalInstructions")
    @Expose
    private Object additionalInstructions;
    @SerializedName("DeliveryConfirmationOTP")
    @Expose
    private Object deliveryConfirmationOTP;
    @SerializedName("FailureDropActionIndicator")
    @Expose
    private Object failureDropActionIndicator;
    @SerializedName("ReceiverConfirmationOTP")
    @Expose
    private Object receiverConfirmationOTP;
    @SerializedName("FailureDropCountryID")
    @Expose
    private Integer failureDropCountryID;
    @SerializedName("FailureDropCityID")
    @Expose
    private Integer failureDropCityID;
    @SerializedName("FailureDropBlockID")
    @Expose
    private Integer failureDropBlockID;
    @SerializedName("FailureDropAddress")
    @Expose
    private Object failureDropAddress;
    @SerializedName("FailureDropLat")
    @Expose
    private Integer failureDropLat;
    @SerializedName("FailureDropLng")
    @Expose
    private Integer failureDropLng;
    @SerializedName("SenderName")
    @Expose
    private Object senderName;
    @SerializedName("SenderPhone")
    @Expose
    private Object senderPhone;
    @SerializedName("UserEntity")
    @Expose
    private Object userEntity;
    @SerializedName("countryentity")
    @Expose
    private Object countryentity;
    @SerializedName("cityentity")
    @Expose
    private Object cityentity;
    @SerializedName("blockentity")
    @Expose
    private Object blockentity;
    @SerializedName("ReciverCity")
    @Expose
    private Object reciverCity;
    @SerializedName("Reciverblock")
    @Expose
    private Object reciverblock;
    @SerializedName("PickupCountryName")
    @Expose
    private Object pickupCountryName;
    @SerializedName("PickupCityName")
    @Expose
    private Object pickupCityName;
    @SerializedName("PickupBlockName")
    @Expose
    private Object pickupBlockName;
    @SerializedName("DeliveryOrderID")
    @Expose
    private Object deliveryOrderID;
    @SerializedName("ReceiverCountryName")
    @Expose
    private Object receiverCountryName;
    @SerializedName("ReceiverCityName")
    @Expose
    private Object receiverCityName;
    @SerializedName("ReceiverBlockName")
    @Expose
    private Object receiverBlockName;
    @SerializedName("IsReceiverReceivedVerified")
    @Expose
    private Boolean isReceiverReceivedVerified;
    @SerializedName("StatusName")
    @Expose
    private Object statusName;
    @SerializedName("CompanyName")
    @Expose
    private Object companyName;
    @SerializedName("deliveryRequestItemEntity")
    @Expose
    private List<Object> deliveryRequestItemEntity = null;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Object getShipmentName() {
        return shipmentName;
    }

    public void setShipmentName(Object shipmentName) {
        this.shipmentName = shipmentName;
    }

    public Object getShipmentValue() {
        return shipmentValue;
    }

    public void setShipmentValue(Object shipmentValue) {
        this.shipmentValue = shipmentValue;
    }

    public Object getNumberofItems() {
        return numberofItems;
    }

    public void setNumberofItems(Object numberofItems) {
        this.numberofItems = numberofItems;
    }

    public Object getDeliveryStatusID() {
        return deliveryStatusID;
    }

    public void setDeliveryStatusID(Object deliveryStatusID) {
        this.deliveryStatusID = deliveryStatusID;
    }

    public Object getRequestCreatedDate() {
        return requestCreatedDate;
    }

    public void setRequestCreatedDate(Object requestCreatedDate) {
        this.requestCreatedDate = requestCreatedDate;
    }

    public Object getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(Object receiverName) {
        this.receiverName = receiverName;
    }

    public Object getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(Object receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Object getReceiverCountryID() {
        return receiverCountryID;
    }

    public void setReceiverCountryID(Object receiverCountryID) {
        this.receiverCountryID = receiverCountryID;
    }

    public Object getReceiverCityID() {
        return receiverCityID;
    }

    public void setReceiverCityID(Object receiverCityID) {
        this.receiverCityID = receiverCityID;
    }

    public Object getReceiverBlockID() {
        return receiverBlockID;
    }

    public void setReceiverBlockID(Object receiverBlockID) {
        this.receiverBlockID = receiverBlockID;
    }

    public Object getRecordCreatedByUserID() {
        return recordCreatedByUserID;
    }

    public void setRecordCreatedByUserID(Object recordCreatedByUserID) {
        this.recordCreatedByUserID = recordCreatedByUserID;
    }

    public Object getRequesterCompanyID() {
        return requesterCompanyID;
    }

    public void setRequesterCompanyID(Object requesterCompanyID) {
        this.requesterCompanyID = requesterCompanyID;
    }

    public Object getAlternateReceiverName() {
        return alternateReceiverName;
    }

    public void setAlternateReceiverName(Object alternateReceiverName) {
        this.alternateReceiverName = alternateReceiverName;
    }

    public Object getAlternateReceiverPhone() {
        return alternateReceiverPhone;
    }

    public void setAlternateReceiverPhone(Object alternateReceiverPhone) {
        this.alternateReceiverPhone = alternateReceiverPhone;
    }

    public Object getReceiverAddressLine2() {
        return receiverAddressLine2;
    }

    public void setReceiverAddressLine2(Object receiverAddressLine2) {
        this.receiverAddressLine2 = receiverAddressLine2;
    }

    public Object getReceiverAddressLine1() {
        return receiverAddressLine1;
    }

    public void setReceiverAddressLine1(Object receiverAddressLine1) {
        this.receiverAddressLine1 = receiverAddressLine1;
    }

    public Object getPickupCountryID() {
        return pickupCountryID;
    }

    public void setPickupCountryID(Object pickupCountryID) {
        this.pickupCountryID = pickupCountryID;
    }

    public Object getPickupCityID() {
        return pickupCityID;
    }

    public void setPickupCityID(Object pickupCityID) {
        this.pickupCityID = pickupCityID;
    }

    public Object getPickupBlockID() {
        return pickupBlockID;
    }

    public void setPickupBlockID(Object pickupBlockID) {
        this.pickupBlockID = pickupBlockID;
    }

    public Object getPickupStreetName() {
        return pickupStreetName;
    }

    public void setPickupStreetName(Object pickupStreetName) {
        this.pickupStreetName = pickupStreetName;
    }

    public Object getPickupBuildingName() {
        return pickupBuildingName;
    }

    public void setPickupBuildingName(Object pickupBuildingName) {
        this.pickupBuildingName = pickupBuildingName;
    }

    public Object getDeliveryRequestTrackingNumber() {
        return deliveryRequestTrackingNumber;
    }

    public void setDeliveryRequestTrackingNumber(Object deliveryRequestTrackingNumber) {
        this.deliveryRequestTrackingNumber = deliveryRequestTrackingNumber;
    }

    public Object getReceiverLat() {
        return receiverLat;
    }

    public void setReceiverLat(Object receiverLat) {
        this.receiverLat = receiverLat;
    }

    public Object getReceiverLng() {
        return receiverLng;
    }

    public void setReceiverLng(Object receiverLng) {
        this.receiverLng = receiverLng;
    }

    public Object getPickupLat() {
        return pickupLat;
    }

    public void setPickupLat(Object pickupLat) {
        this.pickupLat = pickupLat;
    }

    public Object getPickupLng() {
        return pickupLng;
    }

    public void setPickupLng(Object pickupLng) {
        this.pickupLng = pickupLng;
    }

    public Object getDeliveryTypeIndicater() {
        return deliveryTypeIndicater;
    }

    public void setDeliveryTypeIndicater(Object deliveryTypeIndicater) {
        this.deliveryTypeIndicater = deliveryTypeIndicater;
    }

    public Object getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(Object receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public Object getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Object pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Object getTotalShipmentCost() {
        return totalShipmentCost;
    }

    public void setTotalShipmentCost(Object totalShipmentCost) {
        this.totalShipmentCost = totalShipmentCost;
    }

    public Object getTotalShipmentVolume() {
        return totalShipmentVolume;
    }

    public void setTotalShipmentVolume(Object totalShipmentVolume) {
        this.totalShipmentVolume = totalShipmentVolume;
    }

    public Object getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(Object createdYear) {
        this.createdYear = createdYear;
    }

    public Object getCreatedMonth() {
        return createdMonth;
    }

    public void setCreatedMonth(Object createdMonth) {
        this.createdMonth = createdMonth;
    }

    public Object getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Object createdDay) {
        this.createdDay = createdDay;
    }

    public Object getRecordUpdatedByUserID() {
        return recordUpdatedByUserID;
    }

    public void setRecordUpdatedByUserID(Object recordUpdatedByUserID) {
        this.recordUpdatedByUserID = recordUpdatedByUserID;
    }

    public Object getShipmentContentTypeIndicator() {
        return shipmentContentTypeIndicator;
    }

    public void setShipmentContentTypeIndicator(Object shipmentContentTypeIndicator) {
        this.shipmentContentTypeIndicator = shipmentContentTypeIndicator;
    }

    public Object getServiceTypeIndicater() {
        return serviceTypeIndicater;
    }

    public void setServiceTypeIndicater(Object serviceTypeIndicater) {
        this.serviceTypeIndicater = serviceTypeIndicater;
    }

    public Object getInternalStatusID() {
        return internalStatusID;
    }

    public void setInternalStatusID(Object internalStatusID) {
        this.internalStatusID = internalStatusID;
    }

    public Object getSecurityLevelIndicator() {
        return securityLevelIndicator;
    }

    public void setSecurityLevelIndicator(Object securityLevelIndicator) {
        this.securityLevelIndicator = securityLevelIndicator;
    }

    public Object getGrossShipmentWeight() {
        return grossShipmentWeight;
    }

    public void setGrossShipmentWeight(Object grossShipmentWeight) {
        this.grossShipmentWeight = grossShipmentWeight;
    }

    public Object getRequestUpdatedDate() {
        return requestUpdatedDate;
    }

    public void setRequestUpdatedDate(Object requestUpdatedDate) {
        this.requestUpdatedDate = requestUpdatedDate;
    }

    public Object getIsShipmentCostPaidByReceiver() {
        return isShipmentCostPaidByReceiver;
    }

    public void setIsShipmentCostPaidByReceiver(Object isShipmentCostPaidByReceiver) {
        this.isShipmentCostPaidByReceiver = isShipmentCostPaidByReceiver;
    }

    public Object getIsCOD() {
        return isCOD;
    }

    public void setIsCOD(Object isCOD) {
        this.isCOD = isCOD;
    }

    public Object getCODValue() {
        return cODValue;
    }

    public void setCODValue(Object cODValue) {
        this.cODValue = cODValue;
    }

    public Object getAdditionalInstructions() {
        return additionalInstructions;
    }

    public void setAdditionalInstructions(Object additionalInstructions) {
        this.additionalInstructions = additionalInstructions;
    }

    public Object getDeliveryConfirmationOTP() {
        return deliveryConfirmationOTP;
    }

    public void setDeliveryConfirmationOTP(Object deliveryConfirmationOTP) {
        this.deliveryConfirmationOTP = deliveryConfirmationOTP;
    }

    public Object getFailureDropActionIndicator() {
        return failureDropActionIndicator;
    }

    public void setFailureDropActionIndicator(Object failureDropActionIndicator) {
        this.failureDropActionIndicator = failureDropActionIndicator;
    }

    public Object getReceiverConfirmationOTP() {
        return receiverConfirmationOTP;
    }

    public void setReceiverConfirmationOTP(Object receiverConfirmationOTP) {
        this.receiverConfirmationOTP = receiverConfirmationOTP;
    }

    public Integer getFailureDropCountryID() {
        return failureDropCountryID;
    }

    public void setFailureDropCountryID(Integer failureDropCountryID) {
        this.failureDropCountryID = failureDropCountryID;
    }

    public Integer getFailureDropCityID() {
        return failureDropCityID;
    }

    public void setFailureDropCityID(Integer failureDropCityID) {
        this.failureDropCityID = failureDropCityID;
    }

    public Integer getFailureDropBlockID() {
        return failureDropBlockID;
    }

    public void setFailureDropBlockID(Integer failureDropBlockID) {
        this.failureDropBlockID = failureDropBlockID;
    }

    public Object getFailureDropAddress() {
        return failureDropAddress;
    }

    public void setFailureDropAddress(Object failureDropAddress) {
        this.failureDropAddress = failureDropAddress;
    }

    public Integer getFailureDropLat() {
        return failureDropLat;
    }

    public void setFailureDropLat(Integer failureDropLat) {
        this.failureDropLat = failureDropLat;
    }

    public Integer getFailureDropLng() {
        return failureDropLng;
    }

    public void setFailureDropLng(Integer failureDropLng) {
        this.failureDropLng = failureDropLng;
    }

    public Object getSenderName() {
        return senderName;
    }

    public void setSenderName(Object senderName) {
        this.senderName = senderName;
    }

    public Object getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(Object senderPhone) {
        this.senderPhone = senderPhone;
    }

    public Object getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(Object userEntity) {
        this.userEntity = userEntity;
    }

    public Object getCountryentity() {
        return countryentity;
    }

    public void setCountryentity(Object countryentity) {
        this.countryentity = countryentity;
    }

    public Object getCityentity() {
        return cityentity;
    }

    public void setCityentity(Object cityentity) {
        this.cityentity = cityentity;
    }

    public Object getBlockentity() {
        return blockentity;
    }

    public void setBlockentity(Object blockentity) {
        this.blockentity = blockentity;
    }

    public Object getReciverCity() {
        return reciverCity;
    }

    public void setReciverCity(Object reciverCity) {
        this.reciverCity = reciverCity;
    }

    public Object getReciverblock() {
        return reciverblock;
    }

    public void setReciverblock(Object reciverblock) {
        this.reciverblock = reciverblock;
    }

    public Object getPickupCountryName() {
        return pickupCountryName;
    }

    public void setPickupCountryName(Object pickupCountryName) {
        this.pickupCountryName = pickupCountryName;
    }

    public Object getPickupCityName() {
        return pickupCityName;
    }

    public void setPickupCityName(Object pickupCityName) {
        this.pickupCityName = pickupCityName;
    }

    public Object getPickupBlockName() {
        return pickupBlockName;
    }

    public void setPickupBlockName(Object pickupBlockName) {
        this.pickupBlockName = pickupBlockName;
    }

    public Object getDeliveryOrderID() {
        return deliveryOrderID;
    }

    public void setDeliveryOrderID(Object deliveryOrderID) {
        this.deliveryOrderID = deliveryOrderID;
    }

    public Object getReceiverCountryName() {
        return receiverCountryName;
    }

    public void setReceiverCountryName(Object receiverCountryName) {
        this.receiverCountryName = receiverCountryName;
    }

    public Object getReceiverCityName() {
        return receiverCityName;
    }

    public void setReceiverCityName(Object receiverCityName) {
        this.receiverCityName = receiverCityName;
    }

    public Object getReceiverBlockName() {
        return receiverBlockName;
    }

    public void setReceiverBlockName(Object receiverBlockName) {
        this.receiverBlockName = receiverBlockName;
    }

    public Boolean getIsReceiverReceivedVerified() {
        return isReceiverReceivedVerified;
    }

    public void setIsReceiverReceivedVerified(Boolean isReceiverReceivedVerified) {
        this.isReceiverReceivedVerified = isReceiverReceivedVerified;
    }

    public Object getStatusName() {
        return statusName;
    }

    public void setStatusName(Object statusName) {
        this.statusName = statusName;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    public List<Object> getDeliveryRequestItemEntity() {
        return deliveryRequestItemEntity;
    }

    public void setDeliveryRequestItemEntity(List<Object> deliveryRequestItemEntity) {
        this.deliveryRequestItemEntity = deliveryRequestItemEntity;
    }

}
