package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public abstract class Sprite {

    protected Texture texture;
    protected Vector3 speed;
    protected Vector3 position;
    protected Rectangle rectangle;

    public Sprite(String path, int x, int y) {
        texture = new Texture(path);
        speed = new Vector3(0, 0, 0);
        position = new Vector3(x, y, 0);
        rectangle = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    public abstract void update(float dt);

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Vector3 getSpeed() {
        return speed;
    }

    public void setSpeed(Vector3 speed) {
        this.speed = speed;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
