package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameStateManager;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.widgets.CustomButton;


public class MenuState extends State {

    private Texture background;

    private CustomButton playButton;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("background.jpg");
        playButton = new CustomButton("play.png", MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0);
        spriteBatch.draw(playButton.getTexture(), playButton.getX() - playButton.getTexture().getWidth() / 2,
                playButton.getY() - playButton.getTexture().getHeight() / 2);
        spriteBatch.end();
    }

    @Override
    public void update(float dt) {
        inputHandler();

    }

    @Override
    public void inputHandler() {

        if (Gdx.input.justTouched()) {
            if (playButton.isClicked(Gdx.input.getX(), Gdx.input.getY())) {
                gameStateManager.pop();
                gameStateManager.push(new PlayState(gameStateManager));
            }
        }

    }

    @Override
    public void dispose() {
        background.dispose();
        playButton = null;
    }
}
