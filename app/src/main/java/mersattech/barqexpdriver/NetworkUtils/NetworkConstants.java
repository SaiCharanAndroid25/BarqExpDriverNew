package mersattech.barqexpdriver.NetworkUtils;

public class NetworkConstants {

  //  public static final String BASE_URL = "http://devapi.barqexp.com/";
    // public static final String BASE_URL = "http://mobile.barqexp.com/";

  //  new driver base url
    public static final String BASE_URL = "https://testdriverapiv1.barqexp.com/";


    public static final String USER_SERVICE = "Api/UserService/";
    public static final String COUNTRY_SERVICE = "Api/CountryService/";
    public static final String CITY_SERVICE = "Api/CityService/";
    public static final String BLOCK_SERVICE = "Api/BlockService/";
    public static final String CHECKED_SERVICE = "Api/InventoryService/";
    public static final String VEHICLE_TYPE_SERVICE = "Api/VehicleTypesService/";
    public static final String VEHICLE_MANUFACTURES_SERVICE = "Api/VehicleManufacturersService/";
    public static final String VEHICLE_MODEL_TYPE_SERVICE = "Api/VehicleModelTypesService/";
    public static final String DRIVER_SERVICES = "Api/DriverService/";
    public static final String HISTORY_SERVICES = "api/DeliveryOrderDeliveryRequestService/";
    public static final String BANK_SERVICES = "Api/BankService/";
    public static final String BANK_ACCOUNT_SERVICE = "Api/DriverBankAccountsService/";
    public static final String VEHICLE_SERVICE = "Api/VehicleService/";
    public static final String IMAGE_SERVICE = "http://devapi.barqexp.com/Api/ImageService/Getdocumentimagesbystreamid/";
    public static final String IMAGE_RETROFIT_SERVICE = BASE_URL + "Api/ImageService/Getdocumentimagesbystreamid/{imageId}";
    public static final String DELIVERY_ORDER_ASSIGNMENT_SERVICE = "Api/DeliveryOrderAssignmentService/";
    public static final String DRIVER_TRACKING_SERVICE = "Api/DriverTrackingService/";
    public static final String DRIVER_TRACKING_ADD = DRIVER_TRACKING_SERVICE + "Add";
    public static final String ITEM_PICKUPED_UP = "Api/DeliveryRequestItemService/UpdateItemPickedUP";
    public static final String DR_DELIVERED = "Api/DeliveryRequestService/UpdateDeliveryStatus";
    public static final String ITEM_DELIVERED = "Api/DeliveryRequestItemService/UpdateItemDelivered";
    public static final String ITEM_PICKEDUP_IMAGE_ID = "Api/DeliveryRequestItemService/GetDRItemImageFindByID/{item_id}";
    public static final String ITEM_PICKEDUP_IMAGE = "Api/ImageService/DeliveryRequestItemImageFindByStreamID/{stream_id}";
    public static final String ITEM_PICKEDUP_IMAGE_WHILE_DR = "Api/DeliveryRequestItemService/GetDRItemImageFindByID/{item_id}";
    public static final String DRIVER_REGISTRATION_URL = USER_SERVICE + "MDriverRegister";


    public static final String DRIVER_LOGIN_URL = USER_SERVICE + "Login";
    public static final String FORGOT_PASSWORD_URL = USER_SERVICE + "SendConfirmationCodetomobile";
    public static final String Reset_PASSWORD_URL = USER_SERVICE + "UpdateUserPassword";
    public static final String RESENDOTP_URL = USER_SERVICE + "SendConfirmationCode";
    public static final String VERIFY_CONFORMATION_CODE_FOR_RESET_PASSWORD = BASE_URL + USER_SERVICE + "CheckConfirmationCode/{MobileNumber}/{OTPCode}";
    public static final String GET_HISTORY_API = BASE_URL + HISTORY_SERVICES + "GetAllPastOrders/{PageIndex}/{PageSize}";
    public static final String GET_CECKEDOUT_API = BASE_URL + CHECKED_SERVICE + "UpdateCheckOut";

