package com.mygdx.game.sprites;


public class RoadCar extends Sprite {

    public static int HEIGHT = 400;

    public RoadCar(String path, int x, int y) {
        super(path, x, y);
        speed.add(0, -700, 0);
    }

    @Override
    public void update(float dt) {
        speed.scl(dt);
        position.add(0, speed.y, 0);
        rectangle.setPosition(position.x, position.y);
        speed.scl(1 / dt);
    }
}
