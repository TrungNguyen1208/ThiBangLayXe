package ptit.nttrung.thibanglayxe;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class GPLXApp extends Application {

    private static GPLXApp appController;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    public void onCreate() {
        super.onCreate();
        appController = this;
        initImageLoader(getApplicationContext());
    }

    public static GPLXApp getInstance() {
        return appController;
    }

    public static Context getContext() {
        return appController.getApplicationContext();
    }

    public static void initImageLoader(Context context) {
        Builder config = new Builder(context);
        config.threadPriority(3);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(52428800);
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs();
        ImageLoader.getInstance().init(config.build());
    }

}
