public Memory useLocale(Environment env, Memory... args) {
  scanner.useLocale(args[0].toObject(WrapLocale.class).getLocale());
  return new ObjectMemory(this);
}