package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    int SCREEN_WIDTH;
    int SCREEN_HEIGHT;

    int xStart = 0;

    boolean xRight = true;

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
        if (x < SCREEN_WIDTH - img.getWidth() && xRight) {
            x++;
        } else {
            xRight = false;
        }

        if (x > xStart && !xRight) {
            x--;
        } else {
            xRight = true;
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
