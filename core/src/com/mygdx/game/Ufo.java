package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import org.w3c.dom.Text;

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

    public Ufo(Texture texture, int x, int y, int width, int height, int speed) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    void moveX() {
        x --;
    }
}
