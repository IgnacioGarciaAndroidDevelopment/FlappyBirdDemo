package com.nacho.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nacho.game.FlappyDemo;

/**
 * Created by nacho on 29/10/16.
 */

public class GameOverState extends  State {
    private Texture background;
    public GameOverState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH/2, FlappyDemo.HEIGHT/2);
        background =new Texture("gameover.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        //sb.draw(background, cam.position.x - background.getWidth()/2, cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
