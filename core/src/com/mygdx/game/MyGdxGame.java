package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture img2;
    int SCREEN_WIDTH;
    int SCREEN_HEIGHT;

    int xStart = 0;
    int yStart = 0;

    boolean xRight = true; // движемся ли вправо?
    boolean yUp = true; // движемся ли вверх?

    int x = 0;
    int y = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 1, 1); ///rgb - red, green, blue, a - alhpa
        batch.begin();

        batch.draw(img, x, y);

        moveX();
        moveY(yStart, img);

        batch.end();
    }

    public void moveY(int yStart, Texture image) {
        if (y < getEdgePointY(image) && yUp == true) {
            y++;
        } else {
            yUp = false;
        }

        if (y > yStart && yUp == false) {
            y--;
        } else {
            yUp = true;
        }
    }

    public void moveX() {
        if (x < getEdgePointX(img) && xRight) {
            x++;
        } else {
            xRight = false;
        }

        if (x > xStart && !xRight) {
            x--;
        } else {
            xRight = true;
        }
    }

    public int getEdgePointX(Texture image) {
        return SCREEN_WIDTH - image.getWidth();
    }

    public int getEdgePointY(Texture image) {
        return SCREEN_HEIGHT - image.getHeight();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
