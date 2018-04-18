package ptit.nttrung.thibanglayxe.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ptit.nttrung.thibanglayxe.R;
import ptit.nttrung.thibanglayxe.util.SharedPrefsUtil;

public class SplashActivity extends AppCompatActivity {
    private ImageView app_name;
    private Animation d;
    private Animation e;
    private Animation f;
    private ImageView icon_app;
    private TextView tv_app_content;
    private LinearLayout view_splash;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.icon_app = (ImageView) findViewById(R.id.icon_app);
        this.app_name = (ImageView) findViewById(R.id.app_name);
        this.tv_app_content = (TextView) findViewById(R.id.tv_app_content);
        this.view_splash = (LinearLayout) findViewById(R.id.view_splish);
        initAnimation();
    }

    private void initAnimation() {
        this.d = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
        this.d.setDuration(400);
        this.e = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
        this.e.setDuration(400);
        this.f = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
        this.f.setDuration(400);
        this.icon_app.startAnimation(this.d);

        this.d.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SplashActivity.this.icon_app.setVisibility(View.VISIBLE);
                SplashActivity.this.app_name.startAnimation(SplashActivity.this.e);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });

        this.e.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SplashActivity.this.app_name.setVisibility(View.VISIBLE);
                SplashActivity.this.tv_app_content.startAnimation(SplashActivity.this.f);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });

        this.f.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SplashActivity.this.tv_app_content.setVisibility(View.VISIBLE);
                boolean isChooseClass = SharedPrefsUtil.getInstance().getBoolean("isChooseClass", false);
                boolean isFinishGuide = SharedPrefsUtil.getInstance().getBoolean("isFinishGuide", false);
//                if (isChooseClass == false && isFinishGuide == false){
////                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, ChooseClassScreen.class));
////                    SplashActivity.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
////                    SplashActivity.this.finish();
//                    return;
//                }
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                SplashActivity.this.finish();
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

}
