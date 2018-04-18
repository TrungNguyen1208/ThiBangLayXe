package ptit.nttrung.thibanglayxe.service;

import android.annotation.SuppressLint;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;

import java.util.Random;

import ptit.nttrung.thibanglayxe.R;
import ptit.nttrung.thibanglayxe.main.MainActivity;

public class NotifyService extends Service {
    public static final String INTENT_NOTIFY = "com.b2.giaothong.INTENT_NOTIFY";
    private static final int NOTIFICATION = 123;
    private final IBinder mBinder = new ServiceBinder();
    private NotificationManager mNM;

    public class ServiceBinder extends Binder {
        NotifyService getService() {
            return NotifyService.this;
        }
    }

    @SuppressLint("WrongConstant")
    public void onCreate() {
        this.mNM = (NotificationManager) getSystemService("notification");
    }

    @SuppressLint("WrongConstant")
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getBooleanExtra(INTENT_NOTIFY, false)) {
            showNotification();
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @SuppressLint("WrongConstant")
    private void showNotification() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        Builder builder = new Builder(this);
        int n = new Random().nextInt(4);
        if (n == 0) {
            mainIntent.putExtra("step", "dotest");
            builder.setContentIntent(PendingIntent.getActivity(this, 0, mainIntent, 134217728))
                    .setSmallIcon(R.mipmap.ic_launch)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launch))
                    .setTicker("Làm bài thi lý thuyết như thi thật")
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true)
                    .setContentTitle("Làm bài thi lý thuyết như thi thật")
                    .setContentText("Vào làm bài!");
        } else if (n == 1) {
            mainIntent.putExtra("step", "dolearn");
            builder.setContentIntent(PendingIntent.getActivity(this, 0, mainIntent, 134217728))
                    .setSmallIcon(R.mipmap.ic_launch)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launch))
                    .setTicker("Học 450 câu lý thuyết lái xe")
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true)
                    .setContentTitle("Học 450 câu lý thuyết lái xe")
                    .setContentText("Vào học ngay!");
        } else if (n == 2) {
            mainIntent.putExtra("step", "dosign");
            builder.setContentIntent(PendingIntent.getActivity(this, 0, mainIntent, 134217728)).setSmallIcon(R.mipmap.ic_launch).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launch)).setTicker("Học về hệ thống biển báo").setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle("Học về hệ thống biển báo").setContentText("Vào học ngay!");
        } else if (n == 3) {
            mainIntent.putExtra("step", "dotip");
            builder.setContentIntent(PendingIntent.getActivity(this, 0, mainIntent, 134217728)).setSmallIcon(R.mipmap.ic_launch).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launch)).setTicker("Mẹo thi kết quả cao").setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle("Mẹo thi kết quả cao").setContentText("Vào học mẹo ngay!");
        }
        if (VERSION.SDK_INT < 16) {
            this.mNM.notify(NOTIFICATION, builder.getNotification());
        } else {
            this.mNM.notify(NOTIFICATION, builder.build());
        }
        stopSelf();
    }
}
