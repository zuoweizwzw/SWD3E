package swd.game.action

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

abstract class Actor {

	SequenceAction rootAction=new Sequence();
	
	public void addAction(Action action)
	{
		if(rootAction.status==2) rootAction.status=0;
		rootAction.addAction(action);
	}
	public void act(GameContainer container, StateBasedGame game, int delta)
	{
		if(rootAction!=null) rootAction.act(container, game,delta);
		
	}
	public void render(GameContainer container, StateBasedGame game, Graphics g)
	{
		
	}
}
