package mersattech.barqexpdriver.Activities.jobs;

import android.content.Context;
import android.os.Bundle;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

/**
 * Created by praveendewangan on 04/03/18.
 */

public class JobScheduler {
    private FirebaseJobDispatcher mDispatcher;
    public void  scheduleJob(Context context, Bundle jobbundle){

        mDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));
        Job myJob = mDispatcher.newJobBuilder()
                .setService(MyJobService.class)
                .setTag("")
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(1, 3))
                .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
                .setReplaceCurrent(true)
                .setConstraints(Constraint.ON_ANY_NETWORK)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                .setExtras(jobbundle)
                .build();

        mDispatcher.mustSchedule(myJob);

    }

    public void cancelJob()
    {
        mDispatcher.cancelAll();

    }
}
