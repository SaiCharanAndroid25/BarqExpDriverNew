package mersattech.barqexpdriver.Activities.jobs;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.maps.model.LatLng;

import mersattech.barqexpdriver.Activities.Location.LocationService;
import mersattech.barqexpdriver.Models.s.Location.LocationRequestbody;
import mersattech.barqexpdriver.Models.s.Location.LocationResponsebody;
import mersattech.barqexpdriver.Models.s.Triptracking.TripTrackingRequestBody;
import mersattech.barqexpdriver.Models.s.Triptracking.TripTrackingResponse;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.DataUtils;
import retrofit2.Call;
import retrofit2.Callback;

public class TrackingService extends Service {
    public static final String CANCELLATION_BR = "mersattech.barqexp.activities.Jobs.MyJobService";
    private  Intent bi = new Intent(CANCELLATION_BR);

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
    public Intent getIntent ;
    private LatLng currentLatLng;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                TrackingMethod();
                    handler.postDelayed(runnable, 10000);
            }
        };

        handler.postDelayed(runnable, 5000);
    }

    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        handler.removeCallbacks(runnable);
//        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
    }

//    @Override
//    public void onStart(Intent intent, int startid) {
//        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
//
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        getIntent = intent;

        return super.onStartCommand(intent, flags, startId);

    }

    public void TrackingMethod(){
        LocationService.getInstance(this).getLocation();

        SharedPreferences sharedPreferences = DataUtils.getInstance().
                getDefaultSharedPreferences(getApplicationContext());
        String auth = sharedPreferences.getString(AppConstants.TOKEN, "");

        if (NetworkUtils.getInstance().isNetworkAvailable(getApplicationContext())) {
            if (LocationService.getInstance(this).mCurrentLocation != null) {
                if (getIntent != null){
                    if (getIntent.getIntExtra("onTrip", 0) == 0) {

                        Call<LocationResponsebody> locationResoponse =
                                NetworkUtils.getApiInterface().addLocation(auth, requestbodyfordelivery());
                        locationResoponse.enqueue(new Callback<LocationResponsebody>() {
                            @Override
                            public void onResponse(Call<LocationResponsebody> call, retrofit2.Response<LocationResponsebody> response) {
                                LocationRequestbody locationRequestbody = new LocationRequestbody();
                                Log.d("tracking only", "onResponse: location");
                            }

                            @Override
                            public void onFailure(Call<LocationResponsebody> call, Throwable t) {
//                            Toast.makeText(this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                            }
                        });
//
                    } else {
                        Call<TripTrackingResponse> tripTrackingResponseCall =
                                NetworkUtils.getApiInterface().addTripTracking(auth, requestBodyForTracking());
                        tripTrackingResponseCall.enqueue(new Callback<TripTrackingResponse>() {
                            @Override
                            public void onResponse(Call<TripTrackingResponse> call, retrofit2.Response<TripTrackingResponse> response) {
                                TripTrackingResponse tripTrackingResponse = response.body();

                                if (tripTrackingResponse != null) {
                                    switch (tripTrackingResponse.getStatus()) {
                                        case 0: {
                                            if (tripTrackingResponse.getEntity().getOrderStatusIndicator() == 10) {
                                                bi.putExtra("tripcancel", true);
                                                sendBroadcast(bi);
                                            } else if (tripTrackingResponse.getEntity().getOrderStatusIndicator() == 12) {
                                                bi.putExtra("DRCancel", true);
                                                sendBroadcast(bi);
                                            } else if (tripTrackingResponse.getEntity().getOrderStatusIndicator() == 8) {
                                                bi.putExtra("DRCompleted", true);
                                                sendBroadcast(bi);
                                            }
                                            break;

                                        }
                                        default: {
                                            Log.d("trip tracking", "onResponse: ");
                                            break;
                                        }
                                    }
                                } else {
//                                Toast.makeText(MyJobService.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<TripTrackingResponse> call, Throwable t) {
//                            Toast.makeText(.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
            }
            }
        } else {
            Toast.makeText(this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
        }


    }
    private LocationRequestbody requestbodyfordelivery() {

        LocationRequestbody locationRequestbody = new LocationRequestbody();
        if(LocationService.getInstance(this).getLocationLiveData() != null){
        locationRequestbody.setLatitude(String.valueOf(LocationService.getInstance(this).mCurrentLocation.latitude));
        locationRequestbody.setLongitude(String.valueOf(LocationService.getInstance(this).mCurrentLocation.longitude));}
        return locationRequestbody;
    }

    private TripTrackingRequestBody requestBodyForTracking() {
        TripTrackingRequestBody tripTrackingRequestBody = new TripTrackingRequestBody();
        tripTrackingRequestBody.setOrderTripSegmentID(getIntent.getIntExtra("onTrip",0));
//        Log.d("TRackingService", "requestBodyForTracking: " + String.valueOf(newbundle.getInt("onTrip")));
//        Toast.makeText(MyJobService.this, String.valueOf(newbundle.getInt("onTrip")), Toast.LENGTH_SHORT).show();
//		if (mCurrentLocation == null) {
//			mCurrentLocation = new LatLng(0.0, 0.0);
//		}
        if(LocationService.getInstance(this).getLocationLiveData() != null){

            tripTrackingRequestBody.setDriverLatitude(String.valueOf(LocationService.getInstance(this).mCurrentLocation.latitude));
            tripTrackingRequestBody.setDriverLongitude(String.valueOf(LocationService.getInstance(this).mCurrentLocation.longitude));
        }
        return tripTrackingRequestBody;
    }
}
