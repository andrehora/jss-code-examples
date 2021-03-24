public class BufferedReaderReadExample {

	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("D:/data/file.txt");
			bufferedReader = new BufferedReader(fileReader);
			
			int val = 0;
			while ((val = bufferedReader.read()) != -1) {
				char c = (char) val;
				//prints the character
				System.out.print(c);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}