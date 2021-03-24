private void extract(BasicImageReader reader, String name,
        ImageLocation location) throws IOException, BadArgs {
    File directory = new File(options.directory);
    byte[] bytes = reader.getResource(location);
    File resource =  new File(directory, name);
    File parent = resource.getParentFile();

    if (parent.exists()) {
        if (!parent.isDirectory()) {
            throw TASK_HELPER.newBadArgs("err.cannot.create.dir",
                                        parent.getAbsolutePath());
        }
    } else if (!parent.mkdirs()) {
        throw TASK_HELPER.newBadArgs("err.cannot.create.dir",
                                    parent.getAbsolutePath());
    }

    if (!ImageResourcesTree.isTreeInfoResource(name)) {
        Files.write(resource.toPath(), bytes);
    }
}