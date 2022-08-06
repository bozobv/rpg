package com.mygdx.game.model.levels;

import com.badlogic.gdx.math.Vector2;

public class Level1 extends Level{

    public Level1()
    {
        heroX = 300;
        heroY = 900;
        tiledMapName = "don.tmx";

        slimesX = new float[]{200, 300, 400, 600};
        slimesY = new float[]{200, 300, 700, 500};

    }

    @Override
    public String getTiledMapName() {
        return super.getTiledMapName();
    }

    @Override
    public float getHeroX() {
        return super.getHeroX();
    }

    @Override
    public float getHeroY() {
        return super.getHeroY();
    }

    @Override
    public float[] getSlimeX() {
        return super.getSlimeX();
    }

    @Override
    public float[] getSlimeY() {
        return super.getSlimeY();
    }
}
