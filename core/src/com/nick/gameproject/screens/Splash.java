package com.nick.gameproject.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Splash implements Screen {

    private Texture texture = new Texture(Gdx.files.internal("splash.png"));
    private Image splashImage = new Image(texture);
    private Stage stage = new Stage();
    
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		splashImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.addActor(splashImage);
        
        splashImage.addAction(Actions.sequence(Actions.alpha(0)
                       ,Actions.fadeIn(0.5f),Actions.delay(2),Actions.run(new Runnable() {
            @Override
            public void run() {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu());
            }
        })));


	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0,0,0,1); //sets clear color to black
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clear the batch
	    stage.act(); //update all actors
	    stage.draw(); //draw all actors on the Stage.getBatch()

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	     dispose();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	    texture.dispose();
        stage.dispose();

	}

}
