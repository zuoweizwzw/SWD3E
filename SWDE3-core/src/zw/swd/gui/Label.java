package zw.swd.gui;

import zw.swd.utils.FontLoader;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Label extends Paper{
	public BitmapFont font;
	public String text="";
	@Override
	public void drawCustomer(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.setShader(FontLoader.fontShader);
		font.draw(batch, text, this.getX(), this.getY());
		batch.setShader(null);
	}

	public Label() {
		// TODO Auto-generated constructor stub
		font=FontLoader.font18;
		font.setMarkupEnabled(true);
	}
	public void setText(String  text)
	{
		this.text=text;
	}
}
