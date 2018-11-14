package mersattech.barqexpdriver.Utils.Tables.DBUtils.datamodel;

/**
 * Created by praveendewangan on 05/12/17.
 */

public class OrderFailure {

    public static final String TAG = OrderFailure.class.getSimpleName();
    public static final String TABLE = "Orderfailure";
    public static final String KEY_FAILURE_ID = "Deliveryid";
    public static final String KEY_FAILURE_NAME = "Failurename";
    public static final String KEY_FAILURE_ADDRESS = "Failureaddress";
    public static final String KEY_FAILURE_LAT = "Failurelat";
    public static final String KEY_FAILURE_LNG = "Failurelng";
    public static final String KEY_IS_COD = "Iscod";
    public static final String KEY_COD_VALUE = "Codvalue";

    private int failure_Id;
    private String failure_Name;
    private String failure_Address;
    private double failure_Lat;
    private double failure_lng;
    private boolean is_Cod;
    private double cod_Value;

    public int getFailure_Id() {
        return failure_Id;
    }

    public void setFailure_Id(int failure_Id) {
        this.failure_Id = failure_Id;
    }

    public String getFailure_Name() {
        return failure_Name;
    }

    public void setFailure_Name(String failure_Name) {
        this.failure_Name = failure_Name;
    }

    public double getFailure_Lat() {
        return failure_Lat;
    }

    public void setFailure_Lat(double failure_Lat) {
        this.failure_Lat = failure_Lat;
    }

    public double getFailure_lng() {
        return failure_lng;
    }

    public void setFailure_lng(double failure_lng) {
        this.failure_lng = failure_lng;
    }

    public boolean is_Cod() {
        return is_Cod;
    }

    public void setIs_Cod(boolean is_Cod) {
        this.is_Cod = is_Cod;
    }

    public String getFailure_Address() {
        return failure_Address;
    }

    public void setFailure_Address(String failure_Address) {
        this.failure_Address = failure_Address;
    }

    public double getCod_Value() {
        return cod_Value;
    }

    public void setCod_Value(double cod_Value) {
        this.cod_Value = cod_Value;
    }
}

