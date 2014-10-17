package gmk.kwl.plasmaui.animation.animations;

import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.PlasmaAnimation;
import gmk.kwl.plasmaui.animation.animations.base.PlasmaTranslateAnimation;

/**
 * Created by Kevin Wong on 24/03/14.
 */
public class ShakeAnimation extends PlasmaAnimation{

    private static final int BOUNCE_OFFSET = 30;

    @Override
    public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {

        long currentOffset = animationProperties.getDelay() + timeOffset;
        long bounceDuration = (animationProperties.getDuration()) / 4;

        // Translate 2
        TranslateAnimation translate2 = new TranslateAnimation(0, -BOUNCE_OFFSET, 0, 0);
        translate2.setDuration(bounceDuration);
        translate2.setStartOffset(currentOffset);
        animationSet.addAnimation(translate2);

        currentOffset += bounceDuration;

        // Translate 3
        TranslateAnimation translate3 = new TranslateAnimation(0, BOUNCE_OFFSET * 2, 0, 0);
        translate3.setDuration(bounceDuration);
        translate3.setStartOffset(currentOffset);
        animationSet.addAnimation(translate3);

        currentOffset += bounceDuration;

        // Translate 4
        TranslateAnimation translate4 = new TranslateAnimation(0, -BOUNCE_OFFSET * 2, 0, 0);
        translate4.setDuration(bounceDuration);
        translate4.setStartOffset(currentOffset);
        animationSet.addAnimation(translate4);

        currentOffset += bounceDuration;

        // Translate 5
        TranslateAnimation translate5 = new TranslateAnimation(0, BOUNCE_OFFSET, 0, 0);
        translate5.setDuration(bounceDuration);
        translate5.setStartOffset(currentOffset);
        animationSet.addAnimation(translate5);
    }
}
