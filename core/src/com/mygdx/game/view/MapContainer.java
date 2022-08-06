package com.mygdx.game.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.view.camera.OrthoCamera;

public class MapContainer {
    TiledMap tiledMap;
    TiledMapTileLayer collisionLayer, bgLayer, bgObjectsLayer, frontLayer;
    OrthogonalTiledMapRenderer tiledMapRenderer;
    SpriteBatch sb;


    public void loadTiledMap(String id) {

        this.tiledMap = ResourceManager.getInstance().getMap(id);
        this.sb =  new SpriteBatch();

        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, this.sb);

        bgLayer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        collisionLayer = (TiledMapTileLayer) tiledMap.getLayers().get(1);
        bgObjectsLayer = (TiledMapTileLayer) tiledMap.getLayers().get(2);
        frontLayer = (TiledMapTileLayer) tiledMap.getLayers().get(3);


    }

    public MapContainer() {

    }

    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }

    public void renderFront(OrthoCamera camera) {
        sb.begin();

        tiledMapRenderer.setView(camera);
        tiledMapRenderer.renderTileLayer(frontLayer);

        sb.end();


    }

    public void renderBack( OrthoCamera camera ) {

        sb.begin();

        tiledMapRenderer.setView(camera);

        tiledMapRenderer.renderTileLayer(bgLayer);
        tiledMapRenderer.renderTileLayer(collisionLayer);
        tiledMapRenderer.renderTileLayer(bgObjectsLayer);

        sb.end();
    }

}
