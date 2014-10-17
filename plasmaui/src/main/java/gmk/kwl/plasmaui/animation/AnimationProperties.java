package gmk.kwl.plasmaui.animation;

import java.util.ArrayList;

/**
 * Created by Kevin Wong on 20/03/14.
 */
public class AnimationProperties {

    private long duration;
    private long delay;
    private float distance;
    private boolean shouldMergeWithNextAnimation;

    public boolean isShouldMergeWithNextAnimation() {
        return shouldMergeWithNextAnimation;
    }

    public void setShouldMergeWithNextAnimation(boolean shouldMergeWithNextAnimation) {
        this.shouldMergeWithNextAnimation = shouldMergeWithNextAnimation;
    }

    private ArrayList<String> extraProperties;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public ArrayList<String> getExtraProperties() {
        return extraProperties;
    }

    public void setExtraProperties(ArrayList<String> extraProperties) {
        this.extraProperties = extraProperties;
    }
}
