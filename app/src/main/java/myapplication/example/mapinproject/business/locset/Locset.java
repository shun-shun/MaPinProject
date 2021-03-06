package myapplication.example.mapinproject.business.locset;

import android.app.Activity;
import android.content.Intent;

import com.google.android.gms.location.LocationRequest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

public final class Locset {

    public static void request(@NonNull Activity activity, @SettingPriority int priority, int requestCode) {
        final Intent intent = new Intent(activity, LocsetActivity.class);
        intent.putExtra(LocsetActivity.INTENT_EXTRA_KEY_PRIORITY, priority);
        activity.startActivityForResult(intent, requestCode);
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            ResultCode.SUCCESS,
            ResultCode.PERMISSION_FAILURE,
            ResultCode.PERMISSION_FAILURE_DO_NOT_ASK_AGAIN,
            ResultCode.LOCATION_SETTING_FAILURE,
            ResultCode.GOOGLE_PLAY_SERVICES_UNAVAILABLE
    })
    public @interface ResultCode {
        int SUCCESS = 100;
        int PERMISSION_FAILURE = 101;
        int PERMISSION_FAILURE_DO_NOT_ASK_AGAIN = 102;
        int LOCATION_SETTING_FAILURE = 103;
        int GOOGLE_PLAY_SERVICES_UNAVAILABLE = 104;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            SettingPriority.HIGH_ACCURACY,
            SettingPriority.BALANCED_POWER_ACCURACY,
            SettingPriority.LOW_POWER,
            SettingPriority.NO_POWER
    })
    public @interface SettingPriority {
        int HIGH_ACCURACY = LocationRequest.PRIORITY_HIGH_ACCURACY;
        int BALANCED_POWER_ACCURACY = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        int LOW_POWER = LocationRequest.PRIORITY_LOW_POWER;
        int NO_POWER = LocationRequest.PRIORITY_NO_POWER;
    }
}

