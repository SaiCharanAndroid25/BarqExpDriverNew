package mersattech.barqexpdriver.Utils.Tables.DBUtils.datamodel;

/**
 * Created by praveendewangan on 05/12/17.
 */

public class OrderItem {

    public static final String TAG = OrderItem.class.getSimpleName();
    public static final String TABLE = "Orderitem";
    public static final String KEY_ITEM_ID = "Itemid";
    public static final String KEY_DELIVERY_ID = "Deliveryid";
    public static final String KEY_STATUS = "Status";
    public static final String KEY_ITEM_SHIPMENT_VALUE = "Itemshipmentvalue";
    public static final String KEY_QR_CODE = "Qrcode";
    public static final String KEY_NO_OF_UNITS = "Noofunits";
    public static final String KEY_PICKED_UP = "Pickedup";
    public static final String KEY_DELIVERED = "Delivered";
    public static final String KEY_FAILURE_DELIVERY = "Failuredelivery";

    private int item_id;
    private int order_id;
    private String status;
    private double item_Shipment_Value;
    private long qr_Code;
    private int no_Of_Units;
    private boolean picked_Up;
    private boolean delivered;
    private boolean failure_Delivery;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getItem_Shipment_Value() {
        return item_Shipment_Value;
    }

    public void setItem_Shipment_Value(double item_Shipment_Value) {
        this.item_Shipment_Value = item_Shipment_Value;
    }

    public long getQr_Code() {
        return qr_Code;
    }

    public void setQr_Code(long qr_Code) {
        this.qr_Code = qr_Code;
    }

    public int getNo_Of_Units() {
        return no_Of_Units;
    }

    public void setNo_Of_Units(int no_Of_Units) {
        this.no_Of_Units = no_Of_Units;
    }

    public boolean isPicked_Up() {
        return picked_Up;
    }

    public void setPicked_Up(boolean picked_Up) {
        this.picked_Up = picked_Up;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isFailure_Delivery() {
        return failure_Delivery;
    }

    public void setFailure_Delivery(boolean failure_Delivery) {
        this.failure_Delivery = failure_Delivery;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
