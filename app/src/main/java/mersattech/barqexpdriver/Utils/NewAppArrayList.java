package mersattech.barqexpdriver.Utils;

import mersattech.barqexpdriver.Models.s.CurrentOrders.CurrentOrderResponse;
import mersattech.barqexpdriver.Models.s.OrdersList.OrderListResponseModel;

public class NewAppArrayList {
    private static NewAppArrayList newAppArrayList;
    // private OrderListResponseModel orderListResponseModels = new OrderListResponseModel();

    private CurrentOrderResponse orderListResponseModels = new CurrentOrderResponse();
    private OrderListResponseModel orderListResponseModels1 = new OrderListResponseModel();

    public static NewAppArrayList getInstance() {
        if (newAppArrayList == null) {
            newAppArrayList = new NewAppArrayList();
        }
        return newAppArrayList;
    }

    public CurrentOrderResponse getOrderListResponseModels() {
        return orderListResponseModels;
    }

    public void setOrderListResponseModels(CurrentOrderResponse orderListResponseModels) {
        this.orderListResponseModels = orderListResponseModels;
    }

    public OrderListResponseModel getOrderListResponseModels1() {
        return orderListResponseModels1;
    }

    public void setOrderListResponseModels1(OrderListResponseModel orderListResponseModels) {
        this.orderListResponseModels1 = orderListResponseModels1;
    }
}