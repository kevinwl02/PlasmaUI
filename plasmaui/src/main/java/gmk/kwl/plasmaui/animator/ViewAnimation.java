package gmk.kwl.plasmaui.animator;

import java.util.ArrayList;

import gmk.kwl.plasmaui.animation.AnimationProperties;
import gmk.kwl.plasmaui.animation.AnimationType;

/**
 * Created by Kevin Wong on 14/03/14.
 * View animation model
 */
public class ViewAnimation extends AnimationProperties{
    private AnimationType animationType;

    public AnimationType getAnimationType() {
        return animationType;
    }

    public void setAnimationType(AnimationType animationType) {
        this.animationType = animationType;
    }
}
