package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.sprites.Road;
import com.mygdx.game.sprites.RoadCar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class CarManager {

    private List<RoadCar> cars;
    private Random random;

    public CarManager() {
        cars = new LinkedList<>();
        random = new Random();

        cars.add(new RoadCar("car.png", random.nextInt(400), 0));
        cars.add(new RoadCar("car.png", random.nextInt(400), Road.HEIGHT));
        cars.add(new RoadCar("car.png", random.nextInt(400), Road.HEIGHT * 2));
    }

    public void drawCars(SpriteBatch spriteBatch) {
        cars.forEach(car -> spriteBatch.draw(car.getTexture(), car.getPosition().x, car.getPosition().y));

    }

    public void updateCars(float dt) {

        cars.forEach(car -> {
            car.update(dt);
            handleIfOutOfTheRoad(car);
        });

    }


    private void handleIfOutOfTheRoad(RoadCar car) {
        // TODO: hardcoded values
        if (car.getPosition().y < -Road.HEIGHT) {
            car.setPosition(new Vector3(random.nextInt(400), Road.HEIGHT * 2, 0));
        }
    }

    public List<RoadCar> getCars() {
        return cars;
    }
}
