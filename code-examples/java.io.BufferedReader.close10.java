private String readStringFromFile(File file) throws IOException {
    StringBuffer buff = new StringBuffer();
    
    BufferedReader rdr = new BufferedReader(new FileReader(file));
    
    String line;
    
    try{
        while ((line = rdr.readLine()) != null){
            buff.append(line + "\n");
        }
    } finally{
        rdr.close();
    }
    
    return buff.toString();
}