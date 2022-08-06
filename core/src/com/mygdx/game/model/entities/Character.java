package com.mygdx.game.model.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.view.AnimationWrapper;

import java.util.ArrayList;

public class Character extends CapableEntity{

    public Character()
    {
        super();
        attackRadius = 100;
        velocity = 3;
        strength = 2;
    }

    public Character(AnimationWrapper ac, TiledMapTileLayer collisionLayer)
    {
        super(ac,collisionLayer);
        attackRadius = 100;
        velocity = 3;
        strength = 2;
    }


    /*
        @Override
        public void move(float moveXPercent, float moveYPercent) {


            float oldX = posX, oldY = posY;

            boolean collisionX = false, collisionY = false;

            super.move(moveXPercent, moveYPercent);



            if(moveXPercent < 0) // going left
                collisionX = collidesLeft();
            else if(moveXPercent > 0) // going right
            {
                collisionX = collidesRight();
                //System.out.println(collisionX);
            }

            // react to x collision
            if(collisionX) {
                posX = oldX;
            }

            if(moveYPercent < 0) // going down
                collisionY = collidesBottom();
            else if(moveYPercent > 0) // going up
                collisionY = collidesTop();

            // react to y collision
            if(collisionY) {
                posY = oldY;
            }

        }
    */

    @Override
    public void render(SpriteBatch sb, float stateTime) {
        super.render(sb, stateTime);
    }

    @Override
    public void update(float x, float y) {

    }

    @Override
    public void attack(ArrayList<Entity> enemies) {

        for (Entity e: enemies)
        {
            if (Math.abs(posX - e.posX) + Math.abs( posY - e.posY) < attackRadius ) {
                e.getAttacked(getDam());
            }
        }
    }
}
