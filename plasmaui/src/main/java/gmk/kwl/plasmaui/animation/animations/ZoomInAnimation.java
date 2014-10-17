package gmk.kwl.plasmaui.animation.animations;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.animations.base.PlasmaTranslateAnimation;

/**
 * Created by Kevin Wong on 25/03/14.
 */
public class ZoomInAnimation extends PlasmaTranslateAnimation{
    @Override
    public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {

        animationProperties.setDistance(animationProperties.getDistance() * 2);

        // Add translation if specified
        this.addDefaultTranslateAnimation(animationSet, timeOffset, animationProperties, true);

        // Implementation
        ScaleAnimation growAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        growAnimation.setDuration(animationProperties.getDuration());
        growAnimation.setStartOffset(animationProperties.getDelay() + timeOffset);
        animationSet.addAnimation(growAnimation);

        animationProperties.setDistance(animationProperties.getDistance() / 2);
    }
}
