package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.sprites.Car;
import com.mygdx.game.sprites.Coin;
import com.mygdx.game.sprites.Road;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class CoinManager {

    private List<Coin> coins;
    private Random random;
    private int score;

    public CoinManager() {
        coins = new LinkedList<>();
        random = new Random();
        for (int i = 0; i < 50; i++) {
            coins.add(new Coin("coin.gif", 100, MyGdxGame.HEIGHT));
        }
    }

    public void update(float dt) {
        coinGenerator();
        coins.forEach(coin -> {
            coin.update(dt);
            handleIfOutOfTheRoad(coin);
        });
    }

    public void drawCoins(SpriteBatch spriteBatch) {
        coins.stream().filter(Coin::isVisible)
                .forEach(coin -> spriteBatch.draw(coin.getTexture(), coin.getPosition().x, coin.getPosition().y));
    }

    public int checkForCollision(Car car) {
        score = 0;

        for (Coin coin : coins) {
            if (coin.isCollided(car) && coin.isVisible()) {
                coin.setVisible(false);
                score++;
            }
        }
        return score;
    }

    private void handleIfOutOfTheRoad(Coin coin) {
        if (coin.getPosition().y < -Road.HEIGHT) {
            coin.setVisible(false);
        }
    }

    public List<Coin> getCoins() {
        return coins;
    }

    private void generateRow(int length) {
        int x = random.nextInt(400);
        AtomicInteger count = new AtomicInteger(0);
        coins.stream().filter(coin -> !coin.isVisible()).limit(length).forEach(coin -> {
            coin.setPosition(new Vector3(x, MyGdxGame.HEIGHT + coin.getTexture().getHeight() * count.get(), 0));
            coin.setVisible(true);
            count.addAndGet(1);
        });
    }

    private void coinGenerator() {
        if (random.nextDouble() < 0.009) {
            generateRow(random.nextInt(10) + 1);
        }
    }
}
