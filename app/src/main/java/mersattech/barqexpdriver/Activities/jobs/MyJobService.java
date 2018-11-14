package mersattech.barqexpdriver.Activities.jobs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

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


public class MyJobService extends JobService {
    public static final String CANCELLATION_BR = "mersattech.barqexp.activities.Jobs.MyJobService";

    private static final String TAG = "MyJobService";
    Intent bi = new Intent(CANCELLATION_BR);

    Bundle newbundle;


    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        newbundle = jobParameters.getExtras();
        Log.d(TAG, "onStartJob: " + newbundle.getInt("jobId"));
        LocationService.getInstance(this).getLocation();

        SharedPreferences sharedPreferences = DataUtils.getInstance().
                getDefaultSharedPreferences(getApplicationContext());
        String auth = sharedPreferences.getString(AppConstants.TOKEN, "");

            if (NetworkUtils.getInstance().isNetworkAvailable(getApplicationContext())) {
            if (LocationService.getInstance(this).mCurrentLocation != null) {
                if (newbundle.getInt("onTrip") == 0) {

                    Call<LocationResponsebody> locationResoponse =
                            NetworkUtils.getApiInterface().addLocation(auth, requestbodyfordelivery(newbundle));
                    locationResoponse.enqueue(new Callback<LocationResponsebody>() {
                        @Override
                        public void onResponse(Call<LocationResponsebody> call, retrofit2.Response<LocationResponsebody> response) {
                            LocationRequestbody locationRequestbody = new LocationRequestbody();
                            Log.d(TAG, "onResponse: location");
                        }

                        @Override
                        public void onFailure(Call<LocationResponsebody> call, Throwable t) {
                            Toast.makeText(MyJobService.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                        }
                    });
//
                } else {
                    Call<TripTrackingResponse> tripTrackingResponseCall =
                            NetworkUtils.getApiInterface().addTripTracking(auth, requestBodyForTracking(newbundle));
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
                                        }
                                        else if(tripTrackingResponse.getEntity().getOrderStatusIndicator() == 12)
                                        {
                                           bi.putExtra("DRCancel",true);
                                           sendBroadcast(bi);
                                        }
                                        break;
                                    }
                                    default: {
                                        Log.d(TAG, "onResponse: ");
                                        break;
                                    }
                                }
                            } else {
                                Toast.makeText(MyJobService.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<TripTrackingResponse> call, Throwable t) {
                            Toast.makeText(MyJobService.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        } else {
            Toast.makeText(this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
        }


        return false;
    }


    private LocationRequestbody requestbodyfordelivery(Bundle newbundle) {

        LocationRequestbody locationRequestbody = new LocationRequestbody();
        locationRequestbody.setLatitude(String.valueOf(LocationService.getInstance(this).mCurrentLocation.latitude));
        locationRequestbody.setLongitude(String.valueOf(LocationService.getInstance(this).mCurrentLocation.longitude));
        return locationRequestbody;
    }

    private TripTrackingRequestBody requestBodyForTracking(Bundle newbundle) {
        TripTrackingRequestBody tripTrackingRequestBody = new TripTrackingRequestBody();
        tripTrackingRequestBody.setOrderTripSegmentID(newbundle.getInt("onTrip"));
        Log.d(TAG, "requestBodyForTracking: " + String.valueOf(newbundle.getInt("onTrip")));
//        Toast.makeText(MyJobService.this, String.valueOf(newbundle.getInt("onTrip")), Toast.LENGTH_SHORT).show();
//		if (mCurrentLocation == null) {
//			mCurrentLocation = new LatLng(0.0, 0.0);
//		}
        tripTrackingRequestBody.setDriverLatitude(String.valueOf(LocationService.getInstance(this).mCurrentLocation.latitude));
        tripTrackingRequestBody.setDriverLongitude(String.valueOf(LocationService.getInstance(this).mCurrentLocation.longitude));
        return tripTrackingRequestBody;
    }


    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "Job cancelled!");
        return true;
    }



}