package mersattech.barqexpdriver.Models.s.Checkedout;

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
    @SerializedName("StatusText")
    @Expose
    private Object statusText;
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
    @SerializedName("ReceivedCODValue")
    @Expose
    private Object receivedCODValue;
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
    @SerializedName("Pickupcountryentity")
    @Expose
    private Object pickupcountryentity;
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
    @SerializedName("CompanyEntity")
    @Expose
    private Object companyEntity;
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
    @SerializedName("BulkDRStatus")
    @Expose
    private Object bulkDRStatus;
    @SerializedName("StatusArabicName")
    @Expose
    private Object statusArabicName;
    @SerializedName("CompanyName")
    @Expose
    private Object companyName;
    @SerializedName("RejectReasonText")
    @Expose
    private Object rejectReasonText;
    @SerializedName("CancelReasonText")
    @Expose
    private Object cancelReasonText;
    @SerializedName("CancelReasonID")
    @Expose
    private Object cancelReasonID;
    @SerializedName("DeliveryTypeName")
    @Expose
    private Object deliveryTypeName;
    @SerializedName("ShipmentContentTypeName")
    @Expose
    private Object shipmentContentTypeName;
    @SerializedName("ServiceTypeName")
    @Expose
    private Object serviceTypeName;
    @SerializedName("SecurityLevelName")
    @Expose
    private Object securityLevelName;
    @SerializedName("FailureDropActionName")
    @Expose
    private Object failureDropActionName;
    @SerializedName("ShipementCaluculationIsSuccess")
    @Expose
    private Boolean shipementCaluculationIsSuccess;
    @SerializedName("ShipementCaluculationFailureMessage")
    @Expose
    private Object shipementCaluculationFailureMessage;
    @SerializedName("ShipmentCategoryType")
    @Expose
    private Object shipmentCategoryType;
    @SerializedName("Notes")
    @Expose
    private Object notes;
    @SerializedName("ShipmentType")
    @Expose
    private Object shipmentType;
    @SerializedName("WareHouseID")
    @Expose
    private Object wareHouseID;
    @SerializedName("TripStatusID")
    @Expose
    private Object tripStatusID;
    @SerializedName("PickupCityIDS")
    @Expose
    private Object pickupCityIDS;
    @SerializedName("ReceiverCityIDS")
    @Expose
    private Object receiverCityIDS;
    @SerializedName("RAddressID")
    @Expose
    private Object rAddressID;
    @SerializedName("deliveryRequestItem")
    @Expose
    private Object deliveryRequestItem;
    @SerializedName("deliveryRequestItemEntity")
    @Expose
    private List<Object> deliveryRequestItemEntity = null;
    @SerializedName("deliveryRequestTaxesEntity")
    @Expose
    private Object deliveryRequestTaxesEntity;
    @SerializedName("ServiceType")
    @Expose
    private Object serviceType;
    @SerializedName("SecurityLevel")
    @Expose
    private Object securityLevel;
    @SerializedName("FailureCityName")
    @Expose
    private Object failureCityName;
    @SerializedName("FailureCountryName")
    @Expose
    private Object failureCountryName;
    @SerializedName("FailureBlockName")
    @Expose
    private Object failureBlockName;
    @SerializedName("FailureDropAction")
    @Expose
    private Object failureDropAction;
    @SerializedName("ShipmentContentName")
    @Expose
    private Object shipmentContentName;
    @SerializedName("Status")
    @Expose
    private Object status;
    @SerializedName("PickUpCountryCode")
    @Expose
    private Object pickUpCountryCode;
    @SerializedName("RecieverCountryCode")
    @Expose
    private Object recieverCountryCode;
    @SerializedName("CODCommissionFee")
    @Expose
    private Integer cODCommissionFee;
    @SerializedName("Comments")
    @Expose
    private Object comments;
    @SerializedName("ExternalStatusID")
    @Expose
    private Integer externalStatusID;
    @SerializedName("IsFinalDestination")
    @Expose
    private Object isFinalDestination;
    @SerializedName("TripType")
    @Expose
    private Object tripType;
    @SerializedName("Txn_Source")
    @Expose
    private Object txnSource;
    @SerializedName("WarehouseVal")
    @Expose
    private Object warehouseVal;
    @SerializedName("isautoupdateexternalstatus")
    @Expose
    private Boolean isautoupdateexternalstatus;
    @SerializedName("ShipmentCostIsModified")
    @Expose
    private Boolean shipmentCostIsModified;
    @SerializedName("ShipmentCostModifiedUserID")
    @Expose
    private Integer shipmentCostModifiedUserID;
    @SerializedName("ShipmentCostModifiedDatetime")
    @Expose
    private String shipmentCostModifiedDatetime;
    @SerializedName("GrandTotalShipmentCost")
    @Expose
    private Integer grandTotalShipmentCost;
    @SerializedName("isOverrideShipmentCost")
    @Expose
    private Boolean isOverrideShipmentCost;
    @SerializedName("IsDeliver")
    @Expose
    private Boolean isDeliver;
    @SerializedName("PaymentStatus")
    @Expose
    private Object paymentStatus;
    @SerializedName("PaymentStatusID")
    @Expose
    private Integer paymentStatusID;
    @SerializedName("Discount")
    @Expose
    private Integer discount;
    @SerializedName("FinalShippingCost")
    @Expose
    private Integer finalShippingCost;
    @SerializedName("InvoiceAmount")
    @Expose
    private Integer invoiceAmount;
    @SerializedName("ISCourierCompany")
    @Expose
    private Object iSCourierCompany;
    @SerializedName("CourierTrackingNo")
    @Expose
    private Object courierTrackingNo;
    @SerializedName("NotReadyForInvoicing")
    @Expose
    private Boolean notReadyForInvoicing;
    @SerializedName("ClientReferenceNumber")
    @Expose
    private Object clientReferenceNumber;
    @SerializedName("CODCommissionFeeWithoutDiscount")
    @Expose
    private Integer cODCommissionFeeWithoutDiscount;
    @SerializedName("IsAssigned")
    @Expose
    private Boolean isAssigned;
    @SerializedName("IsApiIntegration")
    @Expose
    private Boolean isApiIntegration;
    @SerializedName("CourierCompanyTrackingNo")
    @Expose
    private Object courierCompanyTrackingNo;
    @SerializedName("CourierCompanyName")
    @Expose
    private Object courierCompanyName;
    @SerializedName("CODPayType")
    @Expose
    private Object cODPayType;
    @SerializedName("DRInventoryStatusID")
    @Expose
    private Integer dRInventoryStatusID;
    @SerializedName("DRInventoryStatus")
    @Expose
    private Object dRInventoryStatus;
    @SerializedName("CheckinNotes")
    @Expose
    private Object checkinNotes;
    @SerializedName("FullfilmentUnitsIDs")
    @Expose
    private Object fullfilmentUnitsIDs;
    @SerializedName("IsItemsInventoryBased")
    @Expose
    private Integer isItemsInventoryBased;
    @SerializedName("DeliveryRequestExternalStatusTracking")
    @Expose
    private Object deliveryRequestExternalStatusTracking;
    @SerializedName("ShipmentTracking")
    @Expose
    private Object shipmentTracking;

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

    public Object getStatusText() {
        return statusText;
    }

    public void setStatusText(Object statusText) {
        this.statusText = statusText;
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

    public Object getReceivedCODValue() {
        return receivedCODValue;
    }

    public void setReceivedCODValue(Object receivedCODValue) {
        this.receivedCODValue = receivedCODValue;
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

    public Object getPickupcountryentity() {
        return pickupcountryentity;
    }

    public void setPickupcountryentity(Object pickupcountryentity) {
        this.pickupcountryentity = pickupcountryentity;
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

    public Object getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(Object companyEntity) {
        this.companyEntity = companyEntity;
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

    public Object getBulkDRStatus() {
        return bulkDRStatus;
    }

    public void setBulkDRStatus(Object bulkDRStatus) {
        this.bulkDRStatus = bulkDRStatus;
    }

    public Object getStatusArabicName() {
        return statusArabicName;
    }

    public void setStatusArabicName(Object statusArabicName) {
        this.statusArabicName = statusArabicName;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    public Object getRejectReasonText() {
        return rejectReasonText;
    }

    public void setRejectReasonText(Object rejectReasonText) {
        this.rejectReasonText = rejectReasonText;
    }

    public Object getCancelReasonText() {
        return cancelReasonText;
    }

    public void setCancelReasonText(Object cancelReasonText) {
        this.cancelReasonText = cancelReasonText;
    }

    public Object getCancelReasonID() {
        return cancelReasonID;
    }

    public void setCancelReasonID(Object cancelReasonID) {
        this.cancelReasonID = cancelReasonID;
    }

    public Object getDeliveryTypeName() {
        return deliveryTypeName;
    }

    public void setDeliveryTypeName(Object deliveryTypeName) {
        this.deliveryTypeName = deliveryTypeName;
    }

    public Object getShipmentContentTypeName() {
        return shipmentContentTypeName;
    }

    public void setShipmentContentTypeName(Object shipmentContentTypeName) {
        this.shipmentContentTypeName = shipmentContentTypeName;
    }

    public Object getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(Object serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Object getSecurityLevelName() {
        return securityLevelName;
    }

    public void setSecurityLevelName(Object securityLevelName) {
        this.securityLevelName = securityLevelName;
    }

    public Object getFailureDropActionName() {
        return failureDropActionName;
    }

    public void setFailureDropActionName(Object failureDropActionName) {
        this.failureDropActionName = failureDropActionName;
    }

    public Boolean getShipementCaluculationIsSuccess() {
        return shipementCaluculationIsSuccess;
    }

    public void setShipementCaluculationIsSuccess(Boolean shipementCaluculationIsSuccess) {
        this.shipementCaluculationIsSuccess = shipementCaluculationIsSuccess;
    }

    public Object getShipementCaluculationFailureMessage() {
        return shipementCaluculationFailureMessage;
    }

    public void setShipementCaluculationFailureMessage(Object shipementCaluculationFailureMessage) {
        this.shipementCaluculationFailureMessage = shipementCaluculationFailureMessage;
    }

    public Object getShipmentCategoryType() {
        return shipmentCategoryType;
    }

    public void setShipmentCategoryType(Object shipmentCategoryType) {
        this.shipmentCategoryType = shipmentCategoryType;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Object getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(Object shipmentType) {
        this.shipmentType = shipmentType;
    }

    public Object getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(Object wareHouseID) {
        this.wareHouseID = wareHouseID;
    }

    public Object getTripStatusID() {
        return tripStatusID;
    }

    public void setTripStatusID(Object tripStatusID) {
        this.tripStatusID = tripStatusID;
    }

    public Object getPickupCityIDS() {
        return pickupCityIDS;
    }

    public void setPickupCityIDS(Object pickupCityIDS) {
        this.pickupCityIDS = pickupCityIDS;
    }

    public Object getReceiverCityIDS() {
        return receiverCityIDS;
    }

    public void setReceiverCityIDS(Object receiverCityIDS) {
        this.receiverCityIDS = receiverCityIDS;
    }

    public Object getRAddressID() {
        return rAddressID;
    }

    public void setRAddressID(Object rAddressID) {
        this.rAddressID = rAddressID;
    }

    public Object getDeliveryRequestItem() {
        return deliveryRequestItem;
    }

    public void setDeliveryRequestItem(Object deliveryRequestItem) {
        this.deliveryRequestItem = deliveryRequestItem;
    }

    public List<Object> getDeliveryRequestItemEntity() {
        return deliveryRequestItemEntity;
    }

    public void setDeliveryRequestItemEntity(List<Object> deliveryRequestItemEntity) {
        this.deliveryRequestItemEntity = deliveryRequestItemEntity;
    }

    public Object getDeliveryRequestTaxesEntity() {
        return deliveryRequestTaxesEntity;
    }

    public void setDeliveryRequestTaxesEntity(Object deliveryRequestTaxesEntity) {
        this.deliveryRequestTaxesEntity = deliveryRequestTaxesEntity;
    }

    public Object getServiceType() {
        return serviceType;
    }

    public void setServiceType(Object serviceType) {
        this.serviceType = serviceType;
    }

    public Object getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Object securityLevel) {
        this.securityLevel = securityLevel;
    }

    public Object getFailureCityName() {
        return failureCityName;
    }

    public void setFailureCityName(Object failureCityName) {
        this.failureCityName = failureCityName;
    }

    public Object getFailureCountryName() {
        return failureCountryName;
    }

    public void setFailureCountryName(Object failureCountryName) {
        this.failureCountryName = failureCountryName;
    }

    public Object getFailureBlockName() {
        return failureBlockName;
    }

    public void setFailureBlockName(Object failureBlockName) {
        this.failureBlockName = failureBlockName;
    }

    public Object getFailureDropAction() {
        return failureDropAction;
    }

    public void setFailureDropAction(Object failureDropAction) {
        this.failureDropAction = failureDropAction;
    }

    public Object getShipmentContentName() {
        return shipmentContentName;
    }

    public void setShipmentContentName(Object shipmentContentName) {
        this.shipmentContentName = shipmentContentName;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getPickUpCountryCode() {
        return pickUpCountryCode;
    }

    public void setPickUpCountryCode(Object pickUpCountryCode) {
        this.pickUpCountryCode = pickUpCountryCode;
    }

    public Object getRecieverCountryCode() {
        return recieverCountryCode;
    }

    public void setRecieverCountryCode(Object recieverCountryCode) {
        this.recieverCountryCode = recieverCountryCode;
    }

    public Integer getCODCommissionFee() {
        return cODCommissionFee;
    }

    public void setCODCommissionFee(Integer cODCommissionFee) {
        this.cODCommissionFee = cODCommissionFee;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public Integer getExternalStatusID() {
        return externalStatusID;
    }

    public void setExternalStatusID(Integer externalStatusID) {
        this.externalStatusID = externalStatusID;
    }

    public Object getIsFinalDestination() {
        return isFinalDestination;
    }

    public void setIsFinalDestination(Object isFinalDestination) {
        this.isFinalDestination = isFinalDestination;
    }

    public Object getTripType() {
        return tripType;
    }

    public void setTripType(Object tripType) {
        this.tripType = tripType;
    }

    public Object getTxnSource() {
        return txnSource;
    }

    public void setTxnSource(Object txnSource) {
        this.txnSource = txnSource;
    }

    public Object getWarehouseVal() {
        return warehouseVal;
    }

    public void setWarehouseVal(Object warehouseVal) {
        this.warehouseVal = warehouseVal;
    }

    public Boolean getIsautoupdateexternalstatus() {
        return isautoupdateexternalstatus;
    }

    public void setIsautoupdateexternalstatus(Boolean isautoupdateexternalstatus) {
        this.isautoupdateexternalstatus = isautoupdateexternalstatus;
    }

    public Boolean getShipmentCostIsModified() {
        return shipmentCostIsModified;
    }

    public void setShipmentCostIsModified(Boolean shipmentCostIsModified) {
        this.shipmentCostIsModified = shipmentCostIsModified;
    }

    public Integer getShipmentCostModifiedUserID() {
        return shipmentCostModifiedUserID;
    }

    public void setShipmentCostModifiedUserID(Integer shipmentCostModifiedUserID) {
        this.shipmentCostModifiedUserID = shipmentCostModifiedUserID;
    }

    public String getShipmentCostModifiedDatetime() {
        return shipmentCostModifiedDatetime;
    }

    public void setShipmentCostModifiedDatetime(String shipmentCostModifiedDatetime) {
        this.shipmentCostModifiedDatetime = shipmentCostModifiedDatetime;
    }

    public Integer getGrandTotalShipmentCost() {
        return grandTotalShipmentCost;
    }

    public void setGrandTotalShipmentCost(Integer grandTotalShipmentCost) {
        this.grandTotalShipmentCost = grandTotalShipmentCost;
    }

    public Boolean getIsOverrideShipmentCost() {
        return isOverrideShipmentCost;
    }

    public void setIsOverrideShipmentCost(Boolean isOverrideShipmentCost) {
        this.isOverrideShipmentCost = isOverrideShipmentCost;
    }

    public Boolean getIsDeliver() {
        return isDeliver;
    }

    public void setIsDeliver(Boolean isDeliver) {
        this.isDeliver = isDeliver;
    }

    public Object getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Object paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getPaymentStatusID() {
        return paymentStatusID;
    }

    public void setPaymentStatusID(Integer paymentStatusID) {
        this.paymentStatusID = paymentStatusID;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getFinalShippingCost() {
        return finalShippingCost;
    }

    public void setFinalShippingCost(Integer finalShippingCost) {
        this.finalShippingCost = finalShippingCost;
    }

    public Integer getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Integer invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Object getISCourierCompany() {
        return iSCourierCompany;
    }

    public void setISCourierCompany(Object iSCourierCompany) {
        this.iSCourierCompany = iSCourierCompany;
    }

    public Object getCourierTrackingNo() {
        return courierTrackingNo;
    }

    public void setCourierTrackingNo(Object courierTrackingNo) {
        this.courierTrackingNo = courierTrackingNo;
    }

    public Boolean getNotReadyForInvoicing() {
        return notReadyForInvoicing;
    }

    public void setNotReadyForInvoicing(Boolean notReadyForInvoicing) {
        this.notReadyForInvoicing = notReadyForInvoicing;
    }

    public Object getClientReferenceNumber() {
        return clientReferenceNumber;
    }

    public void setClientReferenceNumber(Object clientReferenceNumber) {
        this.clientReferenceNumber = clientReferenceNumber;
    }

    public Integer getCODCommissionFeeWithoutDiscount() {
        return cODCommissionFeeWithoutDiscount;
    }

    public void setCODCommissionFeeWithoutDiscount(Integer cODCommissionFeeWithoutDiscount) {
        this.cODCommissionFeeWithoutDiscount = cODCommissionFeeWithoutDiscount;
    }

    public Boolean getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(Boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    public Boolean getIsApiIntegration() {
        return isApiIntegration;
    }

    public void setIsApiIntegration(Boolean isApiIntegration) {
        this.isApiIntegration = isApiIntegration;
    }

    public Object getCourierCompanyTrackingNo() {
        return courierCompanyTrackingNo;
    }

    public void setCourierCompanyTrackingNo(Object courierCompanyTrackingNo) {
        this.courierCompanyTrackingNo = courierCompanyTrackingNo;
    }

    public Object getCourierCompanyName() {
        return courierCompanyName;
    }

    public void setCourierCompanyName(Object courierCompanyName) {
        this.courierCompanyName = courierCompanyName;
    }

    public Object getCODPayType() {
        return cODPayType;
    }

    public void setCODPayType(Object cODPayType) {
        this.cODPayType = cODPayType;
    }

    public Integer getDRInventoryStatusID() {
        return dRInventoryStatusID;
    }

    public void setDRInventoryStatusID(Integer dRInventoryStatusID) {
        this.dRInventoryStatusID = dRInventoryStatusID;
    }

    public Object getDRInventoryStatus() {
        return dRInventoryStatus;
    }

    public void setDRInventoryStatus(Object dRInventoryStatus) {
        this.dRInventoryStatus = dRInventoryStatus;
    }

    public Object getCheckinNotes() {
        return checkinNotes;
    }

    public void setCheckinNotes(Object checkinNotes) {
        this.checkinNotes = checkinNotes;
    }

    public Object getFullfilmentUnitsIDs() {
        return fullfilmentUnitsIDs;
    }

    public void setFullfilmentUnitsIDs(Object fullfilmentUnitsIDs) {
        this.fullfilmentUnitsIDs = fullfilmentUnitsIDs;
    }

    public Integer getIsItemsInventoryBased() {
        return isItemsInventoryBased;
    }

    public void setIsItemsInventoryBased(Integer isItemsInventoryBased) {
        this.isItemsInventoryBased = isItemsInventoryBased;
    }

    public Object getDeliveryRequestExternalStatusTracking() {
        return deliveryRequestExternalStatusTracking;
    }

    public void setDeliveryRequestExternalStatusTracking(Object deliveryRequestExternalStatusTracking) {
        this.deliveryRequestExternalStatusTracking = deliveryRequestExternalStatusTracking;
    }

    public Object getShipmentTracking() {
        return shipmentTracking;
    }

    public void setShipmentTracking(Object shipmentTracking) {
        this.shipmentTracking = shipmentTracking;
    }
}
