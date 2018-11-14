
package mersattech.barqexpdriver.Models.s.OrdersList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryRequestItemEntity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("GrossShipmentItemWeight")
    @Expose
    private double grossShipmentItemWeight;
    @SerializedName("length")
    @Expose
    private double length;
    @SerializedName("width")
    @Expose
    private double width;
    @SerializedName("height")
    @Expose
    private double height;
    @SerializedName("delivery_request_id")
    @Expose
    private Integer deliveryRequestId;
    @SerializedName("number_of_units")
    @Expose
    private Integer numberOfUnits;
    @SerializedName("item_shipping_cost")
    @Expose
    private Double itemShippingCost;
    @SerializedName("goods_origin_country_id")
    @Expose
    private Integer goodsOriginCountryId;
    @SerializedName("declared_value")
    @Expose
    private double declaredValue;
    @SerializedName("shipment_reference")
    @Expose
    private String shipmentReference;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("shipment_item_volume")
    @Expose
    private double shipmentItemVolume;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("item_QR_code")
    @Expose
    private String itemQRCode;
    @SerializedName("InsuranceAmount")
    @Expose
    private double insuranceAmount;
    @SerializedName("IsPickedUp")
    @Expose
    private Boolean isPickedUp;
    @SerializedName("IsDelivered")
    @Expose
    private Boolean isDelivered;
    @SerializedName("DeliveryStatusID")
    @Expose
    private Integer deliveryStatusID;

    @SerializedName("DeliveryItemMainImageStreamId")
    @Expose
    private String deliveryItemMainImageStreamId;

    public String getDeliveryItemMainImageStreamId() {
        return deliveryItemMainImageStreamId;
    }

    public void setDeliveryItemMainImageStreamId(String deliveryItemMainImageStreamId) {
        this.deliveryItemMainImageStreamId = deliveryItemMainImageStreamId;
    }


    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public double getGrossShipmentItemWeight() {
        return grossShipmentItemWeight;
    }

    public void setGrossShipmentItemWeight(double grossShipmentItemWeight) {
        this.grossShipmentItemWeight = grossShipmentItemWeight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Integer getDeliveryRequestId() {
        return deliveryRequestId;
    }

    public void setDeliveryRequestId(Integer deliveryRequestId) {
        this.deliveryRequestId = deliveryRequestId;
    }

    public Integer getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(Integer numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public Double getItemShippingCost() {
        return itemShippingCost;
    }

    public void setItemShippingCost(Double itemShippingCost) {
        this.itemShippingCost = itemShippingCost;
    }

    public Integer getGoodsOriginCountryId() {
        return goodsOriginCountryId;
    }

    public void setGoodsOriginCountryId(Integer goodsOriginCountryId) {
        this.goodsOriginCountryId = goodsOriginCountryId;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(double declaredValue) {
        this.declaredValue = declaredValue;
    }

    public String getShipmentReference() {
        return shipmentReference;
    }

    public void setShipmentReference(String shipmentReference) {
        this.shipmentReference = shipmentReference;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getShipmentItemVolume() {
        return shipmentItemVolume;
    }

    public void setShipmentItemVolume(double shipmentItemVolume) {
        this.shipmentItemVolume = shipmentItemVolume;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQRCode() {
        return itemQRCode;
    }

    public void setItemQRCode(String itemQRCode) {
        this.itemQRCode = itemQRCode;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Boolean getIsPickedUp() {
        return isPickedUp;
    }

    public void setIsPickedUp(Boolean isPickedUp) {
        this.isPickedUp = isPickedUp;
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

}
