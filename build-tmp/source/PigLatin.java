import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {



public void setup() {
	String lines[] = loadStrings("words.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
	  System.out.println(pigLatin(lines[i]));
	}
}
public void draw()
{
}
public int findFirstVowel(String sWord)
{
	if(sWord.length()>0)
	{
		for(int i=0; i<sWord.length();i++)
		{
		if((sWord.substring(0+i,1+i).equals("a")) || (sWord.substring(0+i,1+i).equals("e")) || (sWord.substring(0+i,1+i).equals("i")) || (sWord.substring(0+i,1+i).equals("o")) || (sWord.substring(0+i,1+i).equals("u")))
		{
			return i;
		}
		}
	}
	return -1;
}

public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
	if(findFirstVowel(sWord) == -1)
	{
		return sWord + "ay";
	}
	else if((sWord.substring(0,1)).equals("a") || (sWord.substring(0,1)).equals("e") || (sWord.substring(0,1)).equals("i") || (sWord.substring(0,1)).equals("o") || (sWord.substring(0,1)).equals("u"))
	{
		return sWord + "way";
	}
	else if(sWord.substring(0,2).equals("qu"))
	{
		return sWord.substring(2,sWord.length()) + "quay";
	}
	else
	{
		return sWord.substring(findFirstVowel(sWord),sWord.length()) + sWord.substring(0,findFirstVowel(sWord)) + "ay";	
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
