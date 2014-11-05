package swd.graphics

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;
import swd.game.action.Actor

class Sprite extends Actor{
	public Animation animation=new Animation();
	public Vector2f size=new Vector2f();
	public void update(GameContainer container, StateBasedGame game, int delta)
	{
		this.act(container,game,delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		// TODO Auto-generated method stub
		super.render(container, game, g);
	}
	
}
