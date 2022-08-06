package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.model.levels.Level;
import com.mygdx.game.model.levels.Level1;

import java.util.HashMap;

public class LevelManager {
    private final HashMap<String, Level> levels = new HashMap<String, Level>();

    public LevelManager()
    {
        loadLevel("firstLevel", new Level1());
    }

    public void loadLevel (String name, Level level)
    {
        levels.put(name, level);
    }

    public Level getLevel(String id) {
        return levels.get(id);
    }

    public String getLevelMap (String id)
    {
        return levels.get(id).getTiledMapName();
    }

    public float getHeroPositionX(String id) {
        return  levels.get(id).getHeroX();
    }

    public float getHeroPositionY(String id) {
        return  levels.get(id).getHeroY();
    }

    public float[] getSlimePosX (String id)
    {
        return levels.get(id).getSlimeX();
    }

    public float[] getSlimePosY(String id)
    {
        return levels.get(id).getSlimeY();
    }
}
