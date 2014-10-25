package zw.swd;

import java.util.HashMap;

import zw.swd.exscreens.MapDefiner;
import zw.swd.exscreens.MapMatcher;
import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.graphics.FrameKey;
import zw.swd.screen.FightScreen;
import zw.swd.screen.SWDScreen;
import zw.swd.screen.SceneScreen;
import zw.swd.utils.FaceLoader;
import zw.swd.utils.FightMapLoader;
import zw.swd.utils.FightRoleLoader;
import zw.swd.utils.FontLoader;
import zw.swd.utils.MagicLoader;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Shape;

public class SWDMain extends Game {
	
	public HashMap<String,SWDScreen> screens=new HashMap<String, SWDScreen>();
	public SWDScreen currentScreen;
	@Override
	public void create () {
		
		initGame();
		SceneScreen screen=new SceneScreen();
		screens.put("scene", screen);
		Gdx.input.setInputProcessor(screen);
		this.setScreen(screen);
		this.currentScreen=screen;
		
//		MapMatcher matcher=new MapMatcher(batch);
//		setScreen(matcher);
//		Gdx.input.setInputProcessor(matcher);
		
//		MapDefiner definer=new MapDefiner(batch);
//		setScreen(definer);
//		Gdx.input.setInputProcessor(definer);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	public void initGame()
	{
		FontLoader.loadFont();
		FaceLoader.loadFaces();
		MagicLoader.loadMagics("51","78");
		FightMapLoader.loadFightMap("1-1");
		FightRoleLoader.loadFightRole("001");
	}
	
	public void changeScreen(SWDScreen screen)
	{
		if(screen instanceof FightScreen)
		{
			this.screens.put("fight", screen);
			this.screens.get("scene").pause();
			Gdx.input.setInputProcessor(screen);
			screen.init();
			this.setScreen(screen);
		}
		if(screen instanceof SceneScreen)
		{
			this.screens.remove("fight");
			Gdx.input.setInputProcessor(screen);
			this.setScreen(screen);
		}
		this.currentScreen=screen;
	}
	
}
