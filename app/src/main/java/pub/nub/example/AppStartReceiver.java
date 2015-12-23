package pub.nub.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AppStartReceiver extends BroadcastReceiver {
    public AppStartReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service = new Intent(context,NotificationService.class);
        context.startService(service);
    }
}
