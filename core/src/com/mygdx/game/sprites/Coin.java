package com.mygdx.game.sprites;


public class Coin extends Sprite {

    private boolean visible;

    public Coin(String path, int x, int y) {
        super(path, x, y);
        speed.add(0, -400, 0);
        this.visible = false;
    }

    @Override
    public void update(float dt) {
        speed.scl(dt);
        position.add(0, speed.y, 0);
        rectangle.setPosition(position.x, position.y);
        speed.scl(1 / dt);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isCollided(Car car) {
        return rectangle.overlaps(car.getRectangle());
    }
}
