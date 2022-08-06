package com.mygdx.game.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.entities.Character;
import com.mygdx.game.model.EnemyFactory;
import com.mygdx.game.model.entities.Entity;
import com.mygdx.game.view.MapContainer;

import java.util.ArrayList;

public class EntityManager {
    private static ArrayList<Entity> enemies;
    EnemyFactory enemyFactory;
    Character character;

    public EntityManager()
    {
        enemies = new ArrayList<Entity>();
        enemyFactory = new EnemyFactory();
        //character = new Character();
    }

    public static ArrayList<Entity> getEnemies() {
        return enemies;
    }

    public void update(float x, float y)
    {
        for(Entity e: enemies)
        {
            e.update(x,y);
        }
    }

    public void render(SpriteBatch sb, float stateTime)
    {
        for(Entity e: enemies)
        {
            e.render(sb, stateTime);
        }
    }

    public void load(MapContainer mapContainer, LevelManager levelManager, String id) {

        for (int i = 0; i < levelManager.getSlimePosX(id).length; i++)
        {
            enemies.add(enemyFactory.createSlime(levelManager.getSlimePosX(id)[i], levelManager.getSlimePosY(id)[i] , mapContainer.getCollisionLayer()));
        }

    }
}
