File f1 = new File(srFile);
File f2 = new File(dtFile);

InputStream in = new FileInputStream(f1);
OutputStream out = new FileOutputStream(f2, true); // appending output stream

try {
	IOUtils.copy(in, out);
}
finally {
	IOUtils.closeQuietly(in);
	IOUtils.closeQuietly(out);
}