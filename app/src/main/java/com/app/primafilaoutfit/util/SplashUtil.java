package com.app.primafilaoutfit.util;

import android.os.Handler;
import com.app.primafilaoutfit.Home;
import com.app.primafilaoutfit.Settings;

public class SplashUtil {

    public static void showSplash(final Home activity){
        activity.hideContent();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.showContent();
                if(Home.showRateDialog){
                    Home.showRateDialog = false;
                    RateDialogUtil.showRateDialog(activity);
                }
            }
        }, Settings.SPLASH_SCREEN_TIMEOUT);
    }

}
