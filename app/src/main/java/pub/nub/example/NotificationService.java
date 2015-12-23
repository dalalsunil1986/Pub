package pub.nub.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;
import com.pubnub.api.PubnubException;

public class NotificationService extends Service {
    Pubnub pubnub;
    public NotificationService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        pubnub=new Pubnub("demo","demo");
        try {
            pubnub.subscribe("demo", new Callback() {
                @Override
                public void errorCallback(String channel, PubnubError error) {
                    super.errorCallback(channel, error);
                }

                @Override
                public void successCallback(String channel, Object message) {
                    super.successCallback(channel, message);
                }
            });
        } catch (PubnubException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Intent intent = new Intent("pub.nub.service.start");
        sendBroadcast(intent);

    }
}
