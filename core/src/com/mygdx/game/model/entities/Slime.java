package com.mygdx.game.model.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.view.AnimationWrapper;

public class Slime extends Enemy{
    Slime(AnimationWrapper ac, TiledMapTileLayer tiledMapTileLayer) {
        super(ac, tiledMapTileLayer);
        searchRadius = 300;
        approachRadius = 69 ;
        attackRadius = 70;
        velocity = 1;
        health = 50;
        def = 1;
    }


    public Slime(AnimationWrapper ac, float x, float y, TiledMapTileLayer collisionLayer) {
        super(ac, x, y, collisionLayer);
        searchRadius = 300;
        approachRadius = 69 ;
        attackRadius = 70;
        velocity = 2;
        health = 50;
    }

    /*public Slime(AnimationContainer ac, float x, float y, TiledMapTileLayer tiledMapTileLayer) {
        super(ac, x, y);
        searchRadius = 200;
        attackRadius = 10 ;
        velocity = 2;
    }*/

    @Override
    public void render(SpriteBatch sb, float stateTime) {
        super.render(sb, stateTime);
    }

    public Slime(AnimationWrapper ac) {
        super(ac);
    }

    //x és y a hero pozicioja
    @Override
    public void update(float x, float y) {
        super.update(x,y);
        act(x,y);
    }

    @Override
    public void act(float heroX, float heroY) {
        super.act(heroX,  heroY);

        switch(stage) {
            case PATROL:
                break;
            case APPROACH:
                moveDirection(heroX,heroY);
                break;
            case ATTACK:
                break;
            default:
                break;
        }
    }

    @Override
    public void getAttacked(int dam) {
        super.getAttacked(dam);
        System.out.println(health);

    }

    @Override
    protected boolean checkDead() {
        return super.checkDead();
    }

    @Override
    public void patrol(float x, float y) {
        super.patrol(x, y);
        //TODO
    }
}
