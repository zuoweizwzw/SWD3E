package zw.swd.gui;

import zw.swd.utils.FontLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class ControlFactory {

	public static Paper getDialog1Back()
	{
		Paper paper=new Paper()
		{
			
			ShapeRenderer renderer=new ShapeRenderer();
			@Override
			public void drawCustomer(Batch batch, float parentAlpha) {
				// TODO Auto-generated method stub
				batch.end();
				Gdx.gl.glEnable(GL20.GL_BLEND);
				Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
				
				renderer.begin(ShapeType.Filled);
				renderer.setColor(this.getColor());
				Vector2 v=this.getStagePosition();
				renderer.rect(v.x,v.y, this.getWidth(), this.getHeight());
				
				renderer.end();
				
				batch.begin();
				
			}
			
			
		};
		paper.setWidth(640);
		paper.setHeight(140);
		paper.setColor(0,0,1,0.4f);
		return paper;
	}
}
