package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.sprites.Road;

import java.util.LinkedList;
import java.util.List;


public class RoadManager {

    private List<Road> roads = new LinkedList<>();

    public RoadManager() {
        roads.add(new Road("road.png", 0, 0));
        roads.add(new Road("road.png", 0, Road.HEIGHT));
        roads.add(new Road("road.png", 0, Road.HEIGHT * 2));
    }

    public void drawRoad(SpriteBatch spriteBatch) {
        roads.forEach(road -> spriteBatch.draw(road.getTexture(), road.getPosition().x, road.getPosition().y));
    }

    public void updateRoad(float dt) {

        roads.forEach(road -> {
            road.update(dt);
            handleIfOutOfTheRoad(road);
        });

    }

    private void handleIfOutOfTheRoad(Road road) {
        if (road.getPosition().y < -Road.HEIGHT) {
            road.setPosition(new Vector3(0, Road.HEIGHT * 2, 0));
        }
    }

}
