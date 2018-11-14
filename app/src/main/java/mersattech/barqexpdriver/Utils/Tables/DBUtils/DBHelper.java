package mersattech.barqexpdriver.Utils.Tables.DBUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import mersattech.barqexpdriver.Utils.Tables.DBUtils.datamodel.OrderDelivery;
import mersattech.barqexpdriver.Utils.Tables.DBUtils.datamodel.OrderFailure;
import mersattech.barqexpdriver.Utils.Tables.DBUtils.datamodel.OrderItem;
import mersattech.barqexpdriver.Utils.Tables.DBUtils.datamodel.OrderPickup;

public class DBHelper extends SQLiteOpenHelper {
    //common fields
    public static final String KEY_No_Of_Items = "NoOfItems";
    // Database Name = Orderpickup
    public static final String TABLE_Order_Pickup = "Orderpickup";
    public static final String KEY_Order_Id = "Order_Id";
    public static final String KEY_Shipper_Name = "Shipper_Name";
    public static final String KEY_Shipment_value = "Shipment_value";
    public static final String KEY_Address_Details = "Address_Details";
    public static final String KEY_Pickup_Lat = "Pickup_Lat";
    public static final String KEY_Pickup_lng = "Pickup_lng";
    public static final String KEY_Pickup_COMPLETED = "Pickupcompleted";
    public static final String TAG = OrderDelivery.class.getSimpleName();
    public static final String TABLE_ORDER_DELIVERY = "Orderdelivery";
    public static final String KEY_DELIVERY_ID = "Deliveryid";


    // Database Name = Orderdelivery
    public static final String KEY_RECEIVERS_NAME = "Receiversname";
    public static final String KEY_RECEIVER_ADDRESS = "Receiveraddress";
    public static final String KEY_RECEIVER_LAT = "Receiverslat";
    public static final String KEY_RECEIVER_LNG = "Receiverslng";
    //    public static final String KEY_No_Of_Items = "NoOfItems";
    public static final String KEY_IS_COD = "Iscod";
    public static final String KEY_COD_VALUE = "Codvalue";
    public static final String KEY_DELIVERY_COMPLETED = "Deliverycompleted";
    // Database Name = Orderdeliveryfailure
    public static final String TABLE_ORDER_FAILURE = "Orderfailure";
    public static final String KEY_FAILURE_ID = "Deliveryid";
    public static final String KEY_FAILURE_NAME = "Failurename";
    public static final String KEY_FAILURE_ADDRESS = "Failureaddress";
    public static final String KEY_FAILURE_LAT = "Failurelat";
    public static final String KEY_FAILURE_LNG = "Failurelng";
    public static final String TABLE_ITEM = "Orderitem";
    public static final String KEY_ITEM_ID = "Itemid";
    //    public static final String KEY_DELIVERY_ID = "Deliveryid";
    public static final String KEY_STATUS = "Status";
    public static final String KEY_ITEM_SHIPMENT_VALUE = "Itemshipmentvalue";
    public static final String KEY_QR_CODE = "Qrcode";


