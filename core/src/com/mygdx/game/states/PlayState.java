package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.CarManager;
import com.mygdx.game.CoinManager;
import com.mygdx.game.GameStateManager;
import com.mygdx.game.RoadManager;
import com.mygdx.game.sprites.Car;


public class PlayState extends State {

    private Car car;
    private RoadManager roadManager;
    private CarManager carManager;
    private CoinManager coinManager;
    private int score = 0;
    private BitmapFont font;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        car = new Car(100, 100, "car.png");
        font = new BitmapFont();
        roadManager = new RoadManager();
        carManager = new CarManager();
        coinManager = new CoinManager();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        inputHandler();
        spriteBatch.begin();
        roadManager.drawRoad(spriteBatch);
        carManager.drawCars(spriteBatch);
        coinManager.drawCoins(spriteBatch);
        spriteBatch.draw(car.getTexture(), car.getPosition().x, car.getPosition().y);
        font.draw(spriteBatch, Integer.toString(score), 50, 50);
        spriteBatch.end();
    }

    @Override
    public void update(float dt) {
        car.update(dt);
        roadManager.updateRoad(dt);
        score += coinManager.checkForCollision(car);
        carManager.updateCars(dt);
        coinManager.update(dt);
        if (car.isCollided(carManager.getCars())) {
            gameStateManager.pop();
            gameStateManager.push(new MenuState(gameStateManager));
        }
    }

    @Override
    public void inputHandler() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            car.moveCar(-12);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            car.moveCar(12);
        }
    }

    @Override
    public void dispose() {
        car = null;
        roadManager = null;
        coinManager = null;
        font.dispose();
    }

}
