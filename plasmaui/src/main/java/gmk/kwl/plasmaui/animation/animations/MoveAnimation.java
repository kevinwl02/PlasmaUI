package gmk.kwl.plasmaui.animation.animations;

import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.PlasmaAnimation;

/**
 * Created by Kevin Wong on 24/03/14.
 */
public class MoveAnimation extends PlasmaAnimation {
    @Override
    public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {

        // Get translate distance in X and Y
        float destinationX = Float.valueOf(animationProperties.getExtraProperties().get(0));
        float destinationY = Float.valueOf(animationProperties.getExtraProperties().get(1));

        // Implementation
        TranslateAnimation translateAnimation = new TranslateAnimation(0, destinationX, 0, destinationY);
        translateAnimation.setStartOffset(animationProperties.getDelay() + timeOffset);
        translateAnimation.setDuration(animationProperties.getDuration());
        animationSet.addAnimation(translateAnimation);

    }
}
