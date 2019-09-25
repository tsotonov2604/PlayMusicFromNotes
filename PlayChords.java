package assignment2;
import algs4.*; 
/* 
* <Tsvety Sotonov>
*<Play Chords>
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * <Tsvety Sotonov>
 * <Play Chords>
 */
public class PlayChords 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
	//Scanners to hold files 
	Scanner scan=new Scanner(new File("data/chords.txt"));
	Scanner scan2=new Scanner(new File("data/notes_frequencies.txt"));

	//Read lines from chords
	String[] notes=StdIn.readAllLines();

	//Loop through chords
	for (String string : notes) 
	{
	//Split the string
		String[] lines=string.split(" ");
		String note=lines[0];

	//Set scan to point to other file
	//Loop through notes_frequency 
	while(scan2.hasNextLine())
	{
		//Read the Line
		String line=StdIn.readLine();
		
		//Split the line
		String[] frequencyLines=line.split("    ");
		
		//if the note matches the input note then call the playChordOneSecond method
		if(note.equals(frequencyLines[0]))
		{
			//Convert frequency to a float 
			Float frequency=Float.parseFloat(frequencyLines[1]);

	playChordOneSecond(frequency);

	break;
		}

	}

	}
	scan.close(); 
	scan2.close(); 
	}

	//Method to play the tone

	public static void playChordOneSecond(double... frequencies) 
	{
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * 1.0);
		final double[] slices = new double[sliceCount+1];
		for (double frequency: frequencies) 
		{
			for (int i = 0; i <= sliceCount; i++) 
			{
				slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
			}
		}
		StdAudio.play(slices);
	}

}

