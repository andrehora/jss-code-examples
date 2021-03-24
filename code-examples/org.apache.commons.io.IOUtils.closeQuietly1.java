BufferedWriter bw = null;

try {
    bw = new BufferedWriter(new FileWriter("test.txt"));
    bw.write("test");
    bw.flush(); // you can omit this if you don't care about errors while flushing
    bw.close(); // you can omit this if you don't care about errors while closing
} catch (IOException e) {
    // error handling (e.g. on flushing)
} finally {
    IOUtils.closeQuietly(bw);
}