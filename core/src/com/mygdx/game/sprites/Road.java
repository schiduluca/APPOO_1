package com.mygdx.game.sprites;


public class Road extends Sprite {

    public static final int HEIGHT = 1788;

    public Road(String path, int x, int y) {
        super(path, x, y);
        speed.add(0, -400, 0);
    }

    @Override
    public void update(float dt) {
        speed.scl(dt);
        position.add(0, speed.y, 0);
        speed.scl(1 / dt);
    }
}
