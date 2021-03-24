public ExtClassLoader() throws IOException {
    super(Thread.currentThread().getContextClassLoader());

    {
        byte[] bytes;
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("kotlin/ResponseKotlin2.clazz");
        bytes = IOUtils.toByteArray(is);
        is.close();

        super.defineClass("ResponseKotlin2", bytes, 0, bytes.length);
    }
}