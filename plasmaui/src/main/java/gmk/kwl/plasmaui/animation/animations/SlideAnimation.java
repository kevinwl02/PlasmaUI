package gmk.kwl.plasmaui.animation.animations;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.animations.base.PlasmaTranslateAnimation;

/**
 * Created by Kevin Wong on 25/03/14.
 */
public class SlideAnimation extends PlasmaTranslateAnimation {
    @Override
    public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {

        // Add translate if specified
        TranslateAnimation translateAnimation = this.getTranslateAnimation(animationProperties, true);
        if (translateAnimation != null) {

            translateAnimation.setDuration(animationProperties.getDuration());
            translateAnimation.setStartOffset(animationProperties.getDelay() + timeOffset);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
        }

    }
}
