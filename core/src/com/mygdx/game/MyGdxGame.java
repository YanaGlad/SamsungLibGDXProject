package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    int SCREEN_WIDTH;
    int SCREEN_HEIGHT;

    int xStart = 0;
    int yStart = 0;

    MovingImage movingImage;
    MovingImage movingImage2;

    @Override
    public void create() {
        batch = new SpriteBatch();

        movingImage = new MovingImage();
        movingImage2 = new MovingImage();

        movingImage.img = new Texture("badlogic.jpg");
        movingImage2.img = new Texture("badlogic.jpg");

        movingImage.speed = 5;
        movingImage2.speed = 1;

        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();

        movingImage2.x = movingImage2.getEdgePointX(SCREEN_WIDTH, movingImage2.img);
        movingImage2.y = movingImage2.getEdgePointY(SCREEN_HEIGHT, movingImage2.img);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 1, 1); ///rgb - red, green, blue, a - alhpa
        batch.begin();

        batch.draw(movingImage.img, movingImage.x, movingImage.y);
        batch.draw(movingImage2.img, movingImage2.x, movingImage2.y);

        movingImage.moveX(SCREEN_WIDTH, xStart);
        movingImage.moveY(SCREEN_HEIGHT, yStart);

        movingImage2.moveX(SCREEN_WIDTH, xStart);
        movingImage2.moveY(SCREEN_HEIGHT, yStart);

        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
        movingImage.img.dispose();
    }
}
