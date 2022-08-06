package com.mygdx.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.Settings;
import com.mygdx.game.view.camera.OrthoCamera;
import com.mygdx.game.view.viewElements.drawables.SpriteDrawable;
import com.mygdx.game.view.viewElements.drawables.buttons.TextButton;

public class MenuScreen implements Screen{

    private Sprite bg = ResourceManager.getInstance().getSprite("menuBg");
    private OrthoCamera camera = new OrthoCamera();
    private TextButton newWorldBtn = new TextButton("New Run", new SpriteDrawable(ResourceManager.getInstance().getSprite("btnBg")),ResourceManager.getInstance().getFont("font"), Settings.getWidth()/2 - 60, 250);
    //private TextButton loadWorldBtn = new TextButton("Load World", new SpriteDrawable(ResourceManager.getInstance().getSprite("btnBg")), ResourceManager.getInstance().getFont("font"), Settings.getWidth() / 2 -60, 120);

    @Override
    public void create() {
        bg.setPosition(0, 0);
    }

    @Override
    public void update() {
        camera.update();
        if (Gdx.input.isTouched()) {
            float touchX = camera.unprojectXCoordinate(Gdx.input.getX(), Gdx.input.getY());
            float touchY = camera.unprojectYCoordinate(Gdx.input.getX(), Gdx.input.getY());
            if (newWorldBtn.isPressed(touchX, touchY)) {
                ScreenContainer.setScreen(new CharacterScreen());
            } /*else if (loadWorldBtn.isPressed(touchX, touchY)) {
                //ScreenManager.setScreen(new GameScreen("MyWorld"));
                System.out.println("betöttés");

            }*/
        }
    }
    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        bg.draw(sb);
        newWorldBtn.render(sb);
        //loadWorldBtn.render(sb);
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
