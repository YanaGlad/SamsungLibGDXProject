package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author y.gladkikh
 */
public class Astronaut implements InputProcessor {

    Texture texture;

    int x;

    int y;

    int width;

    int height;

    int speed = 5;

    boolean moveLeft = false;

    boolean moveRight = false;
    boolean moveUp = false;
    boolean moveDown = false;


    public Astronaut(Texture texture, int _x, int y, int width, int height) {
        Gdx.input.setInputProcessor(this);
        this.texture = texture;
        x = _x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move() {
        if (moveLeft == true) x -= speed;
        if (moveRight == true) x += speed;
        if (moveUp == true) y += speed;
        if (moveDown == true) y -= speed;
    }


    @Override
    public boolean keyDown(int keycode) { // нажатие клавиши
        switch (keycode) {
            case Input.Keys.LEFT:
                moveLeft = true;
                moveRight = false;
                break;
            case Input.Keys.RIGHT:
                moveRight = true;
                moveLeft = false;
                break;
            case Input.Keys.UP:
                moveUp = true;
                moveDown = false;
                break;
            case Input.Keys.DOWN:
                moveUp = false;
                moveDown = true;
                break;
            case Input.Keys.A:
                moveLeft = true;
                moveRight = false;
                break;
            case Input.Keys.D:
                moveRight = true;
                moveLeft = false;
                break;
            case Input.Keys.W:
                moveUp = true;
                moveDown = false;
                break;
            case Input.Keys.S:
                moveUp = false;
                moveDown = true;
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) { // отпускание клавиши
        switch (keycode) {
            case Input.Keys.LEFT:
            case Input.Keys.A:
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                moveRight = false;
                moveLeft = false;
                break;
            case Input.Keys.UP:
            case Input.Keys.S:
            case Input.Keys.W:
            case Input.Keys.DOWN:
                moveUp = false;
                moveDown = false;
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
