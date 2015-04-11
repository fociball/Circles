package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.TimeUtils;
import com.nick.gameproject.screens.Splash;

public class Circles extends Game {
	
	private int rendCount; //** render count **//
	private long startTime; //** time app started **//
	private long endTime; //** time app ended **//
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
    private Skin skin;
    private Stage stage;
    
    @Override
    public void create() { 
    	Gdx.app.log("my Splash Game","App created");
    	startTime = TimeUtils.millis();
    	setScreen(new Splash());
    }

    @Override
    public void dispose() {
    	Gdx.app.log("my Splash Game", "App rendered " + rendCount + " times");
        Gdx.app.log("my Splash Game", "App ended");
        endTime = TimeUtils.millis();
        Gdx.app.log("my Splash Game", "App running for " + (endTime-startTime)/1000 + " seconds.");
  
    }

    @Override
    public void render() { 
    	 super.render();
         rendCount++; //** another render - inc count **//
 
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}