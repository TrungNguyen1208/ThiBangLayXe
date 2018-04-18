package ptit.nttrung.thibanglayxe.main;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.Drawer.OnDrawerItemClickListener;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.Calendar;
import java.util.List;

import ptit.nttrung.thibanglayxe.R;
import ptit.nttrung.thibanglayxe.service.ScheduleClient;

public class MainActivity extends AppCompatActivity {

    private Drawer result;
    private ScheduleClient scheduleClient;

    public void initDrawer(Bundle savedInstanceState) {
        PrimaryDrawerItem item1 = (PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem().withIdentifier(1)).withName(R.string.home)).withIcon(R.drawable.ic_drive_eta)).withIconTintingEnabled(true);
        PrimaryDrawerItem item2 = (PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem().withIdentifier(2)).withName(R.string.intro_duce)).withIcon(R.drawable.ic_info_outline)).withIconTintingEnabled(true);
        PrimaryDrawerItem item3 = (PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem().withIdentifier(3)).withName(R.string.email_support)).withIcon(R.drawable.ic_email)).withIconTintingEnabled(true);
        PrimaryDrawerItem item4 = (PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem().withIdentifier(4)).withName(R.string.setting)).withIcon(R.drawable.ic_settings)).withIconTintingEnabled(true);
        PrimaryDrawerItem item5 = (PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem()
                .withIdentifier(6))
                .withIcon(R.drawable.ic_star))
                .withName(R.string.favorite))
                .withIconTintingEnabled(true);
        PrimaryDrawerItem item6 = (PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem()
                .withIdentifier(7))
                .withName(R.string.other_app))
//                .withIcon(R.drawable.ic_file_download))
                .withIcon(R.drawable.ic_settings))
                .withIconTintingEnabled(true);
        PrimaryDrawerItem item7 = (PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem()
                .withIdentifier(8))
                .withName(R.string.share))
//                .withIcon(R.drawable.ic_share))
                .withIcon(R.drawable.ic_settings))
                .withIconTintingEnabled(true);
        PrimaryDrawerItem item8 = (PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem()
                .withIdentifier(9))
                .withName(R.string.review))
