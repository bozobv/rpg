package com.mygdx.game.model.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.view.AnimationWrapper;

import java.util.ArrayList;

abstract public class Enemy extends CapableEntity{

    float searchRadius, approachRadius;
    Stage stage;

    public Enemy(AnimationWrapper ac, float x, float y, TiledMapTileLayer collisionLayer) {
        super(ac, collisionLayer);
        posX = x;
        posY = y;
    }

    public enum Stage {
        PATROL, APPROACH, ATTACK
    }



    Enemy(AnimationWrapper ac, TiledMapTileLayer tiledMapTileLayer) {
        super(ac,tiledMapTileLayer);
        stage = Stage.PATROL;
    }

    public Enemy(AnimationWrapper ac) {
        super(ac);
        stage = Stage.PATROL;
    }

    @Override
    public void attack(ArrayList<Entity> enemies) {

    }

    public Enemy(AnimationWrapper ac, float x, float y) {
        super(ac);
        posX = x;
        posY = y;
        stage = Stage.PATROL;
    }

    public void update(float x, float y) {
        if (checkInAttackRadius(x,y))
            stage = Stage.ATTACK;
        else if (checkInSearchRadius(x,y))
            stage = Stage.APPROACH;
        else
            stage = Stage.PATROL;
    }

    @Override
    public void render(SpriteBatch sb, float stateTime) {
        super.render(sb,stateTime);
    }

    public boolean checkInSearchRadius(float x, float y)
    {
        return Math.abs(posX - x) + Math.abs(posY - y) < this.searchRadius;
    }

    public boolean checkInAttackRadius(float x, float y)
    {
        return Math.abs(posX - x) + Math.abs(posY - y) < this.approachRadius;
    }

    public void act(float x, float y)
    {

    }

    public void patrol(float x, float y)
    {

    }


}