    // Database Name = OrderITEM
    public static final String KEY_NO_OF_UNITS = "Noofunits";
    public static final String KEY_PICKED_UP = "Pickedup";
    public static final String KEY_DELIVERED = "Delivered";
    public static final String KEY_FAILURE_DELIVERY = "Failuredelivery";
    private static final int DATABASE_VERSION = 8;
    private static final String DATABASE_NAME = "BarqExpDB.db";
    //    public static final String KEY_No_Of_Items = "NoOfItems";
    private static final String CREATE_TABLE_ORDER_PICKUP = "CREATE TABLE "
            + TABLE_Order_Pickup + "(" + KEY_Order_Id + " INTEGER PRIMARY KEY," + KEY_Shipper_Name
            + " TEXT," + KEY_Address_Details + " TEXT," + KEY_Pickup_Lat + " REAL," +
            KEY_Pickup_lng + " REAL," + KEY_Pickup_COMPLETED + "INTEGER, " + KEY_Shipment_value +
            " REAL" + KEY_No_Of_Items + "INTEGER" + ")";
    private static final String CREATE_TABLE_ORDER_DELIVERY = "CREATE TABLE "
            + TABLE_ORDER_DELIVERY + "(" + KEY_DELIVERY_ID + " INTEGER PRIMARY KEY," +
            KEY_RECEIVERS_NAME + " TEXT," + KEY_RECEIVER_ADDRESS + " TEXT," + KEY_RECEIVER_LAT +
            " REAL," + KEY_RECEIVER_LNG + " REAL," + KEY_No_Of_Items + "INTEGER," + KEY_IS_COD +
            "INTEGER, " + KEY_COD_VALUE + " REAL" + KEY_DELIVERY_COMPLETED + "INTEGER," + ")";
    //    public static final String KEY_IS_COD = "Iscod";
//    public static final String KEY_COD_VALUE = "Codvalue";
    private static final String CREATE_TABLE_ORDER_FAILURE_DELIVERY = "CREATE TABLE "
            + TABLE_ORDER_FAILURE + "(" + KEY_FAILURE_ID + " INTEGER PRIMARY KEY," +
            KEY_FAILURE_NAME + " TEXT," + KEY_FAILURE_ADDRESS + " TEXT," + KEY_FAILURE_LAT + " REAL,"
            + KEY_FAILURE_LNG + " REAL," + KEY_IS_COD + "INTEGER, " + KEY_COD_VALUE + " REAL"
            + ")";
    private static final String CREATE_TABLE_ORDER_ITEM = "CREATE TABLE "
            + TABLE_ITEM + "(" + KEY_ITEM_ID + " INTEGER PRIMARY KEY," + KEY_DELIVERY_ID +
            "INTEGER PRIMARY KEY," + KEY_STATUS + " TEXT," + KEY_QR_CODE + " TEXT," +
            KEY_ITEM_SHIPMENT_VALUE + " REAL,"
            + KEY_NO_OF_UNITS + "INTEGER, " + KEY_PICKED_UP + " INTEGER," + KEY_FAILURE_DELIVERY
            + " INTEGER," + KEY_DELIVERED + "INTEGER" + ")";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ORDER_PICKUP);
        db.execSQL(CREATE_TABLE_ORDER_DELIVERY);
        db.execSQL(CREATE_TABLE_ORDER_FAILURE_DELIVERY);
        db.execSQL(CREATE_TABLE_ORDER_ITEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER_PICKUP);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER_DELIVERY);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER_FAILURE_DELIVERY);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER_ITEM);

        onCreate(db);
    }


    //Create operation for all
    public void createPickup(OrderPickup orderPickup) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Order_Id, orderPickup.getOrder_Id());
        values.put(KEY_Shipper_Name, orderPickup.getShipper_Name());
        values.put(KEY_Shipment_value, orderPickup.getShipment_value());
        values.put(KEY_Address_Details, orderPickup.getAddress_Details());
        values.put(KEY_Pickup_Lat, orderPickup.getPickup_Lat());
        values.put(KEY_Pickup_lng, orderPickup.getPickup_Lng());
        values.put(KEY_Pickup_COMPLETED, orderPickup.isPickup_Completed());
        values.put(KEY_No_Of_Items, orderPickup.getNo_Of_Items());


        // insert row
        db.insert(TABLE_Order_Pickup, null, values);
    }

    public void createDelivery(OrderDelivery orderDelivery) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DELIVERY_ID, orderDelivery.getDelivery_Id());
        values.put(KEY_RECEIVERS_NAME, orderDelivery.getReceivers_Name());
        values.put(KEY_RECEIVER_ADDRESS, orderDelivery.getReceivers_Address());
        values.put(KEY_RECEIVER_LAT, orderDelivery.getReceivers_Lat());
        values.put(KEY_RECEIVER_LNG, orderDelivery.getReceivers_Lng());
        values.put(KEY_IS_COD, orderDelivery.is_Cod());
        values.put(KEY_COD_VALUE, orderDelivery.getCod_Value());
        values.put(KEY_DELIVERY_COMPLETED, orderDelivery.isDelivery_Completed());


        // insert row
        db.insert(TABLE_ORDER_DELIVERY, null, values);
    }

    public void createFailure(OrderFailure orderFailure) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FAILURE_ID, orderFailure.getFailure_Id());
        values.put(KEY_FAILURE_NAME, orderFailure.getFailure_Name());
        values.put(KEY_FAILURE_ADDRESS, orderFailure.getFailure_Address());
        values.put(KEY_FAILURE_LAT, orderFailure.getFailure_Lat());
        values.put(KEY_FAILURE_LNG, orderFailure.getFailure_lng());
        values.put(KEY_IS_COD, orderFailure.is_Cod());
        values.put(KEY_COD_VALUE, orderFailure.getCod_Value());


        // insert row
        db.insert(TABLE_ORDER_FAILURE, null, values);
    }

    public void createitems(OrderItem orderItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ITEM_ID, orderItem.getOrder_id());
        values.put(KEY_DELIVERY_ID, orderItem.getOrder_id());
        values.put(KEY_STATUS, orderItem.getStatus());
        values.put(KEY_ITEM_SHIPMENT_VALUE, orderItem.getItem_Shipment_Value());
        values.put(KEY_QR_CODE, orderItem.getQr_Code());
        values.put(KEY_NO_OF_UNITS, orderItem.getNo_Of_Units());
        values.put(KEY_PICKED_UP, orderItem.isPicked_Up());
        values.put(KEY_DELIVERED, orderItem.isDelivered());
        values.put(KEY_FAILURE_DELIVERY, orderItem.isFailure_Delivery());


        // insert row
        db.insert(TABLE_ITEM, null, values);
    }


    //Read operation for all

    public ArrayList<OrderPickup> getAllPickups() {
        ArrayList<OrderPickup> orderPickupArrayList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_Order_Pickup;

        Log.e("pickup order selected", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                OrderPickup orderPickup = new OrderPickup();
                orderPickup.setOrder_Id(c.getInt((c.getColumnIndex(KEY_Order_Id))));
                orderPickup.setShipper_Name(c.getString(c.getColumnIndex(KEY_Shipper_Name)));
                orderPickup.setAddress_Details(c.getString((c.getColumnIndex(KEY_Address_Details))));
                orderPickup.setPickup_Lat(c.getDouble((c.getColumnIndex(KEY_Pickup_Lat))));
                orderPickup.setPickup_Lng(c.getDouble((c.getColumnIndex(KEY_Pickup_lng))));
                if (c.getColumnIndex(KEY_Pickup_COMPLETED) == 0) {
                    orderPickup.setPickup_Completed(false);
                } else {
                    orderPickup.setPickup_Completed(true);
                }
                orderPickup.setShipment_value(c.getDouble((c.getColumnIndex(KEY_Shipment_value))));
                orderPickup.setNo_Of_Items(c.getInt((c.getColumnIndex(KEY_No_Of_Items))));


                // adding to todo list
                orderPickupArrayList.add(orderPickup);
            } while (c.moveToNext());
        }

        return orderPickupArrayList;
    }

    public ArrayList<OrderDelivery> getAllDelivery() {
        ArrayList<OrderDelivery> orderDeliveryArrayList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_ORDER_DELIVERY;

        Log.e("Delivery order selected", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                OrderDelivery orderDelivery = new OrderDelivery();
                orderDelivery.setDelivery_Id(c.getInt((c.getColumnIndex(KEY_DELIVERY_ID))));
                orderDelivery.setReceivers_Name(c.getString(c.getColumnIndex(KEY_RECEIVERS_NAME)));
                orderDelivery.setReceivers_Address(c.getString((c.getColumnIndex(KEY_RECEIVER_ADDRESS))));
                orderDelivery.setReceivers_Lat(c.getDouble((c.getColumnIndex(KEY_RECEIVER_LAT))));
                orderDelivery.setReceivers_Lng(c.getDouble((c.getColumnIndex(KEY_RECEIVER_LNG))));
                orderDelivery.setNo_Of_Items(c.getInt((c.getColumnIndex(KEY_No_Of_Items))));

                if (c.getColumnIndex(KEY_Pickup_COMPLETED) == 0) {
                    orderDelivery.setIs_Cod(false);
                } else {
                    orderDelivery.setIs_Cod(true);
                }
                orderDelivery.setCod_Value(c.getInt((c.getColumnIndex(KEY_COD_VALUE))));

                if (c.getColumnIndex(KEY_DELIVERY_COMPLETED) == 0) {
                    orderDelivery.setDelivery_Completed(false);
                } else {
                    orderDelivery.setDelivery_Completed(true);
                }


                // adding to todo list
                orderDeliveryArrayList.add(orderDelivery);
            } while (c.moveToNext());
        }

        return orderDeliveryArrayList;
    }

    public ArrayList<OrderFailure> getAllFailure() {
        ArrayList<OrderFailure> orderFailureArrayList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_ORDER_FAILURE;

        Log.e("Delivery order selected", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {

                OrderFailure orderFailure = new OrderFailure();
                orderFailure.setFailure_Id(c.getInt((c.getColumnIndex(KEY_FAILURE_ID))));
                orderFailure.setFailure_Name(c.getString(c.getColumnIndex(KEY_FAILURE_NAME)));
                orderFailure.setFailure_Address(c.getString((c.getColumnIndex(KEY_FAILURE_ADDRESS))));
                orderFailure.setFailure_Lat(c.getDouble((c.getColumnIndex(KEY_FAILURE_LAT))));
                orderFailure.setFailure_lng(c.getDouble((c.getColumnIndex(KEY_FAILURE_LNG))));

                if (c.getColumnIndex(KEY_IS_COD) == 0) {
                    orderFailure.setIs_Cod(false);
                } else {
                    orderFailure.setIs_Cod(true);
                }
                orderFailure.setCod_Value(c.getInt((c.getColumnIndex(KEY_COD_VALUE))));

                // adding to todo list
                orderFailureArrayList.add(orderFailure);
            } while (c.moveToNext());
        }

        return orderFailureArrayList;
    }

    public ArrayList<OrderItem> getAllItems() {
        ArrayList<OrderItem> orderItemArrayList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM;

        Log.e("Items order selected", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                String CREATE_TABLE_ORDER_ITEM = "CREATE TABLE "
                        + TABLE_ITEM + "(" + KEY_ITEM_ID + " INTEGER PRIMARY KEY," + KEY_DELIVERY_ID +
                        "INTEGER PRIMARY KEY," + KEY_STATUS + " TEXT," + KEY_QR_CODE + " TEXT," +
                        KEY_ITEM_SHIPMENT_VALUE + " REAL,"
                        + KEY_NO_OF_UNITS + "INTEGER, " + KEY_PICKED_UP + " INTEGER," + KEY_FAILURE_DELIVERY
                        + " INTEGER," + KEY_DELIVERED + "INTEGER" + ")";

                OrderItem orderItem = new OrderItem();
                orderItem.setItem_id(c.getInt((c.getColumnIndex(KEY_ITEM_ID))));
                orderItem.setStatus(c.getString((c.getColumnIndex(KEY_STATUS))));
                orderItem.setQr_Code(c.getLong((c.getColumnIndex(KEY_QR_CODE))));
                orderItem.setItem_Shipment_Value(c.getDouble((c.getColumnIndex(KEY_ITEM_SHIPMENT_VALUE))));
                orderItem.setNo_Of_Units(c.getInt((c.getColumnIndex(KEY_NO_OF_UNITS))));

                if (c.getInt((c.getColumnIndex(KEY_PICKED_UP))) == 0) {
                    orderItem.setPicked_Up(false);
                } else {
                    orderItem.setPicked_Up(true);
                }
                if (c.getInt((c.getColumnIndex(KEY_FAILURE_DELIVERY))) == 0) {
                    orderItem.setFailure_Delivery(false);
                } else {
                    orderItem.setFailure_Delivery(true);
                }
                if (c.getInt((c.getColumnIndex(KEY_DELIVERED))) == 0) {
                    orderItem.setDelivered(false);
                } else {
                    orderItem.setDelivered(true);
                }


                // adding to todo list
                orderItemArrayList.add(orderItem);
            } while (c.moveToNext());
        }

        return orderItemArrayList;
    }


}