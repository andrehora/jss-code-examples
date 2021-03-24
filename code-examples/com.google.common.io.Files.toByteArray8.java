private void remapClasses(File scriptCacheDir, File relocalizedDir, RemappingScriptSource source) {
    ScriptSource origin = source.getSource();
    String className = origin.getClassName();
    if (!relocalizedDir.exists()) {
        relocalizedDir.mkdir();
    }
    File[] files = scriptCacheDir.listFiles();
    if (files != null) {
        for (File file : files) {
            String renamed = file.getName();
            if (renamed.startsWith(RemappingScriptSource.MAPPED_SCRIPT)) {
                renamed = className + renamed.substring(RemappingScriptSource.MAPPED_SCRIPT.length());
            }
            ClassWriter cv = new ClassWriter(0);
            BuildScriptRemapper remapper = new BuildScriptRemapper(cv, origin);
            try {
                ClassReader cr = new ClassReader(Files.toByteArray(file));
                cr.accept(remapper, 0);
                Files.write(cv.toByteArray(), new File(relocalizedDir, renamed));
            } catch (IOException ex) {
                throw UncheckedException.throwAsUncheckedException(ex);
            }
        }
    }
}