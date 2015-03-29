package io.github.zzn2.colorize.drawable;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/**
 * A Drawable which can change color according to specified ColorStateList.
 */
public class ColorStateDrawable extends DrawableWrapper {
    private ColorStateList mColorStateList;

    public ColorStateDrawable(Drawable drawable, ColorStateList colorStateList) {
        super(drawable.mutate());
        mColorStateList = colorStateList;
    }

    /**
     * Apply new ColorStateList to ColorStateDrawable.
     *
     * @param newColor new ColorStateList.
     */
    public void updateColor(ColorStateList newColor) {
        mColorStateList = newColor;
        updateColorFilter();
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    protected boolean onStateChange(int[] states) {
        updateColorFilter();
        return super.onStateChange(states);
    }

    private void updateColorFilter() {
        if (mColorStateList != null) {
            setColorFilter(mColorStateList.getColorForState(getState(), Color.WHITE), PorterDuff.Mode.MULTIPLY);
        }
    }
}
