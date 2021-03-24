public static @Nullable Element getUniqueChild(Element parent, String name, Set<String> aliases) throws InvalidXMLException {
    List<Element> children = new ArrayList<>();
    for(String alias : Sets.union(ImmutableSet.of(name), aliases)) {
        children.addAll(parent.getChildren(alias));
    }

    if(children.size() > 1) {
        throw new InvalidXMLException("multiple '" + name + "' tags not allowed", parent);
    }
    return children.isEmpty() ? null : children.get(0);
}