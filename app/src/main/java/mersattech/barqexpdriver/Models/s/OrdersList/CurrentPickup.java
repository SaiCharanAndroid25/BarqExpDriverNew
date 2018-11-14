package mersattech.barqexpdriver.Models.s.OrdersList;

import java.util.ArrayList;

import mersattech.barqexpdriver.Models.s.CurrentOrders.DeliveryRequestDetail;
import mersattech.barqexpdriver.Models.s.CurrentOrders.DeliveryRequestItem;

/**
 * Created by praveendewangan on 13/12/17.
 */

public class CurrentPickup {

    private double pickupLat;
    private double pickupLng;
    private int    pickId;
    private String pickupDesc;
    private int    deliveryId;
    private java.util.ArrayList<DeliveryRequestItem> deliveryRequestItem = new ArrayList<>();
    private java.util.ArrayList<DeliveryRequestDetail> deliveryRequestDetail = new ArrayList<>();

    private static CurrentPickup currentPickup;

    public static CurrentPickup getInstance() {
        if (currentPickup == null) {
            currentPickup = new CurrentPickup();
        }
        return currentPickup;
    }
    public double getPickupLng() {
        return pickupLng;
    }

    public void setPickupLng(double pickupLng) {
        this.pickupLng = pickupLng;
    }

    public int getPickId() {
        return pickId;
    }

    public void setPickId(int pickId) {
        this.pickId = pickId;
    }

    public String getPickupDesc() {
        return pickupDesc;
    }

    public void setPickupDesc(String pickupDesc) {
        this.pickupDesc = pickupDesc;
    }

    public java.util.ArrayList<DeliveryRequestItem> getDeliveryRequestItemEntities() {
        return deliveryRequestItem;
    }

    public void setDeliveryRequestItemEntities(java.util.ArrayList<DeliveryRequestItem> deliveryRequestItemEntities) {
        this.deliveryRequestItem = deliveryRequestItemEntities;
    }

    public java.util.ArrayList<DeliveryRequestDetail> getDeliveryRequestDetails() {
        return deliveryRequestDetail;
    }

    public void setDeliveryRequestDetails(java.util.ArrayList<DeliveryRequestDetail> deliveryRequestDetails) {
        this.deliveryRequestDetail = deliveryRequestDetails;
    }

    public double getPickupLat() {

        return pickupLat;
    }

    public void setPickupLat(double pickupLat) {
        this.pickupLat = pickupLat;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
}
