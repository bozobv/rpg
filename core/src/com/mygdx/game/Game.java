package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.view.screens.MenuScreen;
import com.mygdx.game.view.screens.ScreenContainer;

public class Game extends ApplicationAdapter {
	SpriteBatch sb;
	protected boolean paused;
	protected long lastBack;
	
	@Override
	public void create () {
		sb = new SpriteBatch(150);
		sb.enableBlending();

		setupSettings();
		Gdx.input.setCatchBackKey(true); //nem lép ki a vissza gomb megnyomásánál

		//MENU
		ResourceManager.getInstance().loadSprite("btnBg", "menu/menubtn.png", .1f, .1f);
		ResourceManager.getInstance().loadSprite("menuBg", "menu/menubg.png", .588f, .5f);


		//GAME
		ResourceManager.getInstance().loadTexture("playerAnimated", "bobs.png");
		ResourceManager.getInstance().loadTextureAtlas("player", "bob.atlas");
		ResourceManager.getInstance().loadTextureAtlas("slime", "slime.atlas");

		//UI
		ResourceManager.getInstance().loadTexture("joystickBg", "ui/joystickBg.png");
		ResourceManager.getInstance().loadTexture("joystickKnob", "ui/joystickKnob.png");
		ResourceManager.getInstance().loadTexture("bg","ui/bg.png");
		ResourceManager.getInstance().loadTexturedDrawable("btnAttack","ui/attackBtn.png");
		ResourceManager.getInstance().loadTexturedDrawable("btnSkill1","ui/skillBtn1.png");


		//MAP
		//TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("tiles/tiles.atlas"));
		ResourceManager.getInstance().loadMap("firstLevel","don.tmx");


		//FONTS
		ResourceManager.getInstance().loadFont("font", "fonts/source-sans-pro-regular.ttf", Color.WHITE, 20);
		ResourceManager.getInstance().loadFont("smallFont", "fonts/source-sans-pro-regular.ttf", Color.WHITE, 12);

		ScreenContainer.setScreen(new MenuScreen());

	}

	@Override
	public void render () {
		if (!paused) {

			if (ScreenContainer.getCurrent() != null)
				ScreenContainer.getCurrent().update();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.BACK) && System.currentTimeMillis() - lastBack > 300) {
			if (ScreenContainer.getCurrent() != null) {
				ScreenContainer.getCurrent().onBackPressed();
			}
			lastBack = System.currentTimeMillis();
		}

		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0f, 0f, 0f, 1);

		if (ScreenContainer.getCurrent() != null) {
			ScreenContainer.getCurrent().render(sb);
		}
	}
	
	@Override
	public void dispose () {
		sb.dispose();
		ResourceManager.getInstance().dispose();
		//ThreadManager.getInstance().shutdown();
	}

	@Override
	public void resize(int width, int height) {
		if (ScreenContainer.getCurrent() != null)
			ScreenContainer.getCurrent().resize(width, height);
	}

	@Override
	public void pause() {
		paused = true;
		if (ScreenContainer.getCurrent() != null)
			ScreenContainer.getCurrent().pause();
	}

	@Override
	public void resume() {
		paused = false;
		if (ScreenContainer.getCurrent() != null)
			ScreenContainer.getCurrent().resume();
	}

	public static void setupSettings() {
		Settings.addSetting("width", Gdx.graphics.getWidth());
		Settings.addSetting("height", Gdx.graphics.getHeight());
	}
}
