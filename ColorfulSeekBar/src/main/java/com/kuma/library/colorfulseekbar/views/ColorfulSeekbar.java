package com.kuma.library.colorfulseekbar.views;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.SeekBar;

import com.kuma.library.colorfulseekbar.R;
import com.kuma.library.colorfulseekbar.utils.Tools;

/**
 * Created by TakumaLee on 2016/6/14.
 */
public class ColorfulSeekbar extends SeekBar implements SeekBar.OnSeekBarChangeListener {

    int startColor = ContextCompat.getColor(getContext(), R.color.start_color);
    int endColor = ContextCompat.getColor(getContext(), R.color.end_color);

    public ColorfulSeekbar(Context context) {
        this(context, null);
    }

    public ColorfulSeekbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorfulSeekbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setMax(100);
        setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.shape_seekbar));
        setThumb(ContextCompat.getDrawable(getContext(), R.drawable.shape_thumb));
        setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int color = (int) new ArgbEvaluator().evaluate((float) progress / 100, startColor, endColor);
        ShapeDrawable thumb = new ShapeDrawable(new OvalShape());
        thumb.setIntrinsicHeight(Tools.dpToPx(20));
        thumb.setIntrinsicWidth(Tools.dpToPx(20));
        thumb.setColorFilter(color, PorterDuff.Mode.SRC);
        setThumb(thumb);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
