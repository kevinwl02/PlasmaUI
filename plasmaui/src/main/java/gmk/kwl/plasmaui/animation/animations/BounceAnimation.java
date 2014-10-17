package gmk.kwl.plasmaui.animation.animations;

import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import gmk.kwl.plasmaui.animation.AnimationDirection;
import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.animations.base.PlasmaTranslateAnimation;

/**
 * Created by Kevin Wong on 24/03/14.
 */
public class BounceAnimation extends PlasmaTranslateAnimation {

    private static final int BOUNCE_OFFSET = 40;

    @Override
    public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {

        if (animationProperties.getExtraProperties() != null && animationProperties.getExtraProperties().size() > 0) {

            // Translate
            TranslateAnimation translateAnimation = this.createTranslateAnimationWithStartAndEnd(
                    AnimationDirection.valueOfIgnoreCase(animationProperties.getExtraProperties().get(0)),
                    animationProperties.getDistance(), BOUNCE_OFFSET);
            long translateDuration = (animationProperties.getDuration() / 3) * 2;
            translateAnimation.setDuration(translateDuration);
            translateAnimation.setStartOffset(animationProperties.getDelay() + timeOffset);
            animationSet.addAnimation(translateAnimation);

            // Bounce
            TranslateAnimation bounceAnimation = this.createTranslationAnimationOut(
                    AnimationDirection.valueOfIgnoreCase(animationProperties.getExtraProperties().get(0)),
                    -BOUNCE_OFFSET);
            bounceAnimation.setDuration(animationProperties.getDuration() / 3);
            bounceAnimation.setStartOffset(animationProperties.getDelay() + timeOffset + translateDuration);
            bounceAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(bounceAnimation);
        }

    }
}
