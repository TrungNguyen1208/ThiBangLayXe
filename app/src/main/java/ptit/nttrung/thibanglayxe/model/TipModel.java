package ptit.nttrung.thibanglayxe.model;

import android.animation.TimeInterpolator;

import java.io.Serializable;

public class TipModel implements Serializable {
    private int colorId1;
    private int colorId2;
    private String description;
    private TimeInterpolator interpolator;
    private int tipCategoryId;
    private String tipTitle;

    public TipModel(String tipTitle, String description, int colorId1, int colorId2, TimeInterpolator interpolator) {
        this.tipTitle = tipTitle;
        this.description = description;
        this.colorId1 = colorId1;
        this.colorId2 = colorId2;
        this.interpolator = interpolator;
    }

    public int getTipCategoryId() {
        return this.tipCategoryId;
    }

    public void setTipCategoryId(int tipCategoryId) {
        this.tipCategoryId = tipCategoryId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColorId1() {
        return this.colorId1;
    }

    public void setColorId1(int colorId1) {
        this.colorId1 = colorId1;
    }

    public int getColorId2() {
        return this.colorId2;
    }

    public void setColorId2(int colorId2) {
        this.colorId2 = colorId2;
    }

    public String getTipTitle() {
        return this.tipTitle;
    }

    public void setTipTitle(String tipTitle) {
        this.tipTitle = tipTitle;
    }

    public TimeInterpolator getInterpolator() {
        return this.interpolator;
    }

    public void setInterpolator(TimeInterpolator interpolator) {
        this.interpolator = interpolator;
    }
}
