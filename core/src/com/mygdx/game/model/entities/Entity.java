package com.mygdx.game.model.entities;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
    protected float posX,posY;

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public void render(SpriteBatch sb, float stateTime) {
    }


    public void setPosition(float x, float y){
        posX = x;
        posY = y;

    }

    public void update()
    {}

    public void getAttacked(int dam){}

    public abstract void update(float x, float y);
}
