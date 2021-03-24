public CSVFormat injectHeaderFormat(CSVFormat format)
{
    String[] names = new String[headers.length];
    int i = 0;
    for (Entry header : headers) {
        names[i] = header.name;
        i += 1;
    }
    return format.withHeader(names);
}