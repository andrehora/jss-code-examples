private static void setInputList(ArrayList<String> inputList)
  {
  	String[] id_data = null;
  	String line;
  	Scanner scan = new Scanner(System.in);
System.out.println("Enter UserId and a Date (yyyy-mm-dd) separated by a space!");
System.out.println("Enter -1 as UserId to stop");
do
{
	try
	{
		line = scan.nextLine();
		id_data = line.split(" ");
		Integer.parseInt(id_data[0]);
		if (!id_data[0].equals("-1") && isValideDate(id_data[1]))
			inputList.add(line);
		
	}
	catch(NumberFormatException e)
	{
		
	}
} while(!id_data[0].equals("-1"));
	scan.close();
}