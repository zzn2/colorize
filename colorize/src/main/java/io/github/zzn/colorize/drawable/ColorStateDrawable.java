package io.github.zzn.colorize.drawable;

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
        super(drawable);
        mColorStateList = colorStateList;
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    protected boolean onStateChange(int[] states) {
        if (mColorStateList != null) {
            setColorFilter(mColorStateList.getColorForState(states, Color.WHITE), PorterDuff.Mode.MULTIPLY);
        }
        return super.onStateChange(states);
    }
}
