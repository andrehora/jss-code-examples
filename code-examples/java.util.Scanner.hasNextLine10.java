public boolean isVnrMapped() throws FileNotFoundException {
	
	try{
		  Thread.currentThread().sleep(500);
		}catch(InterruptedException ie){
		//If this thread was interrupted by another thread 
		}
	String filePath = MATLAB_PATH + MAPPING_PERFORMED + virtualNetReqNumber;
	fFile = new File(filePath);
	Scanner scanner = new Scanner(fFile);
	String[] decision;
	while (scanner.hasNextLine()) {

		decision = scanner.nextLine().split("   ");
		if (((int) (Double.parseDouble(decision[1]))) == 1) {
			return true;
		} else {
			return false;
		}
	}
	scanner.close();
	return false;
}