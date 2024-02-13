package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * @author y.gladkikh
 */
public class Ufo {

    Texture texture;
    int x;
    int y;

    int width;

    int height;

    int speed;

    void moveX() {
        x --;
    }
}
