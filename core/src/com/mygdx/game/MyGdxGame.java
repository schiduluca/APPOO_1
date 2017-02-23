package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.MenuState;

public class MyGdxGame extends ApplicationAdapter {

    public static final String TITLE = "Car Racer";
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    private SpriteBatch spriteBatch;

    private GameStateManager gameStateManager;

    @Override
    public void create() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gameStateManager = new GameStateManager();
        gameStateManager.push(new MenuState(gameStateManager));
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameStateManager.render(spriteBatch);
        gameStateManager.update(Gdx.graphics.getDeltaTime());

    }

    @Override
    public void dispose() {
        // TODO : will be nedded to add later
    }

}
