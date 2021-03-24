public void readLinesTest(){
	try{
		InputStream is = new FileInputStream("D://test1.txt");
		List<String> lines = IOUtils.readLines(is);
		for(String line : lines){
			System.out.println(line);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}