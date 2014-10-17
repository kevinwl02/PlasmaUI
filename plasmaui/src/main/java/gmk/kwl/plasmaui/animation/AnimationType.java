package gmk.kwl.plasmaui.animation;

import android.transition.Fade;

/**
 * Created by Kevin Wong on 04/03/14.
 */
public enum AnimationType {
    FadeIn, FadeOut, Move, Shake, Bounce, Pop, ZoomIn, ZoomOut, RotateIn, RotateOut, Slide, RotateInPlace;

    public static boolean hasValue(String value) {

        for (AnimationType animationType : AnimationType.values()) {
            if (animationType.name().equalsIgnoreCase(value))
                return true;
        }

        return false;
    }

    public static AnimationType valueOfIgnoreCase(String value) {

        for (AnimationType animationType : AnimationType.values()) {
            if (animationType.name().equalsIgnoreCase(value))
                return animationType;
        }

        return FadeIn;
    }
}
