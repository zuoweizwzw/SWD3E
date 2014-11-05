package zw.swd.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;

import org.jrenner.smartfont.SmartFontGenerator;

import sun.font.TrueTypeFont;
import sun.nio.cs.UnicodeEncoder;
import sun.text.normalizer.UnicodeSet;
import zw.swd.Config;
import zw.swd.gui.SWDFont;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class FontLoader {

	public static BitmapFont font24,font18;
	private static SWDFont swdFont;
	private static  FreeTypeFontGenerator generator;
	public static ShaderProgram fontShader;
	public static void loadFont()
	{		
//		font24 = new BitmapFont(Gdx.files.absolute(Config.resPath+"\\font\\simsun_bmfont24\\simsun.fnt"), false);
//		font18 = new BitmapFont(Gdx.files.absolute(Config.resPath+"\\font\\simsun_bmfont18\\simsun.fnt"), false);
		generator = new FreeTypeFontGenerator( Gdx.files.absolute(Config.resPath+"\\font\\simhei.ttf") );
		FreeTypeFontParameter p18=(new FreeTypeFontParameter());
		FreeTypeFontParameter p24=(new FreeTypeFontParameter());
		p18.size=18;
		p24.size=24;
		StringBuffer sb=new StringBuffer();
		loadCharset(sb);
		
		
		p18.characters=sb.toString();
		FreeType d;
		
		font18=generator.generateFont(p18);
		font18.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		font24=generator.generateFont(p24);
		font18.setColor(Color.RED);
	}
	public static SWDFont getSWDFont()
	{
		if(swdFont==null)
		{
			swdFont=new SWDFont();
		}
		return swdFont;
	}

	public static void loadCharset(StringBuffer sb)
	{
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(Config.resPath+"\\font\\simple.txt"));
		String line;
		while((line=br.readLine())!=null)
			{
				sb.append(line);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
