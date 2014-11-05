package zw.swd.gui;

import zw.swd.graphics.Animation;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Picture extends Paper{

	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}
	public Picture() {
		// TODO Auto-generated constructor stub
		
	}
	public Picture(String fightAvatar) {
		// TODO Auto-generated constructor stub
		this.setAnimation(new Animation(fightAvatar));
	}
	

	
}
