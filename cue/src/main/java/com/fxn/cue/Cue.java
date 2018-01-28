package com.fxn.cue;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fxn.cue.enums.Duration;
import com.fxn.cue.enums.Type;

/**
 * Created by akshay on 27/01/18.
 */

public class Cue {

    private static Cue cue;
    private Context context;
    private String message;
    private int textSize = 14;
    private int gravity = Gravity.CENTER_VERTICAL;
    private Duration duration;
    private String fontFaceString = "";
    private com.fxn.cue.enums.Type type;
    private int cornerRadius = 8;
    private int borderWidth = 1;
    private int padding = 16;
    private int custom_background_color = ColorRes.primary_background_color;
    private int custom_border_color = ColorRes.primary_border_color;
    private int custom_text_color = ColorRes.primary_text_color;

    public static Cue init() {
        cue = new Cue();
        return cue;
    }

    public int getPadding() {
        return this.padding;
    }

    public Cue setPadding(int padding) {
        this.padding = padding;
        return this;
    }

    public int getBorderWidth() {
        return this.borderWidth;
    }

    public Cue setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public Cue setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public String getFontFace() {
        return this.fontFaceString;
    }

    public Cue setFontFace(String fontFaceString) {
        this.fontFaceString = fontFaceString;
        return this;
    }

    public Cue setCustomFontColor(int bgcolor, int txtcolor, int bordercolor) {
        custom_background_color = bgcolor;
        custom_border_color = bordercolor;
        custom_text_color = txtcolor;
        return this;
    }

    public int getTextSize() {
        return textSize;
    }

    public Cue setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public Cue with(Context context) {
        this.context = context;
        return this;
    }

    public Type getType() {
        return this.type;
    }

    public Cue setType(Type type) {
        this.type = type;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Cue setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getGravity() {
        return gravity;
    }

    public Cue setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public Duration getDuration() {
        return duration;
    }

    public Cue setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public void show() {
        Toast toast = new Toast(context.getApplicationContext());
        View view = LayoutInflater.from(context).inflate(R.layout.content_custom_toast, null, false);
        TextView custom_text = view.findViewById(R.id.custom_text);
        custom_text.setText(message);
        custom_text.setTextSize(textSize);
        custom_text.setPadding(padding, padding, padding, padding);
        if (!fontFaceString.isEmpty()) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontFaceString);
            custom_text.setTypeface(typeface);
        }
        getShape(type, custom_text);
        toast.setDuration(duration == Duration.LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        toast.setGravity(gravity, 0, 0);
        toast.setView(view);
        toast.show();
    }

    private void getShape(Type type, TextView custom_text) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(cornerRadius);
        switch (type) {
            case SUCCESS: {
                shape.setColor(ColorRes.success_background_color);
                shape.setStroke(borderWidth, ColorRes.success_border_color);
                custom_text.setTextColor(ColorRes.success_text_color);
            }
            break;
            case SECONDARY: {
                shape.setColor(ColorRes.secondary_background_color);
                shape.setStroke(borderWidth, ColorRes.secondary_border_color);
                custom_text.setTextColor(ColorRes.secondary_text_color);
            }
            break;
            case DANGER: {
                shape.setColor(ColorRes.danger_background_color);
                shape.setStroke(borderWidth, ColorRes.danger_border_color);
                custom_text.setTextColor(ColorRes.danger_text_color);
            }
            break;
            case WARNING: {
                shape.setColor(ColorRes.warning_background_color);
                shape.setStroke(borderWidth, ColorRes.warning_border_color);
                custom_text.setTextColor(ColorRes.warning_text_color);
            }
            break;
            case INFO: {
                shape.setColor(ColorRes.info_background_color);
                shape.setStroke(borderWidth, ColorRes.info_border_color);
                custom_text.setTextColor(ColorRes.info_text_color);
            }
            break;
            case LIGHT: {
                shape.setColor(ColorRes.light_background_color);
                shape.setStroke(borderWidth, ColorRes.light_border_color);
                custom_text.setTextColor(ColorRes.light_text_color);
            }
            break;
            case DARK: {
                shape.setColor(ColorRes.dark_background_color);
                shape.setStroke(borderWidth, ColorRes.dark_border_color);
                custom_text.setTextColor(ColorRes.dark_text_color);
            }
            break;
            case CUSTOM: {
                shape.setColor(custom_background_color);
                shape.setStroke(borderWidth, custom_border_color);
                custom_text.setTextColor(custom_text_color);
            }
            break;
            default: {
                shape.setColor(ColorRes.primary_background_color);
                shape.setStroke(borderWidth, ColorRes.primary_border_color);
                custom_text.setTextColor(ColorRes.primary_text_color);
            }
            break;

        }
        custom_text.setBackgroundDrawable(shape);
    }


}
