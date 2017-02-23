package com.mygdx.game.widgets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by lschidu on 8/29/16.
 */

public class ButtonSkin {

    private Texture texture;
    private Skin skin;
    private int x;
    private int y;

    private Button button;

    public ButtonSkin(String path, int x, int y) {
        this.x = x;
        this.y = y;
        texture = new Texture(path);
        skin = new Skin();
        skin.add("background", texture);
        button = new Button();
    }
}
