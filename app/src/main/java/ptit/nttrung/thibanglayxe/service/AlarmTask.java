package ptit.nttrung.thibanglayxe.service;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

public class AlarmTask implements Runnable {
    private final AlarmManager am;
    private final Context context;
    private final Calendar date;

    @SuppressLint("WrongConstant")
    public AlarmTask(Context context, Calendar date) {
        this.context = context;
        this.am = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.date = date;
    }

    @SuppressLint("WrongConstant")
    public void run() {
        Intent intent = new Intent(this.context, NotifyService.class);
        intent.putExtra(NotifyService.INTENT_NOTIFY, true);
        this.am.setRepeating(1, this.date.getTimeInMillis(), 86400000, PendingIntent.getService(this.context, 0, intent, 0));
    }
}