//                .withIcon(R.drawable.ic_like_it_512))
                .withIcon(R.drawable.ic_settings))
                .withIconTintingEnabled(true);
        this.result = new DrawerBuilder().withActivity(this).withAccountHeader(new AccountHeaderBuilder().withActivity(this)
                .withSelectionListEnabledForSingleProfile(false)
                .withHeaderBackground(R.drawable.bg_splash)
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                }).build())
                .addDrawerItems(item1, item2, item3, item4, new DividerDrawerItem(), item5, item6, item7, item8)
                .withSelectedItem(1)
                .withOnDrawerItemClickListener(new OnDrawerItemClickListener() {
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (MainActivity.this.result.isDrawerOpen()) {
                            MainActivity.this.result.closeDrawer();
                        }
                        if (position != 1) {
                            MainActivity.this.onItemSelected(position);
                        }
                        return true;
                    }
                }).withOnDrawerListener(new Drawer.OnDrawerListener() {
                    public void onDrawerOpened(View drawerView) {
                    }

                    public void onDrawerClosed(View drawerView) {
                        MainActivity.this.result.setSelectionAtPosition(1, false);
                    }

                    public void onDrawerSlide(View drawerView, float slideOffset) {
                    }
                }).build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDrawer(savedInstanceState);
        this.scheduleClient = new ScheduleClient(this);
        this.scheduleClient = new ScheduleClient(this);
        this.scheduleClient.doBindService();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ôn thi giấy phép lái xe");
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (MainActivity.this.result == null || !MainActivity.this.result.isDrawerOpen()) {
                    MainActivity.this.result.openDrawer();
                } else {
                    MainActivity.this.result.closeDrawer();
                }
            }
        });
        new Handler().postDelayed(new Runnable() {
            public void run() {
                MainActivity.this.firstSetup();
            }
        }, 2000);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getString("step") != null && extras.getString("step").equals("dotest")) {
                goToLearnExam();
            } else if (extras.getString("step") != null && extras.getString("step").equals("dolearn")) {
                goToLearnQuestCategoryAcitivty();
            } else if (extras.getString("step") != null && extras.getString("step").equals("dosign")) {
                goToTrafficSignsAcitivty();
            } else if (extras.getString("step") != null && extras.getString("step").equals("dotip")) {
                goToTipAcitivty();
            }
        }
        onItemSelected(1);
    }

    @SuppressLint("WrongConstant")
    public void firstSetup() {
        Calendar c = Calendar.getInstance();
        int year = c.get(1);
        int month = c.get(2);
        int day = c.get(5);
        if (c.get(11) < 18) {
            c.set(year, month, day);
        } else {
            c.set(year, month, day + 1);
        }
        c.set(11, 18);
        c.set(12, 0);
        c.set(13, 0);
        this.scheduleClient.setAlarmForNotification(c);
    }

    public void goToTrafficSignsAcitivty() {
//        startActivity(new Intent(this, TrafficSignsAcitivty.class));
//        overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
    }

    public void goToTipAcitivty() {
//        startActivity(new Intent(this, TipAcitivty.class));
//        overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
    }

    public void goToLearnQuestCategoryAcitivty() {
//        startActivity(new Intent(this, LearnQuestCategoryAcitivty.class));
//        overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
    }

    public void goToLearnExam() {
//        startActivity(new Intent(this, ExamTestCategory.class));
//        overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
    }

    public void goToLearnLaw() {
//        startActivity(new Intent(this, LawSeach.class));
//        overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
    }

    public void goToFragmentAndDontAddBackStack(Fragment fragment, String nameFragment) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        mFragmentManager.popBackStack(null, 1);
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        ft.replace(R.id.contentMain, fragment);
        ft.commit();
    }

    protected void onStop() {
        super.onStop();
        if (this.scheduleClient != null) {
            this.scheduleClient.doUnbindService();
        }
    }

    public void onItemSelected(final int position) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                switch (position) {
                    case 1:
                        MainActivity.this.goToFragmentAndDontAddBackStack(new MainFragment(), MainFragment.class.toString());
                        return;
                    case 2:
                        Intent intent = new Intent(MainActivity.this, GuideLineScreen.class);
                        intent.putExtra("back", "true");
                        MainActivity.this.startActivity(intent);
                        return;
                    case 3:
                        Intent mailer = new Intent("android.intent.action.SEND");
                        mailer.setType("text/plain");
                        mailer.putExtra("android.intent.extra.EMAIL", new String[]{"blala@gmail.com"});
                        mailer.putExtra("android.intent.extra.SUBJECT", "Hỗ trợ câu hỏi lý thuyết");
                        mailer.putExtra("android.intent.extra.TEXT", "Bạn giải thích giúp mình câu số..");
                        MainActivity.this.startActivity(Intent.createChooser(mailer, "Hỗ trợ qua email..."));
                        return;
                    case 4:
//                        Intent intent4 = new Intent(MainActivity.this, ChooseClassScreen.class);
//                        intent4.putExtra("back", "true");
//                        MainActivity.this.startActivity(intent4);
                        return;
                    case 7:
                        Intent intent6 = new Intent("android.intent.action.VIEW");
                        intent6.setData(Uri.parse("market://details?id=6887973131258419774"));
                        MainActivity.this.startActivity(intent6);
                        return;
                    case 8:
                        String appPackageName = MainActivity.this.getPackageName();
                        try {
                            Intent i = new Intent("android.intent.action.SEND");
                            i.setType("text/plain");
                            i.putExtra("android.intent.extra.SUBJECT", "Học bằng lái xe");
                            i.putExtra("android.intent.extra.TEXT", "\nHọc lý thuyết, thi thử lý thuyết dễ dàng với ứng dụng \"Học bằng lái xe\"\n\n" + "https://play.google.com/store/apps/details?id=" + appPackageName);
                            MainActivity.this.startActivity(Intent.createChooser(i, "Chia sẻ ứng dụng"));
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    case 9:
                        MainActivity.this.openRating();
                        return;
                    default:
                        return;
                }
            }
        }, 300);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        List<Fragment> lstFragment = getSupportFragmentManager().getFragments();
        if (lstFragment != null && lstFragment.size() > 0) {
            for (int i = 0; i < lstFragment.size(); i++) {
            }
        }
    }

    public void openRating() {
        String appPackageName = getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + appPackageName)));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
}
