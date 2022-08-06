package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.managers.EntityManager;
import com.mygdx.game.model.entities.Character;
import com.mygdx.game.managers.LevelManager;
import com.mygdx.game.view.MapContainer;
import com.mygdx.game.view.camera.OrthoCamera;
import com.mygdx.game.view.AnimationWrapper;

public class World {
    private final MapContainer mapContainer;
    private Character character;
    private final EntityManager entityManager;
    private final LevelManager levelManager;

    float stateTime;

    public World() {

        levelManager = new LevelManager();
        mapContainer = new MapContainer();
        entityManager = new EntityManager();

        loadLevel("firstLevel");

        stateTime = 0f;

    }

    public World(Character character) {

        this();
        this.character = character;
    }


    public void update(OrthoCamera camera)
    {
        stateTime += Gdx.graphics.getDeltaTime();
        entityManager.update(character.getPosX(), character.getPosY());
    }

    public void moveUpdate(float knobPercentX, float knobPercentY)
    {
        character.move(knobPercentX, knobPercentY);
    }

    public void render(SpriteBatch sb, OrthoCamera camera)
    {

        update(camera);

        mapContainer.renderBack(camera);
        character.render(sb, stateTime);
        entityManager.render(sb,stateTime);

        sb.end();
        mapContainer.renderFront(camera);
        sb.begin();

        camera.setPosition(character.getPosX(), character.getPosY());

        sb.setProjectionMatrix(camera.combined);
    }




    private void loadLevel(String id) {

        mapContainer.loadTiledMap(id);

        entityManager.load(mapContainer,levelManager, id);

        character = new Character(new AnimationWrapper(ResourceManager.getInstance().getTextureAtlas("player")) , mapContainer.getCollisionLayer());
        character.setPosition(levelManager.getHeroPositionX(id), levelManager.getHeroPositionY(id));


    }

    public void attackPressed() {
        character.attack(EntityManager.getEnemies());
    }

    public void skill1Pressed() {
        System.out.println("skillpressed");

    }
}