    public static final String DRIVER_ACCOUNT_ACTIVATE_URL = USER_SERVICE + "ActivateAccount";
  /*  public static final String VERIFY_CONFORMATION_CODE_FOR_RESET_PASSWORD = USER_SERVICE +
            "CheckConfirmationCode/{mobile_number_otp}";*/
    public static final String RESET_PASSWORD_URL = USER_SERVICE + "UpdateUserPassword";
    public static final String RESEND_OTP_URL = USER_SERVICE + "SendConfirmationCode";
    public static final String GET_DRIVER_PROFILE = DRIVER_SERVICES + "FindDriverProfile";
    public static final String UPDATE_ADDRESS_URL = USER_SERVICE + "UpdateAdress";
    public static final String GET_ADDRESS_DETAILS_URL = USER_SERVICE + "FindByID";
    public static final String FIND_ALL_COUNTRIES_URL = COUNTRY_SERVICE + "FindAllItems";
    public static final String FIND_CITY_BY_ID = CITY_SERVICE + "FindByCountryID/{country_id}";
    public static final String FIND_BLOCK_BY_CITY_ID = BLOCK_SERVICE + "FindByCityID/{city_id}";
    public static final String GET_VEHICLE_TYPE_URL = VEHICLE_TYPE_SERVICE + "FindAllItems";
    public static final String GET_VEHICLE_MANUFACTURER_URL = VEHICLE_MANUFACTURES_SERVICE + "FindAllItems";
    public static final String GET_VEHICLE_MODEL_URL = VEHICLE_MODEL_TYPE_SERVICE +
            "FindByVehicleManufacturerId/{manufacturerTypeId}";
    public static final String ADD_DRIVER_DOCS_URL = DRIVER_SERVICES + "Add";
    public static final String GET_DRIVER_DOCS_URL = DRIVER_SERVICES + "FindByID/{driver_id}";
    public static final String UPDATE_DRIVER_DOCS_URL = DRIVER_SERVICES + "UpdateDriverProfile";
    public static final String GET_ALL_BANKS_URL = BANK_SERVICES + "FindAllItems";
    public static final String ADD_BANK_DETAILS_URL = BANK_ACCOUNT_SERVICE + "Add";
    public static final String GET_BANK_DETAILS_URL = BANK_ACCOUNT_SERVICE + "FindByDriverId/{driver_id}";
    public static final String UPDATE_BANK_DETAILS_URL = BANK_ACCOUNT_SERVICE + "Update";
    public static final String ADD_VEHICLE_DETAILS_URL = VEHICLE_SERVICE + "AddVehicleDetails";
    public static final String UPDATE_VEHICLE_DETAILS_URL = VEHICLE_SERVICE + "UpdateVehicleDetails";
    public static final String GET_VEHICLE_DETAILS_URL = VEHICLE_SERVICE + "FindByID/{vehicle_id}";
    public static final String UPDATE_VEHICLE_DOCS_URL = VEHICLE_SERVICE + "UpdateVehicleDocuments";
    public static final String GET_ORDER_ASSIGNMENT_DATA_URL = DELIVERY_ORDER_ASSIGNMENT_SERVICE + "FindByDriverId";
    public static final String GET_ORDER_ACCEPTED = DELIVERY_ORDER_ASSIGNMENT_SERVICE + "DriverAcceptPickup";
    public static final String GET_ORDER_LIST = "Api/DeliveryOrderDeliveryRequestService/FindByOrderId";
    public static final String GET_REASONS_FOR_CANCEL = "Api/ReasonCodeService/FindAllItems";
    public static final String SET_ELAPSED_TIMER_FOR_DRIVER = DELIVERY_ORDER_ASSIGNMENT_SERVICE + "DriverTimeElapsedfororder";
    public static final String UPDATE_REJECTED_REASON = DELIVERY_ORDER_ASSIGNMENT_SERVICE + "DriverRejectPickup";
    public static final String UPDATE_REJECTED_REASON_NEW = "Api/DeliveryRequestService/RejectDeliveryRequests";
    public static final String UPDATE_ACCEPTED_ORDER = DELIVERY_ORDER_ASSIGNMENT_SERVICE + "DriverAcceptPickup";
    public static final String UPDATE_LANGUAGE_PREF_URL = USER_SERVICE + "UpdateLanguage";
    public static final String UPLOAD_ITEM_IMAGE = "Api/DeliveryRequestImageService/AddDeliveryRequestImage";
    public static final String UPDATE_SIGNUP_URL = USER_SERVICE + "UpdateSignup";
    public static final String GET_TOKEN = "token";
    public static final String UPDATE_ONLINE_OFFLINE_STATUS = DRIVER_TRACKING_SERVICE + "TooggleDriverStatus";
    public static final String GET_HISTORY_DETAILS_API = DRIVER_SERVICES + "FindDriverHistory";
    public static final String GET_COMPANY_BANK_DETAILS = "Api/NDPBankAccountsService/FindAllItems";

    public static final String CREATE_SEGMENTS = "Api/OrderTripMasterService/Add";
    public static final String ADD_TRIP_TRACKING = "Api/OrderTripDriverTrackingService/Add";
    public static final String UPDATE_SEGMENT_START = "Api/OrderTripSegmentService/UpdateTripSegmentStart";
    public static final String UPDATE_SEGMENT_END = "Api/OrderTripSegmentService/UpdateTripSegmentEnd";
    public static final String GET_SEGMENT = "Api/OrderTripMasterService/OrderTripDetails/{order_id}";
    public static final String ONLY_ITEM_PICKEDUP_IMAGE = "Api/ImageService/DeliveryRequestItemImageFindByStreamID/{stream_id}";

    public static final int RESPONSE_SUCCESS = 0;
    public static final int RESPONSE_FAILURE = 1;
    public static final int RESPONSE_NOT_ACTIVE = 2;
    public static final int RESPONSE_NO_DATA_FOUND = 3;

    public static final String DELIVERY_CONFIRMATION_OTP = "Api/DeliveryRequestService/CheckDeliveryConfirmationOTP";
    public static final String SEND_DELIVERY_OTP = "Api/DeliveryRequestService/SendDeliveryConfirmationOTP";

    public static final String PREFERED_BANK_URL = "Api/NDPBankAccountsService/FindByDriver";

    public static final String PAYMENT_SUMMARY_URL = "Api/DriverPaymentSummaryService/PaymentSummary";
    public static final String DRIVER_PREFERENCE = "Api/DriverTrackingService/FindDriverPreferences";
    public static final String MODIFY_DRIVER_PREFERENCE = "Api/DriverTrackingService/UpdateDriverPreferences";
    public static final String ORDER_SEQUENCE = "Api/OrderTripMasterService/OrderTripDetails/{order_id}";

    public static final String UPDATE_ORDER = "Api/OrderTripSegmentService/FindByID/{id}";
    public static final String GET_REASONS_BY_TYPE = "Api/ReasonCodeService/FindByReasonsCodeTypeId/{type_id}";
    public static final String GET_CANCEL_DELIVERY = " Api/DeliveryRequestReturnedReasonsService/FindAllItems";

    public static final String GET_ORDER_COD_LIST = "api/DeliveryOrderDeliveryRequestService/CurrentOrderTotalCOD";


}
