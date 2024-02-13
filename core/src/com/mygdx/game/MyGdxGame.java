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

    Astronaut astronaut;
    Ufo[] ufos;

    Random random;

    @Override
    public void create() {
        batch = new SpriteBatch();
        random = new Random();

        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();

        astronaut = new Astronaut(
                new Texture("astronaut.png"),
                100,
                100,
                100,
                100
        );

        ufos = new Ufo[100];
        for (int i = 0; i < ufos.length; i++) {
            ufos[i] = new Ufo(
                    new Texture("ufo.png"),
                    random.nextInt(10000),
                    random.nextInt(SCREEN_HEIGHT - 50),
                    100,
                    50,
                    random.nextInt(1, 5)
            );
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 1, 1); ///rgb - red, green, blue, a - alhpa
        batch.begin();

        batch.draw(astronaut.texture, astronaut.x, astronaut.y, astronaut.width, astronaut.height);

        for (int i = 0; i < ufos.length; i++) {
            batch.draw(ufos[i].texture, ufos[i].x, ufos[i].y, 100, 50);

            ufos[i].moveX();
        }

        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
        astronaut.texture.dispose();
        for (int i = 0; i < ufos.length; i++) {
            ufos[i].texture.dispose();
        }
    }
}
