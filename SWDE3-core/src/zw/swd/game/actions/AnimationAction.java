package zw.swd.game.actions;

import zw.swd.graphics.Animation;
import zw.swd.graphics.Sprite;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AnimationAction extends Action {

	public int state=0;
	public Animation animation;
	public Sprite actor;
	
	
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(state==2) return true;
		if(state==0)
		{
			this.actor.setAnimation(animation);
			state=1;
		}
		if(state==1) 
		{
			if(animation.currentFrame==animation.frames.size()-1)
			{
				state=2;
				return true;
			}
			else animation.nextFrame(delta);
		}
		
		return false;
	}

	public AnimationAction(Sprite actor,Animation animation) {
		// TODO Auto-generated constructor stub
		this.animation=animation;
		animation.restart();
		animation.autoUpdate=false;
		this.actor=actor;
	}
	
//	@Override
//	public void setActor(Actor actor) {
//		// TODO Auto-generated method stub
//		super.setActor(actor);
//		if(actor!=null)
//			{
//				Sprite sprite=(Sprite)actor;
//				sprite.currentAnimation=animation;
//			}
//	}
}
