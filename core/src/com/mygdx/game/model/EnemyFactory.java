package com.mygdx.game.model;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.model.entities.Enemy;
import com.mygdx.game.model.entities.Slime;
import com.mygdx.game.view.AnimationWrapper;

public class EnemyFactory {

    public EnemyFactory()
    {

    }

    public Enemy createSlime(float x, float y, TiledMapTileLayer collisionLayer)
    {
        Enemy enemy = new Slime(new AnimationWrapper(ResourceManager.getInstance().getTextureAtlas("slime")), x, y, collisionLayer);
        return enemy;
    }

}
