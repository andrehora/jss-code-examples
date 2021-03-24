public SetFetchCommand(Set<Long> ids, FetchDataItem fetchItem, FetchDataItem... otherFetchItems) {
  this(ids, Lists.asList(fetchItem, otherFetchItems));
}

protected IProject[] getProjectsByName(final String projectName, final String otherName, final String... rest) {
	final List<String> projectNames = Lists.asList(projectName, otherName, rest);
	final IProject[] projects = new IProject[projectNames.size()];
	for (int i = 0; i < projects.length; i++) {
		projects[i] = getProjectByName(projectNames.get(i));
	}
	return projects;
}