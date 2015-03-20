package io.github.zzn.colorize.drawable;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.LinearLayout;

/**
 * A Drawable wrapper which wraps another Drawable.
 *
 * We should proxy every method call to wrapped Drawable,
 * but ClipDrawable does this thing already,
 * so we simulate a Drawable wrapper using ClipDrawable.
 */
public class DrawableWrapper extends ClipDrawable {
    public DrawableWrapper(Drawable drawable) {
        super(drawable, Gravity.CENTER, LinearLayout.VERTICAL);
        setLevel(10000);
    }
}
