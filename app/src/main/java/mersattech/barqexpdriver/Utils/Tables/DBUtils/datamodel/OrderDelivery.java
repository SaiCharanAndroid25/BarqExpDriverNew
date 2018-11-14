package mersattech.barqexpdriver.Utils.Tables.DBUtils.datamodel;

/**
 * Created by praveendewangan on 05/12/17.
 */

public class OrderDelivery {

    public static final String TAG = OrderDelivery.class.getSimpleName();
    public static final String TABLE = "Orderdelivery";
    public static final String KEY_DELIVERY_ID = "Deliveryid";
    public static final String KEY_RECEIVERS_NAME = "Receiversname";
    public static final String KEY_RECEIVER_ADDRESS = "Receiveraddress";
    public static final String KEY_RECEIVER_LAT = "Receiverslat";
    public static final String KEY_RECEIVER_LNG = "Receiverslng";
    public static final String KEY_No_Of_Items = "No_Of_Items";
    public static final String KEY_IS_COD = "Iscod";
    public static final String KEY_COD_VALUE = "Codvalue";
    public static final String KEY_DELIVERY_COMPLETED = "Deliverycompleted";

    private int delivery_Id;
    private String receivers_Name;
    private String receivers_Address;
    private double receivers_Lat;
    private double receivers_Lng;
    private boolean is_Cod;
    private int no_Of_Items;
    private double cod_Value;
    private boolean delivery_Completed;

    public int getDelivery_Id() {
        return delivery_Id;
    }

    public void setDelivery_Id(int delivery_Id) {
        this.delivery_Id = delivery_Id;
    }

    public String getReceivers_Name() {
        return receivers_Name;
    }

    public void setReceivers_Name(String receivers_Name) {
        this.receivers_Name = receivers_Name;
    }

    public double getReceivers_Lat() {
        return receivers_Lat;
    }

    public void setReceivers_Lat(double receivers_Lat) {
        this.receivers_Lat = receivers_Lat;
    }

    public double getReceivers_Lng() {
        return receivers_Lng;
    }

    public void setReceivers_Lng(double receivers_Lng) {
        this.receivers_Lng = receivers_Lng;
    }

    public boolean is_Cod() {
        return is_Cod;
    }

    public void setIs_Cod(boolean is_Cod) {
        this.is_Cod = is_Cod;
    }

    public double getCod_Value() {
        return cod_Value;
    }

    public void setCod_Value(double cod_Value) {
        this.cod_Value = cod_Value;
    }

    public String getReceivers_Address() {
        return receivers_Address;
    }

    public void setReceivers_Address(String receivers_Address) {
        this.receivers_Address = receivers_Address;
    }

    public boolean isDelivery_Completed() {
        return delivery_Completed;
    }

    public void setDelivery_Completed(boolean delivery_Completed) {
        this.delivery_Completed = delivery_Completed;
    }

    public int getNo_Of_Items() {
        return no_Of_Items;
    }

    public void setNo_Of_Items(int no_Of_Items) {
        this.no_Of_Items = no_Of_Items;
    }
}

