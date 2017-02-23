package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameStateManager;

public abstract class State {

    protected GameStateManager gameStateManager;

    public State(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public abstract void render(SpriteBatch spriteBatch);

    public abstract void update(float dt);

    public abstract void inputHandler();

    public abstract void dispose();

}
