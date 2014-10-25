package zw.swd.gui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import zw.swd.graphics.Animation;
import zw.swd.utils.FontLoader;

public abstract class Paper extends Group{

	protected Animation currentAnimation;
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		if(!this.isVisible()) return;
		if(currentAnimation!=null) 
		{		
			currentAnimation.draw(this.getX(), this.getY(), batch,getColor(),parentAlpha);	
		}
		
		drawCustomer(batch,parentAlpha);
		
		super.draw(batch, parentAlpha);
	}

	public abstract void drawCustomer(Batch batch, float parentAlpha);
	
	public Vector2 getStagePosition()
	{
		Vector2 v=this.localToStageCoordinates(new Vector2(this.getX(),this.getY()));
		return v;
	}
	public Paper() {
		// TODO Auto-generated constructor stub
		
	}
	public void setAnimation(Animation animation)
	{
		this.currentAnimation=animation;
		if(animation.frames.size()>0) this.setWidth(animation.frames.get(0).keys.get(0).texture.getRegionWidth());
	}
}
