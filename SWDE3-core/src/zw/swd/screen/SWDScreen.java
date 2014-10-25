package zw.swd.screen;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Sprite;
import zw.swd.graphics.SpriteMgr;
import zw.swd.graphics.scene.SceneMap;
import zw.swd.gui.GuiMgr;
import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public abstract class SWDScreen implements Screen,InputProcessor{
	public SpriteMgr spriteMgr;
	public GuiMgr guiMgr;
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spriteMgr.draw();
		spriteMgr.act(delta);
		
		
		guiMgr.draw();
		guiMgr.act(delta);
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	public SWDScreen() {
		// TODO Auto-generated constructor stub
		this.spriteMgr=new SpriteMgr(this);
		this.guiMgr=new GuiMgr(this);
		
		
	}

	public void enterScreen()
	{
		
	}
	
	public abstract void init();
}
