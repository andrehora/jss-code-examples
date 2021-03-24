public Resource transform(HttpServletRequest request, Resource resource, ResourceTransformerChain transformerChain) throws IOException {
    resource = transformerChain.transform(request, resource);

    final String fileName = resource.getFilename();
    final String fileExt = FilenameUtils.getExtension(fileName);
    switch (fileExt) {
        case "js":
        case "json":
        case "css":
        case "html":
            log.trace("format {} supported for Text-Injection", fileExt);
            return transformText(fileName, resource);
        default:
            log.trace("unsupported Resource-Type: {}", fileExt);
            return resource;
    }
}