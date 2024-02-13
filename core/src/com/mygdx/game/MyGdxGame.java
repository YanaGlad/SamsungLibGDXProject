package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    int SCREEN_WIDTH;
    int SCREEN_HEIGHT;

    int xStart = 0;
    int yStart = 0;

    MovingImage[] movingImages;

    Random random;

    @Override
    public void create() {
        batch = new SpriteBatch();
        random = new Random();

        movingImages = new MovingImage[10];
        movingImages[0] = new MovingImage();
        movingImages[0].img = new Texture("badlogic.jpg");
        movingImages[0].speed = 5;

        movingImages[1] = new MovingImage();
        movingImages[1].img = new Texture("badlogic.jpg");
        movingImages[1].speed = 1;
        movingImages[1].x = movingImages[1].getEdgePointX(SCREEN_WIDTH, movingImages[1].img);
        movingImages[1].y = movingImages[1].getEdgePointY(SCREEN_HEIGHT, movingImages[1].img);

        for (int i = 2; i < movingImages.length; i++) {
            movingImages[i] = new MovingImage();
            movingImages[i].img = new Texture("badlogic.jpg");
            movingImages[i].speed = random.nextInt(1,  5);
            movingImages[i].x = random.nextInt(200);
            movingImages[i].y = random.nextInt(300);
        }

        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 1, 1); ///rgb - red, green, blue, a - alhpa
        batch.begin();

        for (int i = 0; i < movingImages.length; i++) {
            batch.draw(movingImages[i].img, movingImages[i].x, movingImages[i].y);

            movingImages[i].moveX(SCREEN_WIDTH, xStart);
            movingImages[i].moveY(SCREEN_HEIGHT, yStart);
        }
        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
        for (int i = 0; i < movingImages.length; i++) {
            movingImages[i].img.dispose();
        }
    }
}
