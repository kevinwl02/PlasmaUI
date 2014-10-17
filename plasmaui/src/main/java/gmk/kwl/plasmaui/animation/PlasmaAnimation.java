package gmk.kwl.plasmaui.animation;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/**
 * Created by Kevin Wong on 20/03/14.
 */
public abstract class PlasmaAnimation {

    public abstract void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet);

    public void addAnimationToSet(AnimationProperties animationProperties, AnimationSet animationSet) {
        addAnimationToSet(animationProperties, 0, animationSet);
    }

    protected void doNotChangeStateOfViewWith(Animation animation) {

        animation.setFillEnabled(true);
        animation.setFillBefore(false);
        animation.setFillAfter(false);
    }

    protected void doNotChangeStateOfViewAfter(Animation animation) {

        animation.setFillEnabled(true);
        animation.setFillBefore(true);
        animation.setFillAfter(false);
    }
}
