package com.nick.gameproject.screens;

import java.util.Iterator;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
	
public class gameScreen implements Screen, ApplicationListener, InputProcessor {
	    private Stage stage = new Stage();
	    private SpriteBatch batch = new SpriteBatch();
	    private MyActor player = new MyActor();
	    private MyActor enemy = new MyActor();
	    
	    
	    
	    
	    public class MyActor extends Actor {
	    	Texture texture = new Texture(Gdx.files.internal("badlogic.jpg"));
	        public boolean started = false;

	        public MyActor(){
	            setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
	        }
	        
	        @Override
	        public void draw(Batch batch, float alpha){
	        	batch.draw(texture,this.getX(),getY(),this.getOriginX(),this.getOriginY(),this.getWidth(),
	                    this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),0,0,
	                    texture.getWidth(),texture.getHeight(),false,false);
	           
	        }
	        
	        public void act(float delta){
	            for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
	                iter.next().act(delta);
	            }
	        }
	    }
	    
	    
	    @Override
	    public void create() {        
	 
	    	 
	      
	    }

	    @Override
	    public void dispose() {
	 
	    }

	    @Override
	    public void render() {        
			
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

	    @Override
	    public boolean keyDown(int keycode) {
	        // TODO Auto-generated method stub
	        return false;
	    }

	    @Override
	    public boolean keyUp(int keycode) {
	        // TODO Auto-generated method stub
	        return false;
	    }

	    @Override
	    public boolean keyTyped(char character) {
	        // TODO Auto-generated method stub
	        return false;
	    }

	    @Override
	    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	    	screenY = (int) (Gdx.graphics.getHeight() - screenY);
	    	MoveToAction moveAction = new MoveToAction();	    	
	        player.addAction(Actions.moveTo(Gdx.input.getX(), (Gdx.graphics.getHeight()-Gdx.input.getY()), 1));

	        return true;
	    }

	    @Override
	    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	       
	        return true;
	    }

	    @Override
	    public boolean touchDragged(int screenX, int screenY, int pointer) {
	    	screenY = (int) (Gdx.graphics.getHeight() - screenY);
	    	MoveToAction moveAction = new MoveToAction();	    	
	        player.addAction(Actions.moveTo(Gdx.input.getX(), (Gdx.graphics.getHeight()-Gdx.input.getY()), 1));
	        return false;
	    }

	    @Override
	    public boolean mouseMoved(int screenX, int screenY) {
	        // TODO Auto-generated method stub
	        return false;
	    }

	    @Override
	    public boolean scrolled(int amount) {
	        // TODO Auto-generated method stub
	        return false;
	    }

		@Override
		public void show() {
			// TODO Auto-generated method stub
		   	 stage = new Stage();
	         Gdx.input.setInputProcessor(this);
	         
	         Texture texture = new Texture(Gdx.files.internal("player.png"));
	         player.texture = texture;
	         player.setSize(24, 24);
	         player.setOrigin(12,12);
	         stage.addActor(player);
	         
	         texture = new Texture(Gdx.files.internal("enemy.png"));
	         enemy.texture = texture;
	         enemy.setSize(64, 64);
	         enemy.setOrigin(32, 32);
	         
	         MoveToAction moveAction = new MoveToAction();
	         ScaleToAction scaleAction = new ScaleToAction();
	         scaleAction.setScale(2f);
	         scaleAction.setDuration(5f);
	       
	         
	         
	         moveAction.setPosition(MathUtils.random(Gdx.graphics.getWidth()-64), MathUtils.random(Gdx.graphics.getHeight()-64));
	         //moveAction.setDuration(10f);
	         
	         enemy.addAction(moveAction);
	           enemy.addAction(scaleAction);
	     
	         stage.addActor(enemy);
	       
		}

		@Override
		public void render(float delta) {
			// TODO Auto-generated method stub
			Gdx.gl.glClearColor(1,1,1,1); //sets clear color to black
		    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clear the batch
		    stage.act(Gdx.graphics.getDeltaTime()); //update all actors
		    stage.draw(); //draw all actors on the Stage.getBatch()

		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
		}
}
