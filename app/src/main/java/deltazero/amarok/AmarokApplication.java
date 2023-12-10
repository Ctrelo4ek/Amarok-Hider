package deltazero.amarok;

import android.app.Application;

import com.google.android.material.color.DynamicColors;
import com.rosan.dhizuku.api.Dhizuku;

import deltazero.amarok.utils.AppCenterUtil;

public class AmarokApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // WARNING: Do not change the order of those initializations.
        PrefMgr.init(this);
        Hider.init();
        QSTileService.init(getApplicationContext());

        if (PrefMgr.getEnableDynamicColor())
            DynamicColors.applyToActivitiesIfAvailable(this);

        // Start PanicButton service
        QuickHideService.startService(this);

        // Start App-center
        AppCenterUtil.startAppCenter(this);

        // init Dhizuku
        Dhizuku.init();
    }
}