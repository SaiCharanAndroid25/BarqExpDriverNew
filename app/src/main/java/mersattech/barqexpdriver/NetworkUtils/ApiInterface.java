package mersattech.barqexpdriver.NetworkUtils;

import java.util.HashMap;

import mersattech.barqexpdriver.Models.s.CODAmount.CurrentOrderCODResponse;
import mersattech.barqexpdriver.Models.s.CancelReasons.CancelReasonResponse;
import mersattech.barqexpdriver.Models.s.Checkedout.ItemCheckedOutRequestBody;
import mersattech.barqexpdriver.Models.s.CurrentOrders.CurrentOrderResponse;
import mersattech.barqexpdriver.Models.s.DriverProfile.DriverProfileResponse;
import mersattech.barqexpdriver.Models.s.Driveractivestatus.IsDriverActiveStatusRequest;
import mersattech.barqexpdriver.Models.s.Driveractivestatus.IsDriverActiveStatusResponse;
import mersattech.barqexpdriver.Models.s.ForgotPassword.ForgotPasswordModel;
import mersattech.barqexpdriver.Models.s.ForgotPassword.ForgotPasswordRequestModel;
import mersattech.barqexpdriver.Models.s.HistoryPackage.HistoryResponse;
import mersattech.barqexpdriver.Models.s.Itemdeliver.ItemDeliveredRequestbody;
import mersattech.barqexpdriver.Models.s.Itemdeliver.ItemDeliveredResponsebody;
import mersattech.barqexpdriver.Models.s.Location.LocationRequestbody;
import mersattech.barqexpdriver.Models.s.Location.LocationResponsebody;
import mersattech.barqexpdriver.Models.s.LoginModel.DriverLoginRequestModel;
import mersattech.barqexpdriver.Models.s.LoginModel.DriverRegistrationModel;
import mersattech.barqexpdriver.Models.s.LoginModel.FindCityResponseModel;
import mersattech.barqexpdriver.Models.s.LoginModel.LanguageUpdateRequestBody;
import mersattech.barqexpdriver.Models.s.LoginModel.TokenResponse;
import mersattech.barqexpdriver.Models.s.ModifyPreference.ModifyPreferenceRequestBody;
import mersattech.barqexpdriver.Models.s.ModifyPreference.ModifyPreferenceResponseBody;
import mersattech.barqexpdriver.Models.s.OrderSequence.OrderSequenceResponseBody;
import mersattech.barqexpdriver.Models.s.Orderaccept.OrderAcceptRequestBody;
import mersattech.barqexpdriver.Models.s.Orderaccept.OrderAcceptResponseBody;
import mersattech.barqexpdriver.Models.s.Orders.OderRejectRequestModel;
import mersattech.barqexpdriver.Models.s.Orders.OrderAssignmentService;
import mersattech.barqexpdriver.Models.s.OrdersList.OrderListResponseModel;
import mersattech.barqexpdriver.Models.s.OtpResponse.OtpResponseModel;
import mersattech.barqexpdriver.Models.s.PickedupImage.PickedUpImageResponse;
import mersattech.barqexpdriver.Models.s.Preferences.PreferenceResponseBody;
import mersattech.barqexpdriver.Models.s.Registration.Driverprofile.GetDriverProfileResponse;
import mersattech.barqexpdriver.Models.s.ResetPassword.DriverActivateAccRequestModel;
import mersattech.barqexpdriver.Models.s.ResetPassword.ResetPasswordModel;
import mersattech.barqexpdriver.Models.s.ResetPassword.ResetPasswordRequestModel;
import mersattech.barqexpdriver.Models.s.Triptracking.TripTrackingRequestBody;
import mersattech.barqexpdriver.Models.s.Triptracking.TripTrackingResponse;
import mersattech.barqexpdriver.Models.s.Updateendtrip.UpdateEndTripRequest;
import mersattech.barqexpdriver.Models.s.Updateendtrip.UpdateEndTripResponse;
import mersattech.barqexpdriver.Models.s.Updatestarttrip.UpdateStartTripRequestBody;
import mersattech.barqexpdriver.Models.s.Updatestarttrip.UpdateStartTripResponse;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.appSettingFromApi.ElapsedTimerRequestBody;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.appSettingFromApi.ElapsedTimerResponse;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.imageUpload.ImageUploadResponseModel;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.itemPickup.ItemPickupRequestBody;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.itemPickup.ItemPickupResponse;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.reasonCode.ReasonCodeListModel;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public  interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.DRIVER_LOGIN_URL)
    Call<DriverRegistrationModel> loginDriver(@Body DriverLoginRequestModel driverLoginRequestModel);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.FORGOT_PASSWORD_URL)
    Call<ForgotPasswordModel> forgotloginDriver(@Body ForgotPasswordRequestModel driverforgotpwdRequestModel);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.Reset_PASSWORD_URL)
    Call<ResetPasswordModel> resetpasswordDriver(@Body ResetPasswordRequestModel driverresetpwdRequestModel);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.RESENDOTP_URL)
    Call<OtpResponseModel> verifyOtpDriver(@Body DriverActivateAccRequestModel driverresetpwdRequestModel);

    @GET(NetworkConstants.VERIFY_CONFORMATION_CODE_FOR_RESET_PASSWORD)
    Call<OtpResponseModel> verifyConfirmationCode(@Path("MobileNumber") String mobile,@Path("OTPCode") String mobile_otp);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.RESEND_OTP_URL)
    Call<OtpResponseModel> resendOtp(@Body ForgotPasswordRequestModel forgotPasswordRequestModel);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(NetworkConstants.GET_TOKEN)
    Call<TokenResponse> getTokenResponse(
            @FieldMap(encoded = true) HashMap<String, String> map);

    @GET(NetworkConstants.DRIVER_PREFERENCE)
    Call<PreferenceResponseBody> getPreferences(@Header("authorization") String auth);

    @POST(NetworkConstants.MODIFY_DRIVER_PREFERENCE)
    Call<ModifyPreferenceResponseBody> updatePreferences(@Header("authorization") String auth ,
                                                         @Body ModifyPreferenceRequestBody modifyPreferenceRequestBody);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.UPDATE_LANGUAGE_PREF_URL)
    Call<DriverRegistrationModel> setLanguagePref(@Header("authorization") String auth,
                                                  @Body LanguageUpdateRequestBody requestBody);

    @GET(NetworkConstants.FIND_CITY_BY_ID)
    Call<FindCityResponseModel> getCityListByCountryId(@Header("authorization") String auth, @Path("country_id") int countryId);

    @GET(NetworkConstants.GET_ORDER_LIST)
    Call<CurrentOrderResponse> getOrderList(@Header("authorization") String auth);

    @GET(NetworkConstants.GET_ORDER_COD_LIST)
    Call<CurrentOrderCODResponse> getOrderCODList(@Header("authorization") String auth);

    @GET(NetworkConstants.GET_ORDER_ASSIGNMENT_DATA_URL)
    Call<OrderAssignmentService> getOrderAssignmentDetails(@Header("authorization") String auth);

    @GET(NetworkConstants.ORDER_SEQUENCE)
    Call<OrderSequenceResponseBody> getOrderSequence(@Header("authorization") String auth, @Path("order_id")
            int orderId);


    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.DRIVER_TRACKING_ADD)
    Call<LocationResponsebody> addLocation(@Header("authorization") String auth,
                                           @Body LocationRequestbody requestBody);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.ADD_TRIP_TRACKING)
    Call<TripTrackingResponse> addTripTracking(@Header("authorization") String auth,
                                               @Body TripTrackingRequestBody requestBody);

    @GET(NetworkConstants.GET_REASONS_BY_TYPE)
    Call<CancelReasonResponse> getReasonCodesByType(@Header("authorization") String auth, @Path("type_id") int typeId);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.UPDATE_REJECTED_REASON_NEW)
    Call<OrderAssignmentService> updateOderRejectedReason(@Header("authorization") String auth,
                                                          @Body OderRejectRequestModel requestBody);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.UPDATE_ACCEPTED_ORDER)
    Call<OrderAcceptResponseBody> orderAccepted(@Header("authorization") String auth,
                                                @Body OrderAcceptRequestBody requestBody);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.SET_ELAPSED_TIMER_FOR_DRIVER)
    Call<ElapsedTimerResponse> setElapsedTimerResponse(@Header("authorization") String auth,
                                                       @Body ElapsedTimerRequestBody setElapsedTimerRequestBody);

    @POST(NetworkConstants.UPDATE_SEGMENT_START)
    Call<UpdateStartTripResponse> updateStartTrip(@Header("authorization") String auth,
                                                  @Body UpdateStartTripRequestBody startRequestBody);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.UPDATE_ONLINE_OFFLINE_STATUS)
    Call<IsDriverActiveStatusResponse> isDriverActive(@Header("authorization") String auth,
                                                      @Body IsDriverActiveStatusRequest requestBody);

    @POST(NetworkConstants.UPDATE_SEGMENT_END)
    Call<UpdateEndTripResponse> updateEndTrip(@Header("authorization") String auth,
                                              @Body UpdateEndTripRequest startRequestBody);

    @GET(NetworkConstants.GET_DRIVER_PROFILE)
    Call<DriverProfileResponse> getDRiverProfile(@Header("authorization") String auth);

    ///////
    @GET(NetworkConstants.IMAGE_RETROFIT_SERVICE)
    Call<ResponseBody> getImage(@Path("imageId") String imageId);

    @GET(NetworkConstants.GET_HISTORY_API)
    Call<HistoryResponse> getHistoryDetails(@Header("authorization") String auth, @Path("PageIndex") int pageindex, @Path("PageSize") int pagesize);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.ITEM_PICKUPED_UP)
    Call<ItemPickupResponse> setItemPickedUp(@Header("authorization") String auth,
                                             @Body ItemPickupRequestBody requestBody);

    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.ITEM_DELIVERED)
    Call<ItemDeliveredResponsebody> setItemDelivered(@Header("authorization") String auth,
                                                     @Body ItemDeliveredRequestbody deliveryRequestBody);

    //// TODO: 07-12-2017 - change the call<Type>
    @Multipart
    @POST(NetworkConstants.UPLOAD_ITEM_IMAGE)
    Call<ImageUploadResponseModel> uploadImage(@Header("authorization") String auth,
                                               @Part MultipartBody.Part image,
                                               @Part("deliveryrequestid") RequestBody deliveryrequestid,
                                               @Part("deliveryrequestitemid") RequestBody deliveryrequestitemid,
                                               @Part("is_delivered_image") RequestBody booleanrequest);

    @GET(NetworkConstants.ITEM_PICKEDUP_IMAGE_ID)
    Call<PickedUpImageResponse> getPickedImageID(@Header("authorization") String auth, @Path("item_id") String itemid);

    @GET(NetworkConstants.ONLY_ITEM_PICKEDUP_IMAGE)
    Call<ResponseBody> getItemPickedUpImage(@Path("stream_id") String imageId);

    @GET(NetworkConstants.ITEM_PICKEDUP_IMAGE)
    Call<ResponseBody> getPickedUpImage(@Path("stream_id") String imageId);


    @Headers("Content-Type: application/json")
    @POST(NetworkConstants.GET_CECKEDOUT_API)
    Call<ItemPickupResponse> getCheckedOut(@Header("authorization") String auth,
                                             @Body ItemCheckedOutRequestBody requestBody);





}
