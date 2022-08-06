package com.mygdx.game.view.viewElements.drawables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class TexturedDrawable implements Drawable {

	private final Texture texture;
	private TextureRegion textureRegion;
	float width, height;
	
	public TexturedDrawable(Texture texture) {
		this.texture = texture;
	}

	public TexturedDrawable(Texture texture, float width, float height) {
		this.texture = texture;
		this.width = width;
		this.height= height;
	}


	@Override
	public void update() {	
	}

	@Override
	public void render(SpriteBatch sb, Vector2 pos) {
		sb.draw(texture, pos.x, pos.y);
	}

	@Override
	public void render(SpriteBatch sb, float x, float y) {
		sb.draw(texture, x, y);
	}

	@Override
	public void render(SpriteBatch sb, float x, float y, float width, float height) {
		sb.draw(texture, x, y, width, height);
	}


	public Texture getTexture() {
		return texture;
	}

	@Override
	public TextureRegion getTextureRegion() {
		if (textureRegion == null) {
			textureRegion = new TextureRegion(texture);
		}
		return textureRegion;
	}

	@Override
	public Drawable getInstance() {
		return new TexturedDrawable(texture);
	}

	@Override
	public float getWidth() {
		return texture.getWidth();
	}

	@Override
	public float getHeight() {
		return texture.getHeight();
	}

	@Override
	public Object getRaw() {
		return texture;
	}

}