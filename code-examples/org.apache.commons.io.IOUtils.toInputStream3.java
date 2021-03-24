private static InputStream convertStringToInputStreamCommonIO(String name) {

        InputStream result = IOUtils.toInputStream(name, StandardCharsets.UTF_8);
        return result;

}