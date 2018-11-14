package mersattech.barqexpdriver.Models.s.CurrentOrders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryRequestItem {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("GrossShipmentItemWeight")
    @Expose
    private Integer grossShipmentItemWeight;
    @SerializedName("length")
    @Expose
    private Object length;
    @SerializedName("width")
    @Expose
    private Object width;
    @SerializedName("height")
    @Expose
    private Object height;
    @SerializedName("delivery_request_id")
    @Expose
    private Integer deliveryRequestId;
    @SerializedName("number_of_units")
    @Expose
    private Integer numberOfUnits;
    @SerializedName("item_shipping_cost")
    @Expose
    private Object itemShippingCost;
    @SerializedName("goods_origin_country_id")
    @Expose
    private Object goodsOriginCountryId;
    @SerializedName("declared_value")
    @Expose
    private Object declaredValue;
    @SerializedName("shipment_reference")
    @Expose
    private String shipmentReference;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("shipment_item_volume")
    @Expose
    private Integer shipmentItemVolume;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("item_QR_code")
    @Expose
    private String itemQRCode;
    @SerializedName("InsuranceAmount")
    @Expose
    private Integer insuranceAmount;
    @SerializedName("IsPickedUp")
    @Expose
    private Boolean isPickedUp;
    @SerializedName("IsDelivered")
    @Expose
    private Boolean isDelivered;
    @SerializedName("IsCOD")
    @Expose
    private Boolean isCOD;
    @SerializedName("CODAmount")
    @Expose
    private Integer cODAmount;
    @SerializedName("DeliveryItemMainImageStreamId")
    @Expose
    private String deliveryItemMainImageStreamId;
    @SerializedName("DeliveryStatusID")
    @Expose
    private Integer deliveryStatusID;
    @SerializedName("DeliveryOrderID")
    @Expose
    private Integer deliveryOrderID;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getGrossShipmentItemWeight() {
        return grossShipmentItemWeight;
    }

    public void setGrossShipmentItemWeight(Integer grossShipmentItemWeight) {
        this.grossShipmentItemWeight = grossShipmentItemWeight;
    }

    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

    public Object getWidth() {
        return width;
    }

    public void setWidth(Object width) {
        this.width = width;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
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

    public Object getItemShippingCost() {
        return itemShippingCost;
    }

    public void setItemShippingCost(Object itemShippingCost) {
        this.itemShippingCost = itemShippingCost;
    }

    public Object getGoodsOriginCountryId() {
        return goodsOriginCountryId;
    }

    public void setGoodsOriginCountryId(Object goodsOriginCountryId) {
        this.goodsOriginCountryId = goodsOriginCountryId;
    }

    public Object getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(Object declaredValue) {
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

    public Integer getShipmentItemVolume() {
        return shipmentItemVolume;
    }

    public void setShipmentItemVolume(Integer shipmentItemVolume) {
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

    public Integer getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Integer insuranceAmount) {
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

    public Boolean getIsCOD() {
        return isCOD;
    }

    public void setIsCOD(Boolean isCOD) {
        this.isCOD = isCOD;
    }

    public Integer getCODAmount() {
        return cODAmount;
    }

    public void setCODAmount(Integer cODAmount) {
        this.cODAmount = cODAmount;
    }

    public String getDeliveryItemMainImageStreamId() {
        return deliveryItemMainImageStreamId;
    }

    public void setDeliveryItemMainImageStreamId(String deliveryItemMainImageStreamId) {
        this.deliveryItemMainImageStreamId = deliveryItemMainImageStreamId;
    }

    public Integer getDeliveryStatusID() {
        return deliveryStatusID;
    }

    public void setDeliveryStatusID(Integer deliveryStatusID) {
        this.deliveryStatusID = deliveryStatusID;
    }

    public Integer getDeliveryOrderID() {
        return deliveryOrderID;
    }

    public void setDeliveryOrderID(Integer deliveryOrderID) {
        this.deliveryOrderID = deliveryOrderID;
    }

}
