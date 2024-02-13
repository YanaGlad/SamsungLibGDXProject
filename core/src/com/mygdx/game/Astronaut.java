package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * @author y.gladkikh
 */
public class Astronaut {

    Texture texture;

    int x;

    int y;

    int width;

    int height;

    public Astronaut(Texture texture, int _x, int y, int width, int height) {
        this.texture = texture;
        x = _x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
