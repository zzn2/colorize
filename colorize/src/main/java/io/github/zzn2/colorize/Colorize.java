package io.github.zzn2.colorize;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.github.zzn2.colorize.drawable.ColorStateDrawable;


/**
 * Util class to apply ColorStateDrawable to
 * all TextView's in the view hierarchy.
 */
public class Colorize {

    /**
     * Make compound drawable color change with the text color.
     *
     * @param view the View to apply.
     *             apply to all child views if an ViewGroup is specified here.
     */
    public static void applyTo(View view) {
        if (view == null) {
            return;
        }

        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Drawable[] drawables = textView.getCompoundDrawables();
            for (int i = 0; i < 4; i++) {
                Drawable drawable = drawables[i];
                if (drawable != null) {
                    if (!(drawable instanceof ColorStateDrawable)) {
                        drawables[i] = new ColorStateDrawable(drawable, textView.getTextColors());
                    } else {
                        ((ColorStateDrawable) drawables[i]).updateColor(textView.getTextColors());
                    }
                }
            }

            textView.setCompoundDrawablesWithIntrinsicBounds(
                    drawables[0], drawables[1], drawables[2], drawables[3]);
        } else if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View subView = ((ViewGroup) view).getChildAt(i);
                applyTo(subView);
            }
        }
    }
}
