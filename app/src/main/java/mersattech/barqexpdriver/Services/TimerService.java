package mersattech.barqexpdriver.Services;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import mersattech.barqexpdriver.Interfaces.TimerFinishedInterface;

/**
 * Created by Mersat-tech on 05-12-2017.
 */

public class TimerService extends Service {
    public static final String COUNTDOWN_BR = "your_package_name.countdown_br";
    private final static String TAG = "BroadcastService";
    public static TimerFinishedInterface timerFinishedInterface;
    public static int timer;
    Intent bi = new Intent(COUNTDOWN_BR);
    CountDownTimer cdt = null;
    private int progress = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "Starting timer...");

        cdt = new CountDownTimer(timer, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                Log.i(TAG, "Countdown seconds remaining: " + millisUntilFinished / 1000);
                bi.putExtra("countdown", millisUntilFinished / 1000);
                progress++;
                bi.putExtra("progress", progress * 100 / (30000 / 1000));
                sendBroadcast(bi);
            }

            @Override
            public void onFinish() {
                Log.i(TAG, "Timer finished");
                if (timerFinishedInterface != null)
                    timerFinishedInterface.onTimerFinished();
            }
        };

        cdt.start();
    }

    @Override
    public void onDestroy() {
        cdt.cancel();
        Log.i(TAG, "Timer cancelled");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}
