package com.mygdx.game.model.levels;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.mygdx.game.model.entities.Enemy;
import com.mygdx.game.model.entities.Npc;

public abstract class Level {
    Npc npcs[];
    protected float slimesX[], slimesY[];


    protected String tiledMapName;

    protected float heroX, heroY;

    public String getTiledMapName()
    {
        return tiledMapName;
    }

    public float getHeroX() {
        return heroX;
    }

    public float getHeroY() {
        return heroY;
    }

    public float[] getSlimeX()
    {
        return slimesX;
    }

    public float[] getSlimeY()
    {
        return slimesY;

    }
}
