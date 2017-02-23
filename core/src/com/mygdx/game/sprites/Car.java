package com.mygdx.game.sprites;

import java.util.List;

public class Car extends Sprite {

    public Car(int x, int y, String path) {
        super(path, x, y);
    }

    @Override
    public void update(float dt) {
        speed.scl(dt);
        position.add(speed.x, speed.y, 0);
        rectangle.setPosition(position.x, position.y);
        speed.scl(1 / dt);
    }

    public void moveCar(int x) {
        position.add(x, 0, 0);
    }

    public boolean isCollided(List<RoadCar> roadCars) {
        return roadCars.stream().filter(roadCar -> roadCar.getRectangle().overlaps(rectangle)).count() != 0;
    }
}
