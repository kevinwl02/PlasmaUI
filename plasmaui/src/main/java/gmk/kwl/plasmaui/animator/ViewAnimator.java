package gmk.kwl.plasmaui.animator;

import android.view.View;
import android.view.animation.AnimationSet;

import java.util.ArrayList;

import gmk.kwl.plasmaui.animation.AnimationProvider;
import gmk.kwl.plasmaui.animation.PlasmaAnimation;

/**
 * Created by Kevin Wong on 13/03/14.
 */
public class ViewAnimator {

    public static void performAnimationOnView(View view, ViewAnimation viewAnimation) {

    }

    public static void performMultianimationOnView(View view, ArrayList<ViewAnimation> viewAnimations, boolean startNow) {

        AnimationSet animationSet = new AnimationSet(false);
        long startOffset = 0;

        for (ViewAnimation viewAnimation : viewAnimations) {

            PlasmaAnimation animation = AnimationProvider.getAnimation(viewAnimation.getAnimationType());
            animation.addAnimationToSet(viewAnimation, startOffset, animationSet);

            if (!viewAnimation.isShouldMergeWithNextAnimation())
                startOffset += viewAnimation.getDuration() + viewAnimation.getDelay();
        }

        animationSet.setFillAfter(true);
        if (startNow)
            animationSet.startNow();
        else
            animationSet.start();
        view.setAnimation(animationSet);
    }
}
