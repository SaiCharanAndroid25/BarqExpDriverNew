package mersattech.barqexpdriver.Activities.Pickoupcheckout;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.google.gson.GsonBuilder;
import com.google.zxing.Result;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import id.zelory.compressor.Compressor;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Activities.Login.SplashScreen;
import mersattech.barqexpdriver.Fragments.HomePageFragment;
import mersattech.barqexpdriver.Models.s.CurrentOrders.CurrentOrderResponse;
import mersattech.barqexpdriver.Models.s.CurrentOrders.DeliveryRequestDetail;
import mersattech.barqexpdriver.Models.s.CurrentOrders.DeliveryRequestItem;
import mersattech.barqexpdriver.Models.s.Itemdeliver.ItemDeliveredRequestbody;
import mersattech.barqexpdriver.Models.s.Itemdeliver.ItemDeliveredResponsebody;
import mersattech.barqexpdriver.Models.s.OrdersList.CurrentPickup;
import mersattech.barqexpdriver.Models.s.OrdersList.DeliveryRequestEntity;
import mersattech.barqexpdriver.Models.s.PickedupImage.PickedUpImageResponse;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.imageUpload.ImageUploadResponseModel;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.itemPickup.ItemPickupRequestBody;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.itemPickup.ItemPickupResponse;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.NewAppArrayList;
import mersattech.barqexpdriver.databinding.ActivityScanQrnImagescreenBinding;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static mersattech.barqexpdriver.Fragments.HomePageFragment.cancel_btn;
import static mersattech.barqexpdriver.Fragments.HomePageFragment.deliver_btn;


public class ScanQRnImagescreen extends BaseActivity implements ZXingScannerView.ResultHandler {

    private ActivityScanQrnImagescreenBinding mActivityScanQrnImagescreenBinding;
    private View.OnClickListener mOnClickListener;
    private int clickedphoto_id;
    private boolean photoScanned1, photoScanned2, photoScanned3, photoScanned4, qRScanned;
    private boolean mIsFromStartDelivery;
    private int mItemId, mDeliveryReqID, mItemIndex;
    private Call<ImageUploadResponseModel> mPhotoUpload;
    private Call<ItemPickupResponse> mItemPickupResponseCall;
    private Call<ItemDeliveredResponsebody> mItemDeliveredResponseCall;
    private Call<PickedUpImageResponse> mPickedUpImageResponseCall;
  //  private ProgressDialog mProgressDialog;
    private ImagePopup imagePopup;
    private String mAuth;
    int i;
    int i1;
    int deliverybutton_position;
    SharedPreferences getPref;
    java.util.ArrayList<DeliveryRequestDetail> entity;
    String Deliver_code;


