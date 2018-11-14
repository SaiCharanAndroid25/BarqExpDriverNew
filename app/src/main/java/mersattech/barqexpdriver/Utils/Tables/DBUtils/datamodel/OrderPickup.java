package mersattech.barqexpdriver.Utils.Tables.DBUtils.datamodel;

public class OrderPickup {
    public static final String TAG = OrderPickup.class.getSimpleName();
    public static final String TABLE = "Orderpickup";
    public static final String KEY_Order_Id = "Order_Id";
    public static final String KEY_Pickup_Id = "Pickup_Id";
    public static final String KEY_Shipper_Name = "Shipper_Name";
    public static final String KEY_Shipment_value = "Shipment_value";
    public static final String KEY_No_Of_Items = "No_Of_Items";
    public static final String KEY_Address_Details = "Address_Details";
    public static final String KEY_Pickup_Lat = "Pickup_Lat";
    public static final String KEY_Pickup_lng = "Pickup_lng";
    public static final String KEY_Pickup_COMPLETED = "Pickupcompleted";

    private int order_Id;
    private int pickup_Id;
    private String shipper_Name;
    private double shipment_value;
    private int no_Of_Items;
    private String address_Details;
    private double pickup_Lat;
    private double pickup_Lng;
    private boolean pickup_Completed;

    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public int getPickup_Id() {
        return pickup_Id;
    }

    public void setPickup_Id(int pickup_Id) {
        this.pickup_Id = pickup_Id;
    }

    public String getShipper_Name() {
        return shipper_Name;
    }

    public void setShipper_Name(String shipper_Name) {
        this.shipper_Name = shipper_Name;
    }

    public double getShipment_value() {
        return shipment_value;
    }

    public void setShipment_value(double shipment_value) {
        this.shipment_value = shipment_value;
    }

    public int getNo_Of_Items() {
        return no_Of_Items;
    }

    public void setNo_Of_Items(int no_Of_Items) {
        this.no_Of_Items = no_Of_Items;
    }

    public String getAddress_Details() {
        return address_Details;
    }

    public void setAddress_Details(String address_Details) {
        this.address_Details = address_Details;
    }

    public double getPickup_Lat() {
        return pickup_Lat;
    }

    public void setPickup_Lat(double pickup_Lat) {
        this.pickup_Lat = pickup_Lat;
    }

    public double getPickup_Lng() {
        return pickup_Lng;
    }

    public void setPickup_Lng(double pickup_Lng) {
        this.pickup_Lng = pickup_Lng;
    }

    public boolean isPickup_Completed() {
        return pickup_Completed;
    }

    public void setPickup_Completed(boolean pickup_Completed) {
        this.pickup_Completed = pickup_Completed;
    }
}
