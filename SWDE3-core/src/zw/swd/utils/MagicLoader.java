package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import zw.swd.Cache;
import zw.swd.Config;
import zw.swd.game.MagicModel;
import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.graphics.FrameKey;

public class MagicLoader {

	public static void loadMagic(String code)
	{
		MagicModel model=new MagicModel();
		File file=new File(Config.resPath+"\\magic\\scripts\\"+code+".txt");
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line;
		while((line=br.readLine())!=null)
		{
			if(line.indexOf("code")==0)
			{
				model.code=code;
			}
			if(line.indexOf("name")==0)
			{
				String name=line.split(":")[1];
				model.name=name;
			}
			if(line.indexOf("description")==0)
			{
				String description=line.split(":")[1];
				model.description=description;
			}
			if(line.indexOf("type")==0)
			{
				String type=line.split(":")[1];
				model.displayType=Integer.parseInt(type);
			}
			if(line.indexOf("element")==0)
			{
				String element=line.split(":")[1];
				model.element=Integer.parseInt(element);
			}
			if(line.indexOf("castToAllies")==0)
			{
				String castToAllies=line.split(":")[1];
				model.castToAllies=Boolean.parseBoolean(castToAllies);
			}
			if(line.indexOf("mpCost")==0)
			{
				String mpCost=line.split(":")[1];
				model.mpCost=Integer.parseInt(mpCost);
			}
			if(line.indexOf("length")==0)
			{
				String length=line.split(":")[1];
				Animation animation=new Animation();
				for(int i=1;i<Integer.parseInt(length)+1;i++)
				{
					Frame frame=new Frame();
					FrameKey key=new FrameKey();
					key.texture=new TextureRegion(new Texture(Gdx.files.absolute(Config.resPath+"\\magic\\"+code+"-"+i+".png")));
					frame.keys.add(key);
					animation.addFrame(frame);
				}
				animation.code="magic/"+code;
			}
		}
		Cache.magics.put(code, model);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void loadMagics(String...codes)
	{
		for(String code:codes)
		{
			loadMagic(code);
		}
	}
}
