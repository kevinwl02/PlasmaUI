package gmk.kwl.plasmaui.animation.animations.base;

import android.util.Log;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

import gmk.kwl.plasmaui.animation.AnimationDirection;
import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.PlasmaAnimation;
import gmk.kwl.plasmaui.helpers.DisplayHelper;

/**
 * Created by Kevin Wong on 20/03/14.
 * Base animation class for plasma animations that require translation
 */
public abstract class PlasmaTranslateAnimation extends PlasmaAnimation {

    protected boolean addDefaultTranslateAnimation(AnimationSet animationSet, long startOffset, AnimationProperties animationProperties, boolean isTranslationIn) {

        TranslateAnimation defaultTranslateAnimation = this.getTranslateAnimation(animationProperties, isTranslationIn);
        if (defaultTranslateAnimation != null) {
            defaultTranslateAnimation.setDuration(animationProperties.getDuration());
            defaultTranslateAnimation.setStartOffset(animationProperties.getDelay() + startOffset);
            animationSet.addAnimation(defaultTranslateAnimation);

            return true;
        }

        return false;
    }

    protected TranslateAnimation getTranslateAnimation(AnimationProperties animationProperties, boolean isTranslationIn) {

        if (animationProperties.getExtraProperties() != null && animationProperties.getExtraProperties().size() > 0) {
            String directionProperty = animationProperties.getExtraProperties().get(0);

            if ( AnimationDirection.hasValue(directionProperty) ) {

                if (isTranslationIn)
                    return this.createTranslationAnimationIn(AnimationDirection.valueOfIgnoreCase(directionProperty), animationProperties.getDistance());
                else
                    return this.createTranslationAnimationOut(AnimationDirection.valueOfIgnoreCase(directionProperty), animationProperties.getDistance());
            }
        }

        return null;
    }

    protected TranslateAnimation createTranslationAnimationIn(AnimationDirection animationDirection, float distance) {

        distance = DisplayHelper.getSharedInstance().pixelsFromDips(distance);

        switch (animationDirection) {

            case Up:    return new TranslateAnimation(0, 0, distance, 0);
            case Down:  return new TranslateAnimation(0, 0, -distance, 0);
            case Left:  return new TranslateAnimation(distance, 0, 0, 0);
            case Right: return new TranslateAnimation(-distance, 0, 0, 0);

            default: return new TranslateAnimation(0, 0, 0, 0);
        }
    }

    protected TranslateAnimation createTranslationAnimationOut(AnimationDirection animationDirection, float distance) {

        distance = DisplayHelper.getSharedInstance().pixelsFromDips(distance);

        switch (animationDirection) {

            case Up:    return new TranslateAnimation(0, 0, 0, -distance);
            case Down:  return new TranslateAnimation(0, 0, 0, distance);
            case Left:  return new TranslateAnimation(0, -distance, 0, 0);
            case Right: return new TranslateAnimation(0, distance, 0, 0);

            default: return new TranslateAnimation(0, 0, 0, 0);
        }
    }

    protected TranslateAnimation createTranslateAnimationWithStartAndEnd(AnimationDirection animationDirection, float startDistance, float endDistance) {

        startDistance = DisplayHelper.getSharedInstance().pixelsFromDips(startDistance);
        endDistance = DisplayHelper.getSharedInstance().pixelsFromDips(endDistance);

        switch (animationDirection) {

            case Up:    return new TranslateAnimation(0, 0, startDistance, -endDistance);
            case Down:  return new TranslateAnimation(0, 0, -startDistance, endDistance);
            case Left:  return new TranslateAnimation(startDistance, -endDistance, 0, 0);
            case Right: return new TranslateAnimation(-startDistance, endDistance, 0, 0);

            default: return new TranslateAnimation(0, 0, 0, 0);
        }
    }

}
