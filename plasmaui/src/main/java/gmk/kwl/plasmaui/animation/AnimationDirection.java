package gmk.kwl.plasmaui.animation;

import android.view.animation.Animation;

/**
 * Created by Kevin Wong on 20/03/14.
 * Direction values for animations that involve translation
 */
public enum AnimationDirection {
    Left,Right,Up,Down,None;

    public static boolean hasValue(String value) {

        for (AnimationDirection animationDirection : AnimationDirection.values()) {
            if (animationDirection.name().equalsIgnoreCase(value))
                return true;
        }

        return false;
    }

    public static AnimationDirection valueOfIgnoreCase(String value) {

        for (AnimationDirection animationDirection : AnimationDirection.values()) {
            if (animationDirection.name().equalsIgnoreCase(value))
                return animationDirection;
        }

        return None;
    }
}
