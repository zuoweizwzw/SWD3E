package zw.swd.graphics;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class Frame {

	public ArrayList<FrameKey> keys=new ArrayList<FrameKey>();
	public float duration;
	public void draw(float x, float y, Batch batch, Color color, float parentAlpha) {
		// TODO Auto-generated method stub
		for(FrameKey key:keys)
		{
			key.draw(x,y,batch,color,parentAlpha);
		}
	}
}
