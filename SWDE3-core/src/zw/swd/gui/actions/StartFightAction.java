package zw.swd.gui.actions;

import zw.swd.SWDMain;
import zw.swd.screen.FightScreen;
import zw.swd.screen.SWDScreen;
import zw.swd.utils.TestUtils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;

public class StartFightAction extends Action{

	public SWDScreen screen;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		SWDMain game=(SWDMain)Gdx.app.getApplicationListener();
		game.changeScreen(new FightScreen(TestUtils.generateFightModel()));
		return true;
	}
	
	public StartFightAction(SWDScreen screen) {
		// TODO Auto-generated constructor stub
		this.screen=screen;
	}

}
