package com.mygdx.game.model.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.view.AnimationWrapper;

import java.util.ArrayList;

public abstract class CapableEntity extends Entity{
    AnimationWrapper animationWrapper;
    float velocity, prevX, prevY, width, height, increment, attackRadius;
    int health, strength, def;

    TiledMapTileLayer collisionLayer;


    CapableEntity(AnimationWrapper ac, TiledMapTileLayer collisionLayer)
    {
        this.collisionLayer = collisionLayer;
        prevX = posX;
        prevY = posY;
        animationWrapper = ac;
        width = animationWrapper.getWidth();
        height = animationWrapper.getHeight();

        increment = collisionLayer.getTileWidth();
        increment = width < increment ? width / 2 : increment / 2;
    }

    CapableEntity(AnimationWrapper ac )
    {
        prevX = posX;
        prevY = posY;
        animationWrapper = ac;
        width = animationWrapper.getWidth();
        height = animationWrapper.getHeight();
    }

    public CapableEntity() {

    }

    public void setCollisionLayer(TiledMapTileLayer collisionLayer)
    {
        this.collisionLayer = collisionLayer;
        increment = collisionLayer.getTileWidth();
        increment = width < increment ? width / 2 : increment / 2;
    }

    public void render(SpriteBatch sb, float stateTime)
    {
        if ( prevX == posX)
            animationWrapper.renderStand(sb,stateTime,posX, posY);
        else if( prevX < posX)
            animationWrapper.renderWalk(sb,stateTime,posX, posY);
        else if( prevX > posX)
            animationWrapper.renderWalkLeft(sb,stateTime,posX, posY);
        //sb.draw(animationContainer..getKeyFrame(stateTime, true), camera.position.x, camera.position.y);
        prevX = posX;
        prevY = posY;
    }

    /*public void move(float moveXPercent, float moveYPercent) {
        posX = posX + moveXPercent * velocity;
        posY = posY + moveYPercent * velocity;
    }*/

    public void move(float moveXPercent, float moveYPercent) {


        float oldX = posX, oldY = posY;

        boolean collisionX = false, collisionY = false;

        posX = posX + moveXPercent * velocity;
        posY = posY + moveYPercent * velocity;


        if(moveXPercent < 0) // going left
            collisionX = collidesLeft();
        else if(moveXPercent > 0) // going right
            collisionX = collidesRight();

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

    private boolean isCellBlocked(float x, float y) {
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
        return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey("blocked");
    }

    public boolean collidesRight() {
        for(float step = 0; step <= height; step += increment) {
            if (isCellBlocked(posX + width, posY + step))
                return true;
        }
        return false;
    }

    public boolean collidesLeft() {
        for(float step = 0; step <= height; step += increment)
            if(isCellBlocked(posX, posY + step))
                return true;
        return false;
    }

    public boolean collidesTop() {
        for(float step = 0; step <= width; step += increment)
            if(isCellBlocked(posX + step, posY + height))
                return true;
        return false;

    }

    public boolean collidesBottom() {
        for(float step = 0; step <= width; step += increment)
            if(isCellBlocked(posX + step, posY))
                return true;
        return false;
    }

    public void moveDirection(float x, float y)
    {
        float dirX, dirY, deltaX, deltaY;

        deltaX = x - posX;
        deltaY = y - posY;

        float var = Math.abs(deltaX) + Math.abs(deltaY);

        dirX = deltaX / var;
        dirY = deltaY / var;

        move(dirX, dirY);
    }

    public abstract void attack(ArrayList<Entity> enemies);

    public void getAttacked(int dam)
    {
        if (dam > def) {
            dam = dam - def;
            health = health - dam;
            if (checkDead())
            {
                die();
            }
        }
    }



    protected int getDam(){
        return strength;
    }

    protected boolean checkDead()
    {
        if (health <= 0)
            return true;
        return false;
    }

    protected void die()
    {
        super.die();
    }
}
