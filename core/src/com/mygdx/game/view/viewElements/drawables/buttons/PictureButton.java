package com.mygdx.game.view.viewElements.drawables.buttons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.view.viewElements.drawables.Drawable;

public class PictureButton extends Button {

	protected final Drawable drawable;
	protected float offsetBtnX, offsetBtnY;

	com.badlogic.gdx.scenes.scene2d.ui.Button But;

	public PictureButton(Drawable drawable, float x, float y) {
		super(x, y, drawable.getWidth(), drawable.getHeight());
		this.drawable = drawable;
	}

	public PictureButton(Drawable drawable, float x, float y, float offsetBtnX, float offsetBtnY, float width, float height) {
		super(x, y, width, height);
		this.drawable = drawable;
		this.offsetBtnX = offsetBtnX;
		this.offsetBtnY = offsetBtnY;
	}
	
	@Override
	public boolean isPressed(float xClick, float yClick) {
		return new Rectangle(x + offsetBtnX, y + offsetBtnY, width, height).overlaps(new Rectangle(xClick, yClick, 10, 10));
	}
	
	public void render(SpriteBatch sb) {
		drawable.render(sb, x, y);
	}
	
	public Drawable getDrawable() {
		return drawable;
	}
	
}