private static boolean isAnonymousRest(String lastPart) {
    return Ints.tryParse(lastPart) != null;
}