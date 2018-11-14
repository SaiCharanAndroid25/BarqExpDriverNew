package mersattech.barqexpdriver.Activities.Location;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by praveendewangan on 09/02/18.
 */

public class LocationViewModel extends ViewModel {

    private MutableLiveData<LatLng> mcurr = new MutableLiveData<>();

    public LocationViewModel() {

    }


    public LiveData<LatLng> getmCurrentLocation(final Context context ){
        Timer timer;
        timer = new Timer();

        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
//                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                // setValue() cannot be called from a background thread so post to main thread.
                mcurr.postValue(LocationService.getInstance(context).mCurrentLocation);
            }
        }, 1000, 10000);
        return mcurr;
    }


}
