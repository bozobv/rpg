package com.mygdx.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.Settings;
import com.mygdx.game.model.entities.Character;
import com.mygdx.game.view.AnimationWrapper;
import com.mygdx.game.view.camera.OrthoCamera;
import com.mygdx.game.view.viewElements.drawables.SpriteDrawable;
import com.mygdx.game.view.viewElements.drawables.buttons.TextButton;

public class CharacterScreen implements Screen {

    private Sprite bg = ResourceManager.getInstance().getSprite("menuBg");
    private OrthoCamera camera = new OrthoCamera();
    private TextButton warriorButton = new TextButton("warrior", new SpriteDrawable(ResourceManager.getInstance().getSprite("btnBg")),ResourceManager.getInstance().getFont("font"), Settings.getWidth()/3 - 60, 120);
    private TextButton mageButton = new TextButton("mage", new SpriteDrawable(ResourceManager.getInstance().getSprite("btnBg")), ResourceManager.getInstance().getFont("font"), 2 *Settings.getWidth() / 3 -60, 120);

    @Override
    public void create() {
        bg.setPosition(0, 0);
        camera.resize();
    }

    @Override
    public void update() {
        camera.update();
        if (Gdx.input.isTouched()) {
            float touchX = camera.unprojectXCoordinate(Gdx.input.getX(), Gdx.input.getY());
            float touchY = camera.unprojectYCoordinate(Gdx.input.getX(), Gdx.input.getY());
            if (warriorButton.isPressed(touchX, touchY)) {
                ScreenContainer.setScreen(new GameScreen()) ;
            } else if (mageButton.isPressed(touchX, touchY)) {
                //ScreenManager.setScreen(new GameScreen("MyWorld"));
                System.out.println("Mage");

            }
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        bg.draw(sb);
        warriorButton.render(sb);
        mageButton.render(sb);
        ResourceManager.getInstance().getFont("font").draw(sb, "Choose your character!", Settings.getWidth()/2 - 100, Settings.getHeight() - 100);

        sb.end();
    }
    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
