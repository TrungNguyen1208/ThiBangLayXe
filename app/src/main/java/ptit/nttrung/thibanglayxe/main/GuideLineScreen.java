package ptit.nttrung.thibanglayxe.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.hanks.htextview.typer.TyperTextView;

import ptit.nttrung.thibanglayxe.R;
import ptit.nttrung.thibanglayxe.util.SharedPrefsUtil;

public class GuideLineScreen extends AppCompatActivity {
    private Animation anim1;
    private Animation anim2;
    private Animation anim3;
    private Animation anim4;
    private Button beginUsing;
    TyperTextView guide;
    TyperTextView guide1;
    TyperTextView guide2;
    TyperTextView guide3;
    TyperTextView guide4;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guile_line);

        final boolean isFinishGuide = SharedPrefsUtil.getInstance().getBoolean("isFinishGuide", false);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hướng dẫn chi tiết");

        this.guide = (TyperTextView) findViewById(R.id.guide);
        this.guide1 = (TyperTextView) findViewById(R.id.guide1);
        this.guide2 = (TyperTextView) findViewById(R.id.guide2);
        this.guide3 = (TyperTextView) findViewById(R.id.guide3);
        this.guide4 = (TyperTextView) findViewById(R.id.guide4);
        this.beginUsing = (Button) findViewById(R.id.beginUsing);
        this.guide1.setVisibility(View.INVISIBLE);
        this.guide2.setVisibility(View.INVISIBLE);
        this.guide3.setVisibility(View.INVISIBLE);
        this.guide4.setVisibility(View.INVISIBLE);
        this.beginUsing.setVisibility(View.INVISIBLE);
        this.guide.setCharIncrease(5);
        this.guide.setTyperSpeed(50);
        this.guide.animateText(this.guide.getText());

        if (isFinishGuide) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.beginUsing.setText("Đóng");
        }

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-RobotoRegular.ttf");
        this.guide.setTypeface(typeface);
        this.guide1.setTypeface(typeface);
        this.guide2.setTypeface(typeface);
        this.guide3.setTypeface(typeface);
        this.guide4.setTypeface(typeface);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                GuideLineScreen.this.guide1.setVisibility(View.VISIBLE);
                GuideLineScreen.this.guide1.startAnimation(GuideLineScreen.this.anim1);
            }
        }, 4000);
        this.anim1 = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
        this.anim1.setDuration(500);
        this.anim1.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        GuideLineScreen.this.guide2.setVisibility(View.VISIBLE);
                        GuideLineScreen.this.guide2.startAnimation(GuideLineScreen.this.anim2);
                    }
                }, 2000);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.anim2 = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
        this.anim2.setDuration(500);
        this.anim2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        GuideLineScreen.this.guide3.setVisibility(View.VISIBLE);
                        GuideLineScreen.this.guide3.startAnimation(GuideLineScreen.this.anim3);
                    }
                }, 2000);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.anim3 = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
        this.anim3.setDuration(500);
        this.anim3.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        GuideLineScreen.this.guide4.setVisibility(View.VISIBLE);
                        GuideLineScreen.this.guide4.startAnimation(GuideLineScreen.this.anim4);
                    }
                }, 2000);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.anim4 = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
        this.anim4.setDuration(500);
        this.anim4.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        GuideLineScreen.this.beginUsing.setVisibility(View.VISIBLE);
                    }
                }, 2000);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.beginUsing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!isFinishGuide) {
                    SharedPrefsUtil.getInstance().saveBoolean("isFinishGuide", true);
                    GuideLineScreen.this.startActivity(new Intent(GuideLineScreen.this, MainActivity.class));
                    GuideLineScreen.this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                    GuideLineScreen.this.finish();
                } else {
                    onBackPressed();
                }
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}