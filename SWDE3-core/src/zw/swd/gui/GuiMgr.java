package zw.swd.gui;

import java.util.HashMap;

import zw.swd.screen.SWDScreen;
import zw.swd.utils.FaceLoader;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GuiMgr extends Stage {

	public SWDScreen screen;
	public HashMap<String,Paper> controls=new HashMap<String, Paper>();
	public GuiMgr(SWDScreen screen) {
		// TODO Auto-generated constructor stub
		this.screen=screen;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.addActor(new Dialog1());
		this.findActorByName("gui/dialog1").setVisible(false);
	}

	@Override
	public void addAction(Action action) {
		// TODO Auto-generated method stub
		super.addAction(action);
	}
	public Actor findActorByName(String name)
	{
		return getRoot().findActor(name);
	}
	
	
}
