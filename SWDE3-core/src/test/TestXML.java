package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class TestXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XmlReader reader=new XmlReader();
		try {
			Element element=reader.parse(new FileInputStream("F:\\SWD3E\\gui\\scripts\\1.xml"));
			System.out.println(element.getChild(0).get("type"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
