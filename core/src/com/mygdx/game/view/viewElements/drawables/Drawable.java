package com.mygdx.game.view.viewElements.drawables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public interface Drawable {

	void update();

	void render(SpriteBatch sb, Vector2 pos);

	void render(SpriteBatch sb, float x, float y);

	void render(SpriteBatch sb, float x, float y, float width, float height);

	TextureRegion getTextureRegion();

	Drawable getInstance();
	
	float getWidth();
	
	float getHeight();
	
	Object getRaw();
	
}