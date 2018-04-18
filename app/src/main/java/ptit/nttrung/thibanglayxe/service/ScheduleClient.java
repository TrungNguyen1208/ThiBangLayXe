package ptit.nttrung.thibanglayxe.service;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.Calendar;

public class ScheduleClient {
    private ScheduleService mBoundService;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            ScheduleClient.this.mBoundService = ((ScheduleService.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            ScheduleClient.this.mBoundService = null;
        }
    };
    private Context mContext;
    private boolean mIsBound;

    public ScheduleClient(Context context) {
        this.mContext = context;
    }

    @SuppressLint("WrongConstant")
    public void doBindService() {
        this.mContext.bindService(new Intent(this.mContext, ScheduleService.class), this.mConnection, 1);
        this.mIsBound = true;
    }

    public void setAlarmForNotification(Calendar c) {
        if (this.mBoundService != null && c != null) {
            this.mBoundService.setAlarm(c);
        }
    }

    public void doUnbindService() {
        if (this.mIsBound) {
            this.mContext.unbindService(this.mConnection);
            this.mIsBound = false;
        }
    }
}
