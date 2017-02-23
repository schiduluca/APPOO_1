package com.mygdx.game.widgets;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by lschidu on 8/26/16.
 */
public class CustomButton {
    private Texture texture;
    private float x;
    private float y;

    public CustomButton(String path, float x, float y) {
        texture = new Texture(path);
        this.x = x;
        this.y = y;
    }

    public boolean isClicked(float x, float y) {
        return x > (this.x - texture.getWidth() / 2) && x < (this.x + texture.getWidth() - texture.getWidth() / 2)
                && y > (this.y - texture.getHeight() / 2)
                && y < (this.y + texture.getHeight() - texture.getHeight() / 2);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
