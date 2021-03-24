protected void read(final ProtocolFactory protocols, final Local file) throws AccessDeniedException {
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(file.getInputStream(), Charset.forName("UTF-8")));
        try {
            String l;
            while((l = in.readLine()) != null) {
                Matcher array = Pattern.compile("\\[(.*?)\\]").matcher(l);
                while(array.find()) {
                    Matcher entries = Pattern.compile("\\{(.*?)\\}").matcher(array.group(1));
                    while(entries.find()) {
                        final String entry = entries.group(1);
                        this.read(protocols, entry);
                    }
                }
            }
        }
        finally {
            IOUtils.closeQuietly(in);
        }
    }
    catch(IOException e) {
        throw new AccessDeniedException(e.getMessage(), e);
    }
}