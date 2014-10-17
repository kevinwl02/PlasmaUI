package gmk.kwl.plasmaui.animation.animations;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;

import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.animations.base.PlasmaTranslateAnimation;

/**
 * Created by Kevin Wong on 25/03/14.
 */
public class RotateOutAnimation extends PlasmaTranslateAnimation {
    @Override
    public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {

        // Add custom degrees value if specified
        float degrees = 30.0f;
        if (animationProperties.getExtraProperties() != null && animationProperties.getExtraProperties().size() > 1)
            degrees = Float.valueOf(animationProperties.getExtraProperties().get(0));

        // Implementation
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, degrees,
                Animation.RELATIVE_TO_SELF, -0.3f,
                Animation.RELATIVE_TO_SELF, -0.3f);
        rotateAnimation.setDuration(animationProperties.getDuration());
        rotateAnimation.setStartOffset(animationProperties.getDelay() + timeOffset);

        animationSet.addAnimation(rotateAnimation);
    }
}
