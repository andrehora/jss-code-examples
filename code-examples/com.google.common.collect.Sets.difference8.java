public void saveAssignedRoles(String userId, Set<Role> newRoles) {
    Set<Role> oldRoles = getAssignedRoles(userId);

    Sets.SetView<Role> removedRoles = Sets.difference(oldRoles, newRoles);
    Sets.SetView<Role> addedRoles = Sets.difference(newRoles, oldRoles);

    removedRoles.forEach(role -> {
        store.deleteRole(userId, role);
        logger.logEvent(new RoleDelEvent(Instant.now(), userId, role.getId(), role.getName()));
    });

    addedRoles.forEach(role -> {
        store.addRole(userId, role);
        logger.logEvent(new RoleAddEvent(Instant.now(), userId, role.getId(), role.getName()));
    });
}