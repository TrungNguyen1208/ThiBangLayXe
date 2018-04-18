package ptit.nttrung.thibanglayxe.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Calendar;

public class ScheduleService extends Service {
    private final IBinder mBinder = new ServiceBinder();

    public class ServiceBinder extends Binder {
        ScheduleService getService() {
            return ScheduleService.this;
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void setAlarm(Calendar c) {
        new AlarmTask(this, c).run();
    }
}
