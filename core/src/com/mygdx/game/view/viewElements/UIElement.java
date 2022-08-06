package com.mygdx.game.view.viewElements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class UIElement {

	protected float x, y;
	
	public UIElement(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();
	
	public abstract void render(SpriteBatch sb);
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public void setPos(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void addPos(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
}