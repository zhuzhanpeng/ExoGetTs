package com.onairm.hd4tv.online.activity;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.onairm.hd4tv.online.R;


/**
 * Created by apple on 17/9/14.
 */

public class FocusLinearLayout extends LinearLayout {

    private Animation scaleSmallAnimation;
    private Animation scaleBigAnimation;

    public FocusLinearLayout(Context context) {
        super(context);
    }


    public FocusLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public FocusLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if(null != focusChangeWithDirectionListener){  // 焦点发生变化之后的监听
            focusChangeWithDirectionListener.onFocusChange(this,gainFocus,direction);
        }
        if (gainFocus) {
            getRootView().invalidate();
            zoomOut();
        } else {
            zoomIn();
        }
    }

    private void zoomIn() {
        if (scaleSmallAnimation == null) {
            scaleSmallAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_small);
        }
        startAnimation(scaleSmallAnimation);
    }

    private void zoomOut() {
        if (scaleBigAnimation == null) {
            scaleBigAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_big);
        }
        startAnimation(scaleBigAnimation);
    }


    public interface FocusChangeWithDirectionListener{
        void onFocusChange(View v, boolean hasFocus, int direction);
    }
    private FocusChangeWithDirectionListener focusChangeWithDirectionListener;
    public void setFocusChangeWithDirectionListener(FocusChangeWithDirectionListener focusChangeWithDirectionListener){
        this.focusChangeWithDirectionListener = focusChangeWithDirectionListener;
    }
}
