package zw.swd.graphics;

import zw.swd.math.Vector2;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * @author zuowei
 *
 */
/**
 * @author zuowei
 *
 */
public class Sprite extends Actor{
	private Animation currentAnimation;
	public Vector2 mainOffset=new Vector2();
	private Vector2 coord=new Vector2();
	public Rectangle collisBox;
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
	if(currentAnimation!=null) 
		{
		
			currentAnimation.draw(this.getX(), this.getY(), batch,getColor(),parentAlpha);
			if(currentAnimation.frames.size()>0)
			{
				this.setHeight(currentAnimation.getSize().y);
				this.setWidth(currentAnimation.getSize().x);
			}
		}
	
	}

	public void setAutoUpdate(boolean autoUpdate)
	{
		this.currentAnimation.autoUpdate=autoUpdate;
	}
	
	public Sprite(String filePath) {
		// TODO Auto-generated constructor stub
		currentAnimation=new Animation(filePath);
	}
	
	
	public Sprite(){
		
	}
	
	public void setAnimation(Animation animation)
	{
		this.currentAnimation=animation;
		this.mainOffset=animation.mainOffset;
		this.setPosition(this.coord.x-animation.mainOffset.x, this.coord.y-animation.mainOffset.y);
		this.collisBox=animation.colisBox;
	}
	
	public void setCoord(float x, float y)	
	{
		this.coord.set(x, y);
		if(this.currentAnimation!=null)
		{
			this.setPosition(x-currentAnimation.mainOffset.x, y-currentAnimation.mainOffset.y);
		}
	}
	
	public Animation getCurrentAni()
	{
		return this.currentAnimation;
	}
	
	@Override
	public void moveBy(float x, float y) {
		// TODO Auto-generated method stub
		if (x != 0 || y != 0) {
			this.coord.x += x;
			this.coord.y += y;
			this.setCoord(coord.x, coord.y);
			positionChanged();
		}
	}
	
	
	/**
	 * get center point from local position
	 */
	public Vector2 getCenterPoint()
	{
		return new Vector2(this.getX()+this.currentAnimation.centerPoint.x,this.getY()+this.currentAnimation.centerPoint.y);
	}
}
