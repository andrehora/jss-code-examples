public class solution { 
	public static void main(String args[]) 
	{ 

		// Get the file 
		File f = new File("F:\\program.txt"); 

		// Check if the specified file 
		// Exists or not 
		if (f.exists()) 
			System.out.println("Exists"); 
		else
			System.out.println("Does not Exists"); 
	} 
}