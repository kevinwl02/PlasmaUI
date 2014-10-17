package gmk.kwl.plasmaui.animation.animations;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.animations.base.PlasmaTranslateAnimation;

/**
 * Created by Kevin Wong on 25/03/14.
 */
public class PopAnimation extends PlasmaTranslateAnimation {
    @Override
    public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {

        // Add translation if specified
        this.addDefaultTranslateAnimation(animationSet, timeOffset, animationProperties, true);

        // Implementation
        long dividedDuration = animationProperties.getDuration() / 3;

        // Grow
        ScaleAnimation growAnimation = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        growAnimation.setDuration(dividedDuration * 2);
        growAnimation.setStartOffset(animationProperties.getDelay() + timeOffset);
        animationSet.addAnimation(growAnimation);

        // Shrink
        ScaleAnimation shrinkAnimation = new ScaleAnimation(1.0f, 0.833f, 1.0f, 0.833f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        shrinkAnimation.setDuration(dividedDuration);
        shrinkAnimation.setStartOffset(animationProperties.getDelay() + timeOffset + dividedDuration * 2);
        animationSet.addAnimation(shrinkAnimation);

    }
}