    public ScanQRnImagescreen() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityScanQrnImagescreenBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_scan_qrn_imagescreen);
        imagePopup = new ImagePopup(ScanQRnImagescreen.this);
        mAuth = getToken(ScanQRnImagescreen.this);

        Deliver_code = getIntent().getStringExtra("Deliver_Code");

        if(Deliver_code.equals(3)){
            Deliver_code = "3";
        }if(Deliver_code.equals(4)){
            Deliver_code = "4";
        }


        if (getIntent() != null)
            mIsFromStartDelivery = getIntent().getBooleanExtra("isFromStartDelivery", false);
        imagePopup.setWindowHeight(800); // Optional
        imagePopup.setWindowWidth(800); // Optional
        imagePopup.setBackgroundColor(Color.BLACK);  // Optional
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);
        final Intent intent = getIntent();

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.upload_button:
                        {
                                if (Deliver_code.equals("4")) {
                                    //   mProgressDialog = getProgressDialog(ScanQRnImagescreen.this);
                                    mItemDeliveredResponseCall = NetworkUtils.getApiInterface().
                                            setItemDelivered("bearer " + mAuth, requestbodyfordelivered());

                                    if (NetworkUtils.getInstance().isNetworkAvailable(ScanQRnImagescreen.this)) {
                                        mItemDeliveredResponseCall.enqueue(new Callback<ItemDeliveredResponsebody>() {
                                            @Override
                                            public void onResponse(Call<ItemDeliveredResponsebody> call,
                                                                   Response<ItemDeliveredResponsebody> response) {
                                                ItemDeliveredResponsebody itemDeliverResponse = response.body();
                                                if (itemDeliverResponse != null) {
                                                    // mProgressDialog.dismiss();
                                                    switch (itemDeliverResponse.getStatus()) {

                                                        case NetworkConstants.RESPONSE_SUCCESS: {
                                                  /*  CurrentPickup.getInstance().
                                                            getDeliveryRequestItemEntities().get(mItemIndex).setIsPickedUp(true);*/
                                                            Toast.makeText(ScanQRnImagescreen.this,
                                                                    "Item Delivered Succesfully",
                                                                    Toast.LENGTH_SHORT).show();
                                                            deliver_btn.setVisibility(View.GONE);
                                                            cancel_btn.setVisibility(View.GONE);
                                                            onBackPressed();

                                                            HomePageFragment.callCurrentOrderApi();
                                                        }
                                                    }
                                                } else {
                                                    Toast.makeText(ScanQRnImagescreen.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<ItemDeliveredResponsebody> call, Throwable t) {
                                                //   mProgressDialog.dismiss();
                                            }
                                        });
                                    }
                                } else {
                                    //   mProgressDialog = getProgressDialog(ScanQRnImagescreen.this);
                                    mItemPickupResponseCall = NetworkUtils.getApiInterface().
                                            setItemPickedUp("bearer " + mAuth, requestbodyforpickup());

                                    if (NetworkUtils.getInstance().isNetworkAvailable(ScanQRnImagescreen.this)) {
                                        mItemPickupResponseCall.enqueue(new Callback<ItemPickupResponse>() {
                                            @Override
                                            public void onResponse(Call<ItemPickupResponse> call,
                                                                   Response<ItemPickupResponse> response) {
                                                ItemPickupResponse itemPickupResponse = response.body();
                                                if (itemPickupResponse != null) {
                                                    // mProgressDialog.dismiss();
                                                    switch (itemPickupResponse.getStatus()) {

                                                        case NetworkConstants.RESPONSE_SUCCESS: {
                                                  /*  CurrentPickup.getInstance().
                                                            getDeliveryRequestItemEntities().get(mItemIndex).setIsPickedUp(true);*/
                                                            Toast.makeText(ScanQRnImagescreen.this,
                                                                    "Item PickedUp Succesfully",
                                                                    Toast.LENGTH_SHORT).show();

                                                            HomePageFragment.callCurrentOrderApi();

                                                            onBackPressed();

                                                        }
                                                    }
                                                } else {
                                                    Toast.makeText(ScanQRnImagescreen.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<ItemPickupResponse> call, Throwable t) {
                                                //   mProgressDialog.dismiss();
                                            }
                                        });
                                    } else {
                                        // mProgressDialog.dismiss();
                                        Toast.makeText(ScanQRnImagescreen.this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
                                    }
                                }

                        }
                        break;

                    case R.id.back_icon:
                        ScanQRnImagescreen.super.onBackPressed();
                        break;
                    case R.id.upload_img1:
                        if (!photoScanned1) {
                            clickedphoto_id = v.getId();
                            checkPermissions(ScanQRnImagescreen.this, android.Manifest.permission.CAMERA, null, true);
                        } else {
                            imagePopup.initiatePopup(mActivityScanQrnImagescreenBinding.uploadImg1.getDrawable());
                            imagePopup.viewPopup();
                        }
                        break;
                    case R.id.upload_img2:
                        if (!photoScanned2) {
                            clickedphoto_id = v.getId();
                            checkPermissions(ScanQRnImagescreen.this, android.Manifest.permission.CAMERA, null, true);
                        }
                        else {
                            imagePopup.initiatePopup(mActivityScanQrnImagescreenBinding.uploadImg2.getDrawable());
                            imagePopup.viewPopup();
                        }
                        break;
                    case R.id.upload_img3:
                        if (!photoScanned3) {
                            clickedphoto_id = v.getId();
                            checkPermissions(ScanQRnImagescreen.this, android.Manifest.permission.CAMERA, null, true);
                        }
                        else {
                            imagePopup.initiatePopup(mActivityScanQrnImagescreenBinding.uploadImg3.getDrawable());
                            imagePopup.viewPopup();
                        }
                        break;
                    case R.id.upload_img4:
                        if(!photoScanned4) {
                            clickedphoto_id = v.getId();
                            checkPermissions(ScanQRnImagescreen.this, android.Manifest.permission.CAMERA, null, true);
                        }else
                        {
                            imagePopup.initiatePopup(mActivityScanQrnImagescreenBinding.uploadImg4.getDrawable());
                            imagePopup.viewPopup();
                        }
                        break;
                    case R.id.picked_image1:
                        imagePopup.initiatePopup(mActivityScanQrnImagescreenBinding.pickedImage1.getDrawable());
                        imagePopup.viewPopup();

                        break;
                    case R.id.picked_image2:

                        imagePopup.initiatePopup(mActivityScanQrnImagescreenBinding.pickedImage2.getDrawable());
                        imagePopup.viewPopup();

                        break;
                    case R.id.picked_image3:

                        imagePopup.initiatePopup(mActivityScanQrnImagescreenBinding.pickedImage3.getDrawable());
                        imagePopup.viewPopup();

                        break;
                    case R.id.picked_image4:

                        imagePopup.initiatePopup(mActivityScanQrnImagescreenBinding.pickedImage4.getDrawable());
                        imagePopup.viewPopup();

                        break;
                }
            }

            private ItemPickupRequestBody requestbodyforpickup() {
                ItemPickupRequestBody itemPickupRequestBody = new ItemPickupRequestBody();
                itemPickupRequestBody.setID(mItemId);
                itemPickupRequestBody.setDeliveryRequestId(mDeliveryReqID);
                itemPickupRequestBody.setDeliveryOrderId(NewAppArrayList.
                        getInstance().getOrderListResponseModels().getEntity().getID());
                return itemPickupRequestBody;
            }

            private ItemDeliveredRequestbody requestbodyfordelivered() {
                ItemDeliveredRequestbody itemDeliverRequestBody = new ItemDeliveredRequestbody();
                itemDeliverRequestBody.setID(mItemId);
                return itemDeliverRequestBody;
            }
        };

        registerViewListeners();
    }

    private ItemDeliveredRequestbody deliveryRequestBody() {
        ItemDeliveredRequestbody itemDeliveredRequestbody = new ItemDeliveredRequestbody();
        itemDeliveredRequestbody.setID(mItemId);
        return itemDeliveredRequestbody;
    }

    private void registerViewListeners() {
        mActivityScanQrnImagescreenBinding.uploadButton.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.prodImgUploadRecycler.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.uploadImg1.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.uploadImg2.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.uploadImg3.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.uploadImg4.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.pickedImage1.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.pickedImage2.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.pickedImage3.setOnClickListener(mOnClickListener);
        mActivityScanQrnImagescreenBinding.pickedImage4.setOnClickListener(mOnClickListener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityScanQrnImagescreenBinding.unbind();
    }

    @Override
    public void onBackPressed() {
        /*if (mIsFromStartDelivery) {
            Intent returnIntent = new Intent();
            setResult(AppConstants.IS_DELIVERY_PROCESS, returnIntent);
        }*/
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register ourselves as a handler for scan results.
        mActivityScanQrnImagescreenBinding.idPhotoTv.setResultHandler(this);
        // Start camera on resume
        mActivityScanQrnImagescreenBinding.idPhotoTv.startCamera();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
                e.printStackTrace();
            }

            @Override
            public void onImagePicked(File file, EasyImage.ImageSource imageSource, int i) {
                try {
                    onPhotosReturned(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {
                //Cancel handling, you might wanna remove taken photo if it was canceled
                if (source == EasyImage.ImageSource.CAMERA) {
                    File photoFile = EasyImage.lastlyTakenButCanceledPhoto(ScanQRnImagescreen.this);
                    if (photoFile != null) photoFile.delete();
                }
            }
        });
    }


    private void onPhotosReturned(File returnedPhotos) throws IOException {

        returnedPhotos = new Compressor(this).compressToFile(returnedPhotos);

        switch (clickedphoto_id) {

            case R.id.upload_img1:

                Picasso.with(getApplicationContext()).load(returnedPhotos).resize(150, 150).centerCrop().into(mActivityScanQrnImagescreenBinding.uploadImg1);
                mActivityScanQrnImagescreenBinding.uploadImg1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                photoScanned1 = true;

                callPhotoUpload(returnedPhotos);
                checkFinishbutton();

                break;
            case R.id.upload_img2:

                Picasso.with(getApplicationContext()).load(returnedPhotos).resize(150, 150).centerCrop().into(mActivityScanQrnImagescreenBinding.uploadImg2);
                photoScanned2 = true;
                mActivityScanQrnImagescreenBinding.uploadImg2.setScaleType(ImageView.ScaleType.CENTER_CROP);

                checkFinishbutton();

                break;
            case R.id.upload_img3:
                Picasso.with(getApplicationContext()).load(returnedPhotos).resize(150, 150).centerCrop().into(mActivityScanQrnImagescreenBinding.uploadImg3);
                photoScanned3 = true;
                mActivityScanQrnImagescreenBinding.uploadImg3.setScaleType(ImageView.ScaleType.CENTER_CROP);

                checkFinishbutton();

                break;
            case R.id.upload_img4:
                Picasso.with(getApplicationContext()).load(returnedPhotos).resize(150, 150).centerCrop().into(mActivityScanQrnImagescreenBinding.uploadImg4);
                photoScanned4 = true;
                mActivityScanQrnImagescreenBinding.uploadImg4.setScaleType(ImageView.ScaleType.CENTER_CROP);

                checkFinishbutton();

                break;

        }

        callPhotoUpload(returnedPhotos);

    }

    private void callPhotoUpload(File returnedPhotos) {
        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), returnedPhotos);
        MultipartBody.Part body = MultipartBody.Part.createFormData("DeliveryItemImage",
                returnedPhotos.getName(), reqFile);
        RequestBody deliveryrequestid = RequestBody.create(MediaType.parse("text/plain"),
                String.valueOf(mDeliveryReqID));
        RequestBody deliveryrequestitemid = RequestBody.create(MediaType.parse("text/plain"),
                String.valueOf(mItemId));
        RequestBody isDeliveryRequest = RequestBody.create(MediaType.parse("text/plain"),
                "false");
       /* mProgressDialog = getProgressDialog(ScanQRnImagescreen.this);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setMessage("Image Uploading....");*/


        isDeliveryRequest = RequestBody.create(MediaType.parse("text/plain"),
                    "false");

        mPhotoUpload = NetworkUtils.getApiInterface().uploadImage(mAuth, body, deliveryrequestid,
                deliveryrequestitemid, isDeliveryRequest);


        mPhotoUpload.enqueue(new Callback<ImageUploadResponseModel>() {
            @Override
            public void onResponse(Call<ImageUploadResponseModel> call, Response<ImageUploadResponseModel> response) {
                ImageUploadResponseModel responseModel = response.body();

                if (responseModel != null) {
                    switch (responseModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            Toast.makeText(ScanQRnImagescreen.this, "image uploaded", Toast.LENGTH_SHORT).show();
                          //  mProgressDialog.dismiss();
                            break;

                        default:
                            Toast.makeText(ScanQRnImagescreen.this, "image not uploaded", Toast.LENGTH_SHORT).show();
                            break;
                    }
                } else {
                  //  mProgressDialog.dismiss();
                    Toast.makeText(ScanQRnImagescreen.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
              //  mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ImageUploadResponseModel> call, Throwable t) {
                Toast.makeText(ScanQRnImagescreen.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
             //   mProgressDialog.dismiss();

            }
        });
    }


    private void checkFinishbutton() {
       // if (!getIntent().getBooleanExtra("isFromStartDelivery", true)) {
            if ((photoScanned1 || photoScanned2 || photoScanned3 || photoScanned4) && qRScanned) {
                mActivityScanQrnImagescreenBinding.uploadButton.setVisibility(View.VISIBLE);
                mActivityScanQrnImagescreenBinding.uploadButton.setEnabled(true);
            }
       // } else {
            if (photoScanned1 || photoScanned2 || photoScanned3 || photoScanned4) {
                mActivityScanQrnImagescreenBinding.uploadButton.setEnabled(true);
            }

      //  }

    }

    @Override
    public void handleResult(Result result) {
     //   Log.e("TAG", result.getText()); // Prints scan results
        // Prints the scan format (qrcode, pdf417 etc.)

        String str = result.getText();
        String field = str.replaceAll("http://", "");
       // Log.e("TAG", field);

        boolean isScanned = false;

         getPref = getSharedPreferences("Packagename", Context.MODE_PRIVATE);
         i = getPref.getInt("position",0);

         for ( i = 0 ; i < CurrentPickup.getInstance().getDeliveryRequestDetails().size(); i++) {
             Log.e("TAGG", String.valueOf(CurrentPickup.getInstance().getDeliveryRequestDetails().size()));
             Log.e("TAGG", String.valueOf(CurrentPickup.getInstance().getDeliveryRequestDetails().get(i).getDeliveryRequestItem().size()));
             for(i1 = 0 ; i1 <= CurrentPickup.getInstance().getDeliveryRequestDetails().get(i).getDeliveryRequestItem().size(); i1++){
                 try {
                     if (CurrentPickup.getInstance().getDeliveryRequestDetails().get(i)
                             .getDeliveryRequestItem()
                             .get(i1)
                             .getItemQRCode().equals(field)) {
                         mActivityScanQrnImagescreenBinding.scannedText.setVisibility(View.VISIBLE);
                         mActivityScanQrnImagescreenBinding.llForPhotos.setVisibility(View.VISIBLE);
                         mActivityScanQrnImagescreenBinding.addPhotoTv.setText("Capture Pickup Photos");
                         mActivityScanQrnImagescreenBinding.scannedText.setText(getResources().
                                 getText(R.string.scannedcode) + " " + result.getText());
                         mActivityScanQrnImagescreenBinding.idPhotoTv.setVisibility(View.GONE);
                         mActivityScanQrnImagescreenBinding.idPhotoTv.stopCamera();

                         qRScanned = true;
                         checkFinishbutton();

                         mItemId = CurrentPickup.getInstance().
                                 getDeliveryRequestDetails().get(i).getDeliveryRequestItem().get(i1).getID();
                         mItemIndex = i1;
                         mDeliveryReqID = CurrentPickup.getInstance().getDeliveryRequestDetails()
                                 .get(i).getDeliveryRequestItem().get(i1).getDeliveryRequestId();

                         Log.e("TAG", String.valueOf(mItemId));
                         Log.e("TAG", String.valueOf(mItemIndex));
                         Log.e("TAG", String.valueOf(mDeliveryReqID));

                         getproductdetail(mDeliveryReqID, mItemId);

                         isScanned = true;
                         break;
                     }
                 }catch (IndexOutOfBoundsException ioe){

                 }
             }

           }
        if (!isScanned) {
            Toast.makeText(this, "Please scan another QR code", Toast.LENGTH_SHORT).show();
        }

        mActivityScanQrnImagescreenBinding.idPhotoTv.resumeCameraPreview(this);

    }

    private void getImagesOfPickup() {
        if (NetworkUtils.getInstance().isNetworkAvailable(ScanQRnImagescreen.this)) {
            mPickedUpImageResponseCall = NetworkUtils.getApiInterface().getPickedImageID(mAuth, String.valueOf(mItemId));
            mPickedUpImageResponseCall.enqueue(new Callback<PickedUpImageResponse>() {
                @Override
                public void onResponse(Call<PickedUpImageResponse> call, Response<PickedUpImageResponse> response) {
                    PickedUpImageResponse pickedUpImageResponse = response.body();
                    if (pickedUpImageResponse != null) {
                        switch (pickedUpImageResponse.getStatus()) {
                            case 0:
                                setPickupImages(pickedUpImageResponse);
                                break;
                            default:
                       Toast.makeText(ScanQRnImagescreen.this, "No Images found", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    } else {
                        Toast.makeText(ScanQRnImagescreen.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<PickedUpImageResponse> call, Throwable t) {
                    Toast.makeText(ScanQRnImagescreen.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
        }
    }

    private void setPickupImages(PickedUpImageResponse pickedUpImageResponse) {

        for (int i = 0; i < pickedUpImageResponse.getList().size(); i++) {
            switch (i) {
                case 0:
                    pickedUpImage(pickedUpImageResponse.getList().get(0).getDeliveryItemImageStreamId(), 0);
                    break;
                case 1:
                    pickedUpImage(pickedUpImageResponse.getList().get(1).getDeliveryItemImageStreamId(), 1);
                    break;
                case 2:
                    pickedUpImage(pickedUpImageResponse.getList().get(2).getDeliveryItemImageStreamId(), 2);
                    break;
                case 3:
                    pickedUpImage(pickedUpImageResponse.getList().get(3).getDeliveryItemImageStreamId(), 3);
                    break;

            }

        }

    }

    private void pickedUpImage(String deliveryItemImageStreamId, final int str) {

        Call<ResponseBody> getPickedUpImage = NetworkUtils.getApiInterface().getPickedUpImage(deliveryItemImageStreamId);
        getPickedUpImage.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        byte[] bytes = response.body().bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        switch (str) {
                            case 0:
                                mActivityScanQrnImagescreenBinding.progressBarP1.setVisibility(View.GONE);
                                mActivityScanQrnImagescreenBinding.pickedImage1.setVisibility(View.VISIBLE);
                                mActivityScanQrnImagescreenBinding.pickedImage1.setImageBitmap(bitmap);
                                break;
                            case 1:
                                mActivityScanQrnImagescreenBinding.progressBarP2.setVisibility(View.GONE);
                                mActivityScanQrnImagescreenBinding.pickedImage2.setVisibility(View.VISIBLE);
                                mActivityScanQrnImagescreenBinding.pickedImage2.setImageBitmap(bitmap);
                                break;
                            case 2:
                                mActivityScanQrnImagescreenBinding.progressBarP3.setVisibility(View.GONE);
                                mActivityScanQrnImagescreenBinding.pickedImage3.setVisibility(View.VISIBLE);
                                mActivityScanQrnImagescreenBinding.pickedImage3.setImageBitmap(bitmap);
                                break;
                            case 3:
                                mActivityScanQrnImagescreenBinding.progressBarP4.setVisibility(View.GONE);
                                mActivityScanQrnImagescreenBinding.pickedImage4.setVisibility(View.VISIBLE);
                                mActivityScanQrnImagescreenBinding.pickedImage4.setImageBitmap(bitmap);
                                break;
                            default:
//                                Toast.makeText(ScanQRnImagescreen.this, "No Further Images Found", Toast.LENGTH_SHORT).show();
                                mActivityScanQrnImagescreenBinding.progressBarP1.setVisibility(View.GONE);
                                mActivityScanQrnImagescreenBinding.progressBarP2.setVisibility(View.GONE);
                                mActivityScanQrnImagescreenBinding.progressBarP3.setVisibility(View.GONE);
                                mActivityScanQrnImagescreenBinding.progressBarP4.setVisibility(View.GONE);

                                break;
                        }
                        mActivityScanQrnImagescreenBinding.progressBarP1.setVisibility(View.GONE);
                        mActivityScanQrnImagescreenBinding.progressBarP2.setVisibility(View.GONE);
                        mActivityScanQrnImagescreenBinding.progressBarP3.setVisibility(View.GONE);
                        mActivityScanQrnImagescreenBinding.progressBarP4.setVisibility(View.GONE);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(ScanQRnImagescreen.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(ScanQRnImagescreen.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getproductdetail(int deliveryRequestId, int id) {
        for (int i = 0; i < CurrentPickup.getInstance().getDeliveryRequestDetails().size(); i++) {
            if (CurrentPickup.getInstance().getDeliveryRequestDetails().get(getPref.getInt("position",0))
                    .getDeliveryRequestItem().get(i1).getDeliveryRequestId() == deliveryRequestId) {
                mActivityScanQrnImagescreenBinding.productDetails.setVisibility(View.VISIBLE);
                mActivityScanQrnImagescreenBinding.llForQRCode.setVisibility(View.GONE);
                mActivityScanQrnImagescreenBinding.llForPhotos.setVisibility(View.VISIBLE);
                mActivityScanQrnImagescreenBinding.uploadButton.setVisibility(View.VISIBLE);

                /*DeliveryRequestEntity entity  = NewAppArrayList.getInstance()
                        .getOrderListResponseModels1().getList().get(i).getDeliveryRequestEntity();*/

                 entity  = NewAppArrayList.getInstance()
                        .getOrderListResponseModels().getEntity().getDeliveryRequestDetails();

                java.util.ArrayList<DeliveryRequestDetail> entity1 =  CurrentPickup.getInstance().getDeliveryRequestDetails();

                mActivityScanQrnImagescreenBinding.senderName.setText(NewAppArrayList.getInstance().
                        getOrderListResponseModels().getEntity()
                        .getDeliveryRequestDetails().get(i).getDeliveryRequestItem().get(i).getItemName());

                mActivityScanQrnImagescreenBinding.senderPhone.setText(String.valueOf(NewAppArrayList.getInstance().
                        getOrderListResponseModels().getEntity()
                        .getDeliveryRequestDetails().get(i).getDeliveryRequestItem().get(i).getShipmentItemVolume()) + " kg");

               /* if(NewAppArrayList.getInstance().
                        getOrderListResponseModels().getEntity()
                        .getDeliveryRequestDetails().get(i).getDeliveryRequestItem().get(i).getGrossShipmentItemWeight() == 0) {
                   *//* mActivityScanQrnImagescreenBinding.senderPhone.setText(String.valueOf(NewAppArrayList.getInstance().
                            getOrderListResponseModels().getEntity()
                            .getDeliveryRequestDetails().get(i).getDeliveryRequestItem().get(i).getHeight()
                            * NewAppArrayList.getInstance().
                            getOrderListResponseModels().getEntity()
                            .getDeliveryRequestDetails().get(i).getDeliveryRequestItem().get(i).getWidth() *
                            NewAppArrayList.getInstance().
                                    getOrderListResponseModels().getEntity()
                                    .getDeliveryRequestDetails().get(i).getDeliveryRequestItem().get(i).getLength()) + " cc");*//*
                }*/

                for ( int j = 0; j < entity.size(); j++) {
                    if (entity.get(j).getDeliveryRequestItem().get(0).getID().equals(id)) {
                        mActivityScanQrnImagescreenBinding.itemPic.setVisibility(View.VISIBLE);
                        callItemImageLoader(entity.get(j).getDeliveryRequestItem().get(0).getDeliveryItemMainImageStreamId());
                    }
                }

                break;
            }
        }

    }

    private void callItemImageLoader(String streamId) {
        Call<ResponseBody> itemImageCall = NetworkUtils.getApiInterface().getItemPickedUpImage(streamId);

        itemImageCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        byte[] bytes = response.body().bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        mActivityScanQrnImagescreenBinding.itemPic.setImageBitmap(bitmap);
                        mActivityScanQrnImagescreenBinding.itemPic.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mActivityScanQrnImagescreenBinding.itemPic.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mActivityScanQrnImagescreenBinding.idPhotoTv.stopCamera();
    }

}