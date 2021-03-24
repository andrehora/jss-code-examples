public void writeBinaryStream(java.io.InputStream x) throws SQLException {
     BufferedReader bufReader = new BufferedReader(new InputStreamReader(x));
     try {
           int i;
         while( (i=bufReader.read()) != -1 ) {
            char ch = (char)i;

            StringBuffer strBuf = new StringBuffer();
            strBuf.append(ch);

            String str = new String(strBuf);
            String strLine = bufReader.readLine();

            writeString(str.concat(strLine));
         }
    } catch(IOException ioe) {
        throw new SQLException(ioe.getMessage());
    }
}