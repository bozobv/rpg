package com.mygdx.game.view;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;

public class AnimationWrapper {

    private ObjectMap<Type, Animation<TextureRegion> > animations = new ObjectMap<Type, Animation<TextureRegion>>() ;
    private Animation animation;



    public enum Type {
        STAND, WALK, ATTACK
    }

    private float stateTime;

    public void reset() {
        stateTime = 0f;
    }

    public int getKeyFrameIndex() {
        return animation.getKeyFrameIndex(stateTime);
    }

    public void setAnimationByType(Type type) {
        animation = animations.get(type);
    }

    public AnimationWrapper(/*SpriteSheet sheet*/TextureAtlas textureAtlas) {
        /*final int startX = 0;
        final int startY = 0;
        final int frames = 3;

        Array<TextureRegion> tempSpritesUp = AnimationDrawable.grabSprites(sheet, startX, startY, frames);
        Array<TextureRegion> tempSpritesDown = AnimationDrawable.grabSprites(sheet, startX, startY + 2, frames);
        Array<TextureRegion> tempSpritesLeft = AnimationDrawable.grabSprites(sheet, startX, startY + 1, frames, true);
        Array<TextureRegion> tempSpritesRight = AnimationDrawable.grabSprites(sheet, startX, startY + 1, frames);

        AnimationDrawable.addMiddleReversed(tempSpritesUp, false);
        AnimationDrawable.addMiddleReversed(tempSpritesDown, false);
        AnimationDrawable.addMiddleReversed(tempSpritesLeft, false);
        AnimationDrawable.addMiddleReversed(tempSpritesRight, false);

        animations.put(Type.WALK_DOWN, new Animation(1f / (frames * 1.5f), tempSpritesDown));
        animations.put(Type.WALK_UP, new Animation(1f / (frames * 1.5f), tempSpritesUp));
        animations.put(Type.WALK_LEFT, new Animation(1f / (frames * 1.5f), tempSpritesLeft));
        animations.put(Type.WALK_RIGHT, new Animation(1f / (frames * 1.5f), tempSpritesRight));

        for(Animation animation : animations.values()) {
            animation.setPlayMode(Animation.PlayMode.LOOP);
        }

        setAnimationByType(Type.WALK_DOWN); // default animation
        */


        animations.put(Type.WALK, new Animation<TextureRegion>(0.1f, textureAtlas.findRegions("walk")));
        animations.put(Type.ATTACK, new Animation<TextureRegion>(0.055f, textureAtlas.findRegions("attack")));
        animations.put(Type.STAND, new Animation<TextureRegion>(0.2f, textureAtlas.findRegions("stand")));

        for(Animation animation : animations.values()) {
            animation.setPlayMode(Animation.PlayMode.LOOP);
        }

        setAnimationByType(Type.WALK);

    }


    public TextureRegion getTextureRegion() {
        return (TextureRegion) animation.getKeyFrame(stateTime);

    }

    public Animation getAnimationWalk() {
        return animations.get(Type.WALK);
    }

    public Animation getAnimationStand() {
        return animations.get(Type.STAND);
    }

    public Animation getAnimationAttack() {
        return animations.get(Type.ATTACK);
    }

    public void renderStand(SpriteBatch sb, float stateTime, float x, float y) {
        sb.draw((TextureRegion) getAnimationStand().getKeyFrame(stateTime, true), x, y);
    }

    public void renderWalk(SpriteBatch sb, float stateTime, float x, float y)
    {
        sb.draw((TextureRegion) getAnimationWalk().getKeyFrame(stateTime, true), x + 64, y, -64f, 64f);

    }

    public void renderWalkLeft(SpriteBatch sb, float stateTime, float x, float y)
    {
        sb.draw((TextureRegion) getAnimationWalk().getKeyFrame(stateTime, true), x, y);

    }

    public AnimationWrapper getInstance() {
        return new AnimationWrapper(null); // TODO okozhat NPE-t
    }

    public float getWidth() {
        TextureRegion tr = (TextureRegion) getAnimationWalk().getKeyFrame(stateTime);
        return tr.getRegionWidth();
    }

    public float getHeight() {
        TextureRegion tr = (TextureRegion) getAnimationWalk().getKeyFrame(stateTime);
        return tr.getRegionHeight();

    }

    public Object getRaw() {
        return animation;
    }

}