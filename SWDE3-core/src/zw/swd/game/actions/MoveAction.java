package zw.swd.game.actions;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Sprite;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.RelativeTemporalAction;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

public class MoveAction extends RelativeTemporalAction {

	public int state=0;
	public Animation animation;
	public Sprite actor;
	public Vector2 delta;
	
	
	
	
	public MoveAction(Sprite actor,int deltaX, int deltaY, float duration) {
		// TODO Auto-generated constructor stub
		this.actor=actor;
		this.delta=new Vector2(deltaX, deltaY);
		this.setDuration(duration);
		
	}



	@Override
	protected void updateRelative(float percentDelta) {
		// TODO Auto-generated method stub
		this.actor.moveBy(delta.x*percentDelta, delta.y*percentDelta);
	}



}
