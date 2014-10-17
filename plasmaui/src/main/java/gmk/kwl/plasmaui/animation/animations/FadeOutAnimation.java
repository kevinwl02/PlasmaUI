package gmk.kwl.plasmaui.animation.animations;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.PlasmaAnimation;
import gmk.kwl.plasmaui.animation.animations.base.PlasmaTranslateAnimation;

/**
 * Created by Kevin Wong on 20/03/14.
 */

public class FadeOutAnimation extends PlasmaTranslateAnimation {

    @Override
    public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {

        // Add translation if specified
        this.addDefaultTranslateAnimation(animationSet, timeOffset, animationProperties, false);

        // Implementation
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);

        alphaAnimation.setDuration(animationProperties.getDuration());
        alphaAnimation.setStartOffset(animationProperties.getDelay() + timeOffset);
        this.doNotChangeStateOfViewWith(alphaAnimation);

        animationSet.addAnimation(alphaAnimation);
    }
}
