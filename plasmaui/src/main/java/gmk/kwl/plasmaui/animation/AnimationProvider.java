package gmk.kwl.plasmaui.animation;

import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kevin Wong on 19/03/14.
 * Class in charge of instantiating animations
 */
public class AnimationProvider {

    private static String ANIMATION_CLASS_SUFFIX = "Animation";
    private static String ANIMATION_CLASS_PREFIX = "gmk.kwl.plasmaui.animation.animations.";
    private static HashMap<String, PlasmaAnimation> animationMap;

    public static PlasmaAnimation getAnimation(AnimationType animationType) {

        String animationName = getAnimationClassName(animationType.name());

        setupAnimationMap();

        if (! animationMap.containsKey(animationName)) {
            createAnimationForClassName(animationName);
        }

        return animationMap.get(animationName);
    }

    private static String getAnimationClassName(String animationName) {
        return ANIMATION_CLASS_PREFIX + animationName + ANIMATION_CLASS_SUFFIX;
    }

    private static void setupAnimationMap() {

        if (animationMap == null) {
            animationMap = new HashMap<String, PlasmaAnimation>();
        }
    }

    private static void createAnimationForClassName(String name) {

        try {

            Class<PlasmaAnimation> animationClass =  (Class<PlasmaAnimation>) Class.forName(name);
            animationMap.put(name, animationClass.newInstance());

            return;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        animationMap.put(name, new PlasmaAnimation() {
            @Override
            public void addAnimationToSet(AnimationProperties animationProperties, long timeOffset, AnimationSet animationSet) {
                Log.w("PlasmaUI", "Error creating animation");
            }
        });
    }
}
