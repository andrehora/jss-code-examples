public void processChange(final InputFileDetails input, final RecompilationSpec spec) {
    // Do not process
    if (input.isRemoved()) {
        return;
    }

    final ClassReader classReader;
    try {
        classReader = new Java9ClassReader(Files.toByteArray(input.getFile()));
    } catch (IOException e) {
        throw new IllegalArgumentException(String.format("Unable to read class file: '%s'", input.getFile()));
    }

    String className = classReader.getClassName().replaceAll("/", ".");
    DependentsSet actualDependents = previousCompilation.getDependents(className);
    if (actualDependents.isDependencyToAll()) {
        spec.setFullRebuildCause(actualDependents.getDescription(), input.getFile());
    } else {
        spec.getClassNames().addAll(actualDependents.getDependentClasses());
    }
}