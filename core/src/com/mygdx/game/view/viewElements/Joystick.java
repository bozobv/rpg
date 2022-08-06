package com.mygdx.game.view.viewElements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;

public class Joystick {
    private Touchpad touchpad;
    private Touchpad.TouchpadStyle touchpadStyle;
    private Skin touchpadSkin;

    public Joystick(Texture background, Texture knob, float deadZoneRadius, float x, float y, float width, float height) {
        touchpadSkin = new Skin();
        touchpadSkin.add("touchBackground", background);
        touchpadSkin.add ("touchKnob", knob);
        touchpadStyle = new Touchpad.TouchpadStyle();
        touchpadStyle.background = touchpadSkin.getDrawable("touchBackground");
        touchpadStyle.knob = touchpadSkin.getDrawable("touchKnob");
        touchpad = new Touchpad(deadZoneRadius, touchpadStyle);
        touchpad.setBounds(x, y, width, height);
    }


    public Touchpad getTouchpad() {
        return touchpad;
    }
}
