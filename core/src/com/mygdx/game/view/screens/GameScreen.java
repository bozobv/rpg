package com.mygdx.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.view.GameHud;
import com.mygdx.game.Settings;
import com.mygdx.game.World;
import com.mygdx.game.model.entities.Character;
import com.mygdx.game.view.camera.OrthoCamera;

public class GameScreen implements Screen {

    private OrthoCamera camera;
    private static World world;
    private GameHud gameHud;



    public GameScreen( Character character) {
        world = new World(character);

    }

    public GameScreen() {
        world = new World();
    }

    @Override
    public void create() {

        gameHud = new GameHud(this, world);


        camera = new OrthoCamera();
        resize(Settings.getWidth(), Settings.getHeight());
    }

    public void update() {
        camera.update();
        gameHud.update(camera);



        world.update(camera);
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update();

        sb.begin();

        world.render(sb,camera);

        sb.setProjectionMatrix(camera.combined);

        sb.end();
        gameHud.render(camera);
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
        gameHud.resize(width, height);
    }

    @Override
    public void dispose() {
        gameHud.dispose();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        gameHud.resume();
    }

    public static World getCurrentWorld() {
        return world;
    }
}
