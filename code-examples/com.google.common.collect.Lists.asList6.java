private PermissionCache<Permission> initGlobal(Configuration conf) throws IOException {
  UserProvider userProvider = UserProvider.instantiate(conf);
  User user = userProvider.getCurrent();
  if (user == null) {
    throw new IOException("Unable to obtain the current user, " +
        "authorization checks for internal operations will not work correctly!");
  }
  PermissionCache<Permission> newCache = new PermissionCache<Permission>();
  String currentUser = user.getShortName();

  // the system user is always included
  List<String> superusers = Lists.asList(currentUser, conf.getStrings(
      Superusers.SUPERUSER_CONF_KEY, new String[0]));
  if (superusers != null) {
    for (String name : superusers) {
      if (AuthUtil.isGroupPrincipal(name)) {
        newCache.putGroup(AuthUtil.getGroupName(name),
            new Permission(Permission.Action.values()));
      } else {
        newCache.putUser(name, new Permission(Permission.Action.values()));
      }
    }
  }
  return newCache;
}