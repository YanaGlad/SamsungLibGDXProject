package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * @author y.gladkikh
 */
public class MovingImage {
    Texture img;
    boolean xRight = true; // движемся ли вправо?
    boolean yUp = true; // движемся ли вверх?
    int x = 0;
    int y = 0;

    int speed;

    public void moveY(int SCREEN_HEIGHT, int yStart) {
        if (y < getEdgePointY(SCREEN_HEIGHT, img) && yUp == true) {
            y+=speed;
        } else {
            yUp = false;
        }

        if (y > yStart && yUp == false) {
            y-=speed;
        } else {
            yUp = true;
        }
    }

    public void moveX(int SCREEN_WIDTH, int xStart) {
        if (x < getEdgePointX(SCREEN_WIDTH, img) && xRight) {
            x+=speed;
        } else {
            xRight = false;
        }

        if (x > xStart && !xRight) {
            x-=speed;
        } else {
            xRight = true;
        }
    }

    public int getEdgePointX(int SCREEN_WIDTH, Texture image) {
        return SCREEN_WIDTH - image.getWidth();
    }

    public int getEdgePointY(int SCREEN_HEIGHT, Texture image) {
        return SCREEN_HEIGHT - image.getHeight();
    }
}
