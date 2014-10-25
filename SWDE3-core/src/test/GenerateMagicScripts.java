package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class GenerateMagicScripts {

	public static void main(String[] args)
	{
		File dir=new File("F:\\SWD3E\\magic");
		
		List<String> fileList=Arrays.asList(dir.list());
		for(int i=1;i<406;i++)
		{
			int j=1;
			
			while(fileList.contains(new Integer(i).toString()+"-"+new Integer(j).toString()+".png"))
			{
				j++;
			}
			j--;
			String id=new Integer(i).toString();
			File output=new File("F:\\SWD3E\\magic\\scripts\\"+id+".txt");
			if(output.exists())
			{
				output.delete();
			}

			try
			{
			output.createNewFile();
			BufferedWriter bw=new BufferedWriter(new FileWriter(output));
			bw.write("code:"+id);
			bw.newLine();
			bw.write("name:"+"none");
			bw.newLine();
			bw.write("description:"+"none");
			bw.newLine();
			bw.write("type:"+"1");
			bw.newLine();
			bw.write("element:"+"0");
			bw.newLine();
			bw.write("castToAllies:"+"false");
			bw.newLine();
			bw.write("mpCost:"+100);
			bw.newLine();
			bw.write("length:"+j);
			bw.flush();
			bw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		
	}
}
