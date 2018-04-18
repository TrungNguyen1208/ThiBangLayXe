package ptit.nttrung.thibanglayxe.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderLayout.PresetIndicators;
import com.daimajia.slider.library.SliderLayout.Transformer;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView.OnSliderClickListener;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx.OnPageChangeListener;

import java.util.HashMap;

import ptit.nttrung.thibanglayxe.R;

public class MainFragment extends Fragment implements OnSliderClickListener, OnPageChangeListener {
    private SliderLayout mSlider;
    private View rootView;

    @SuppressLint("WrongConstant")
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.rootView == null) {
            this.rootView = ((LayoutInflater) getActivity().getSystemService("layout_inflater"))
                    .inflate(R.layout.fragment_main, null, false);
            this.rootView.setLayoutParams(new LayoutParams(-1, -1));
        }
    }

    public void onResume() {
        if (this.mSlider != null) {
            this.mSlider.startAutoCycle();
        }
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mSlider = (SliderLayout) this.rootView.findViewById(R.id.slider);
        HashMap<String, Integer> file_maps = new HashMap();
        file_maps.put("Thi thử đề thi giống như thật", Integer.valueOf(R.drawable.thithulythuyet));
        file_maps.put("Mẹo thi sa hình chắc chắn đỗ", Integer.valueOf(R.drawable.meosahinh));
        file_maps.put("Học về hệ thống biển báo đường bộ", Integer.valueOf(R.drawable.hethongbienbao));
        file_maps.put("Học 450 câu lý thuyết chắc chắn đỗ", Integer.valueOf(R.drawable.hoclythuyet));
        file_maps.put("Tra cứu luật giao thông mới nhất", Integer.valueOf(R.drawable.luatgiaothong));
        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView.description(name).image(((Integer) file_maps.get(name)).intValue())
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            this.mSlider.addSlider(textSliderView);
        }
        this.mSlider.setPresetTransformer(Transformer.Accordion);
        this.mSlider.setPresetIndicator(PresetIndicators.Center_Bottom);
        this.mSlider.setCustomAnimation(new DescriptionAnimation());
        this.mSlider.setDuration(4000);
        this.mSlider.addOnPageChangeListener(this);
        return this.rootView;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        this.mSlider.stopAutoCycle();
        super.onPause();
    }

    public void onSliderClick(BaseSliderView slider) {
        if (slider.getBundle().get("extra").equals("Thi thử đề thi giống như thật")) {
            ((MainActivity) getActivity()).goToLearnExam();
        }
        if (slider.getBundle().get("extra").equals("Mẹo thi sa hình chắc chắn đỗ")) {
            ((MainActivity) getActivity()).goToTipAcitivty();
        }
        if (slider.getBundle().get("extra").equals("Học về hệ thống biển báo đường bộ")) {
            ((MainActivity) getActivity()).goToTrafficSignsAcitivty();
        }
        if (slider.getBundle().get("extra").equals("Học 450 câu lý thuyết chắc chắn đỗ")) {
            ((MainActivity) getActivity()).goToLearnQuestCategoryAcitivty();
        }
        if (slider.getBundle().get("extra").equals("Tra cứu luật giao thông mới nhất")) {
            ((MainActivity) getActivity()).goToLearnLaw();
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    public void onPageScrollStateChanged(int state) {
    }
}
