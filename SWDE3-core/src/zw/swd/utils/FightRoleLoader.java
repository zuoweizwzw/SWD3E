package zw.swd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import zw.swd.Cache;
import zw.swd.Config;
import zw.swd.graphics.Animation;
import zw.swd.graphics.Frame;
import zw.swd.graphics.FrameKey;
import zw.swd.math.Vector2;

public class FightRoleLoader {

	public static void loadFightRole(String roleID){
		File dir=new File(Config.resPath+"\\char\\"+roleID+"\\fight");
		for(File file:dir.listFiles())
		{
			try
			{
				Animation animation=new Animation();
				BufferedReader br=new BufferedReader(new FileReader(file));
				String line;
				line=br.readLine();
				String code=line;
				String id=br.readLine();
				String foot_str=br.readLine();
				int offsetX=Integer.parseInt(foot_str.split(",")[0]);
				int offsetY=Integer.parseInt(foot_str.split(",")[1]);
				animation.mainOffset=new Vector2(offsetX, offsetY);
				int leftAlign=Integer.parseInt(br.readLine());
				int length=Integer.parseInt(br.readLine());
				
				
				for(int i=1;i<length+1;i++)
				{
					Frame frame=new Frame();
					float duration=Float.parseFloat(br.readLine());
					frame.duration=duration;
					int keyNum=Integer.parseInt(br.readLine());
					for(int j=0;j<keyNum;j++)
					{
						FrameKey key=new FrameKey();
						
						String imgRes=br.readLine();
						key.texture=new TextureRegion(new Texture(Gdx.files.absolute(Config.resPath+"\\"+imgRes)));
						frame.keys.add(key);
					}
					animation.addFrame(frame);
				}
				Cache.fightRoles.put(id, animation);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
