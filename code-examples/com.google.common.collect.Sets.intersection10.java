private Set<User> findUsersWithRolesAndPermissions(Set<Role> roles, Set<Permission> permissions) {
    Set<User> userWithRole = new HashSet<>();
    Set<User> userWithPermissionLevel = new HashSet<>();

    if(permissions.isEmpty() && roles.isEmpty())
        return new HashSet<>(userRepository.findAll());

    permissions.
        forEach(permission -> userWithPermissionLevel.addAll(permission.getUsers()));
    if (roles.isEmpty())
        return userWithPermissionLevel;
    else {
        roles.forEach(role -> userWithRole.addAll(role.getUsers()));
        return Sets.intersection(userWithPermissionLevel, userWithRole);
    }
}