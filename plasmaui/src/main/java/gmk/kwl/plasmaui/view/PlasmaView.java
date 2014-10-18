package gmk.kwl.plasmaui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.regex.Pattern;

import gmk.kwl.plasmaui.R;
import gmk.kwl.plasmaui.animation.AnimationType;
import gmk.kwl.plasmaui.animator.ViewAnimation;
import gmk.kwl.plasmaui.animator.ViewAnimator;
import gmk.kwl.plasmaui.helpers.DisplayHelper;
import gmk.kwl.plasmaui.values.PlasmaDefaultValues;

/**
 * Created by Kevin Wong on 13/03/14.
 * PlasmaView: Class to be used as an animation view inside layout files
 */
public class PlasmaView extends FrameLayout {

    private static final String ELEMENT_SEPARATOR = ";";
    private static final String ELEMENT_MERGE_SEPARATOR = "+";
    private static final String PROPERTIES_SEPARATOR = ":";

    private ArrayList<ViewAnimation> viewAnimations;

    /**
     * View will parse animations at creation time.
     * @param context
     * @param attrs
     */
    public PlasmaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setupDisplayHelper(context);
        this.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        // Extract custom plasma attributes
        final TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.PlasmaView);

        final String animations = cleanInput(attributeArray.getString(R.styleable.PlasmaView_animation));
        final String durations = cleanInput(attributeArray.getString(R.styleable.PlasmaView_duration));
        final String delays = cleanInput(attributeArray.getString(R.styleable.PlasmaView_delay));
        final String distances = cleanInput(attributeArray.getString(R.styleable.PlasmaView_distance));
        final Boolean auto = attributeArray.getBoolean(R.styleable.PlasmaView_auto, true);
        final Boolean keepData = attributeArray.getBoolean(R.styleable.PlasmaView_keepData, true);

        attributeArray.recycle();

        this.parseAnimations(animations, durations, delays, distances);

        if (auto)
            ViewAnimator.performMultianimationOnView(this, this.viewAnimations, false);

        if (!keepData)
            this.viewAnimations = null;
    }

    /**
     * Starts previously defined animation in the view.
     * @param recursive If true, loops through all children of class PlasmaView to start their animations.
     */
    public void startAnimations(boolean recursive) {
        if (this.viewAnimations != null)
            ViewAnimator.performMultianimationOnView(this, this.viewAnimations, true);

        if (recursive) {
            loopThroughChildrenViews(this);
        }
    }

    // ==============================
    // Private methods
    // ==============================

    private void loopThroughChildrenViews(ViewGroup parentViewGroup) {
        for (int i = 0; i < parentViewGroup.getChildCount(); i++) {
            final View childView = parentViewGroup.getChildAt(i);
            if (childView instanceof PlasmaView) {
                ((PlasmaView) childView).startAnimations(true);
            }
            else if (childView instanceof ViewGroup) {
                loopThroughChildrenViews((ViewGroup)childView);
            }
        }
    }

    private void parseAnimations(String animations, String durations, String delays, String distances) {

        // Extracting components
        final String animationComponents[] = this.getComponents(animations);
        final String durationComponents[] = this.getComponents(durations);
        final String delayComponents[] = this.getComponents(delays);
        final String distanceComponents[] = this.getComponents(distances);

        // Create animation properties
        viewAnimations = new ArrayList<ViewAnimation>();

        int iterator = 0;
        for (String animation : animationComponents) {

            int mergeComponentIterator = 0;
            // Merge components
            String[] mergeComponents = this.getMergeComponents(animation);
            for (String mergeAnimation : mergeComponents) {

                // Subcomponents
                String[] subComponents = this.getSubComponents(mergeAnimation);
                if (subComponents.length > 1)
                    mergeAnimation = subComponents[0];

                if (AnimationType.hasValue(mergeAnimation)) {

                    ViewAnimation viewAnimation = new ViewAnimation();

                    this.setupSubComponentsForViewAnimation(viewAnimation, subComponents);
                    viewAnimation.setAnimationType(AnimationType.valueOfIgnoreCase(mergeAnimation));
                    viewAnimation.setDuration(this.getLongValueInComponentForIndex(durationComponents,
                            iterator, PlasmaDefaultValues.DEFAULT_DURATION_MILLIS));
                    if (iterator == 0)
                        viewAnimation.setDelay(this.getLongValueInComponentForIndex(delayComponents, iterator,
                                PlasmaDefaultValues.DEFAULT_DELAY_FOR_FIRST_VALUE_MILLIS));
                    else
                        viewAnimation.setDelay(this.getLongValueInComponentForIndex(delayComponents, iterator,
                                PlasmaDefaultValues.DEFAULT_DELAY_MILLIS));
                    viewAnimation.setDistance(this.getFloatValueInComponentForIndex(distanceComponents, iterator,
                            PlasmaDefaultValues.DEFAULT_DISTANCE));
                    if (mergeComponentIterator != mergeComponents.length - 1) {
                        viewAnimation.setShouldMergeWithNextAnimation(true);
                    }

                    viewAnimations.add(viewAnimation);
                }

                mergeComponentIterator ++;
                iterator ++;
            }
        }
    }

    private String[] getComponents(String inputString) {
        if(inputString == null)
            return new String[0];

        return inputString.split(Pattern.quote(ELEMENT_SEPARATOR));
    }

    private String[] getMergeComponents(String inputString) {
        return inputString.split(Pattern.quote(ELEMENT_MERGE_SEPARATOR));
    }

    private String[] getSubComponents(String component) {
        return component.split(Pattern.quote(PROPERTIES_SEPARATOR));
    }

    private float getFloatValueInComponentForIndex(String[] component, int index, float defaultValue) {

        if (index >= component.length) {
            return defaultValue;
        }
        return Float.valueOf(component[index]);
    }

    private long getLongValueInComponentForIndex(String[] component, int index, long defaultValue) {

        if (index >= component.length) {
            return defaultValue;
        }
        return Long.valueOf(component[index]);
    }

    private void setupSubComponentsForViewAnimation(ViewAnimation viewAnimation, String[] subComponents) {

        if (subComponents.length > 1) {

            final ArrayList<String> properties = new ArrayList<String>();
            for (int i = 1; i < subComponents.length; i++) {
                properties.add(subComponents[i]);
            }

            viewAnimation.setExtraProperties(properties);
        }
    }

    private void setupDisplayHelper(Context context) {

        Resources resources = context.getResources();
        DisplayHelper.getSharedInstance().setDisplayMetrics(resources.getDisplayMetrics());
    }

    // ==============================
    // Input cleaning
    // ==============================

    private String cleanInput(String inputString) {

        if (inputString == null)
            return null;

        inputString = inputString.replaceAll("\\s", "");
        return inputString;
    }
}
