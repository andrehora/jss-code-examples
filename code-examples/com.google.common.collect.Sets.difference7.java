private Set<Group> getUserGroups(User user) {
    //get user's new group
    Set<Group> groupsForUser = findGroupsForUser(user.getPermission(), user.getRoles()).stream()
        .map(group -> {
            group.getUsers().add(user);
            groupDAO.save(group);
            return group;
        }).collect(Collectors.toSet());

    //remove user from old group
    Set<Group> oldGroups = Sets.difference(user.getGroups(), groupsForUser);
    oldGroups.stream()
        .filter(group -> group.getGroupType().equals(GroupType.PUBLIC))
        .map(group -> {
            group.getUsers().remove(user);
            groupDAO.save(group);
            return group;
        }).collect(Collectors.toSet());

    return groupsForUser;
}