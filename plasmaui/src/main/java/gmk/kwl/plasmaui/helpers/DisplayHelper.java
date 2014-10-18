package gmk.kwl.plasmaui.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by Kevin Wong on 18/10/14.
 */
public class DisplayHelper {

    private static DisplayHelper sharedInstance;

    public static DisplayHelper getSharedInstance() {
        if (sharedInstance == null)
            sharedInstance = new DisplayHelper();

        return sharedInstance;
    }

    // Instance methods and properties

    private DisplayMetrics displayMetrics;

    public DisplayMetrics getDisplayMetrics() {
        return displayMetrics;
    }

    public void setDisplayMetrics(DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
    }

    public float pixelsFromDips(float dip) {

        float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics);

        return pixels;
    }
}
