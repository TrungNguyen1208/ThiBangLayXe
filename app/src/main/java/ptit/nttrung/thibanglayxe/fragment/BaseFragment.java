package ptit.nttrung.thibanglayxe.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    protected View containerView;
    protected LayoutInflater inflater;

    @SuppressLint("WrongConstant")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inflater = (LayoutInflater) getActivity().getSystemService("layout_inflater");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.containerView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.containerView != null) {
            try {
                ViewGroup parentViewGroup = (ViewGroup) this.containerView.getParent();
                if (parentViewGroup != null) {
                    parentViewGroup.removeAllViews();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
