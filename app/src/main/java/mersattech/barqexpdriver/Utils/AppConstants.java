package mersattech.barqexpdriver.Utils;

public class AppConstants {

    public static final String LANGUAGE_SELECTED_KEY = "lang";
    public static final String ENGLISH_LANG = "en";
    public static final String ARABIC_LANG = "ar";
    public static final String RESTRATION_PROGRESS_KEY = "registration_progress";
    public static final String IS_REGISTRATION_COMPLETED = "isRegistrationDone";
    public static final String IS_FROM_REGISTRATION = "isFromRegistration";
    public static final int CAMERA_PERMISSION = 100;
    public static final int CAMERA_PERMISSION_SCAN_BUTTON = 101;
    public static final int LOCATION = 200;
    public static final String USER_ID = "USER_ID";
    public static final String IS_FROM_OTP = "isFromOP";
    public static final String COMPLETED_SCREENS = "completedScreens";
    public static final int SIGNUP_SCREEN = 1;
    public static final int OTP_SCREEN = 2;
    public static final int ADDRESS_SCREEN = 3;
    public static final int DRIVER_DOC = 4;
    public static final int VEHICLE_DETAILS = 5;
    public static final int INSURANCE_DETAILS = 6;
    public static final int BANK_DETAILS = 7;
    public static final String DRIVER_ID = "driver_id";
    public static final String TOKEN = "token";
    public static final String TOKEN_TYPE = "token_type";
    public static final String PHONE_NUMBER = "user_phone_number";
    public static final String BANK_ID = "bank_id";
    public static final String VEHICLE_ID = "vehicle_id";
    public static final int IS_DELIVERY_PROCESS = 100;
    public static final int UPDATE_INTERVAL = 3000; // 3 sec
    public static final int FATEST_INTERVAL = 1000; // 5 sec
    public static final int DISPLACEMENT = 10; // 10 meters
    public static final String LANGUAGE_CHANGE_INTERFACE = "language_change_interface";
    public static final String LANGUAGE_SELECTED = "language_selected";

    public static final String POSITION = "position";
    public static final String FROM_LOGIN = "fromLogin";
    public static final String IS_FROM_FORGOT_PASS = "isFromForgotPassword";
    public static final String MOBILE_NUM = "mobile_number";
    public static final String IS_FROM_RESET_PASS_SCREEN = "isFromResetPassScreen";

    public static final String IS_VALID = "isValid";
    public static final String IS_ONLINE = "IsOnline";
    public static final int LANGUAGE_CHANGED = 1002;

    public static final String NAME = "name";

    public class ProfileConstants {

        public static final int MY_DETAILS = 0;
        public static final int ADDRESS_DETAILS = 1;
        public static final int DRIVER_ITENDITY_DETAILS = 2;
        public static final int VEHICLE_DETAILS = 3;
        public static final int INSURANCE_LICENSE_DETAILS = 4;
        public static final int BANK_DETAILS = 5;

    }

    public class MenuItemConstants {

        public static final int ORDERSLIST = 0;
        public static final int PROFILE_DETAILS = 1;
        public static final int HISTORY = 2;

        public static final int COMPANY_ACCOUNT_DETAILS = 2;
        public static final int VIEW_PAYMENTS = 3;
        public static final int CALL_OPERATOR = 4;

        public static final int RESET_PASSWORD = 3;
        public static final int SETTINGS = 4;
        public static final int LOGOUT = 5;

       // public static final int HELP = 7;
       // public static final int LOGOUT = 4;
    }

    public class OrderListItemStatus {
        public static final int ASSIGNED_TO_DRIVER = 12;
        public static final int PICKED_UP = 13;
        public static final int OUT_FOR_DELIVERY = 14;
        public static final int DELIVERED = 15;
        public static final int FAILED = 16;
        public static final int DELIVERY_PROCESS_TERMINATED = 17;
        public static final int RECEIVER_RE_ASSIGNMENT_IN_PROGRESS = 18;
        public static final int NEW_RECEIVER_ACKNOWLEDGED = 19;
        public static final int CLOSED = 20;
    }

    public class ReasonsType {
        public static final int TRIP_CANCELLATION = 1;
        public static final int DELIVERY_REQUEST_CANCELLATION = 1;
        public static final int OFFLINE = 3;
        public static final int CANCEL_DELIVERY = 4;
    }

}
