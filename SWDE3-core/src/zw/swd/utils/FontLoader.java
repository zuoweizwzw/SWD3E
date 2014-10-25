package zw.swd.utils;

import org.jrenner.smartfont.SmartFontGenerator;

import zw.swd.Config;
import zw.swd.gui.SWDFont;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontLoader {

	public static BitmapFont font24,font18;
	private static SWDFont swdFont;
	public static void loadFont()
	{		
		font24 = new BitmapFont(Gdx.files.absolute(Config.resPath+"\\font\\simsun_bmfont24\\simsun.fnt"), false);
		font18 = new BitmapFont(Gdx.files.absolute(Config.resPath+"\\font\\simsun_bmfont18\\simsun.fnt"), false);
		
	}
	public static SWDFont getSWDFont()
	{
		if(swdFont==null)
		{
			swdFont=new SWDFont();
		}
		return swdFont;
	}
}
