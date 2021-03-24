public List<Subtitle> doFilter(Release release, List<Subtitle> Subtitles) {
    List<Subtitle> filteredList = new ArrayList<Subtitle>();
    for (Subtitle subtitle : Subtitles) {
        // make sure the release is filled up!
        if (subtitle.getReleasegroup().isEmpty())
            subtitle.setReleasegroup(ReleaseParser.extractReleasegroup(subtitle.getFilename(), FilenameUtils.isExtension(subtitle.getFilename(), "srt")));
        if (subtitle.getReleasegroup().toLowerCase().contains(release.getReleasegroup().toLowerCase()) || release.getReleasegroup().toLowerCase().contains(subtitle.getReleasegroup().toLowerCase())) {
            LOGGER.debug("getSubtitlesFiltered: found KEYWORD based TEAM match [{}] ", subtitle.getFilename());
            subtitle.setSubtitleMatchType(SubtitleMatchType.TEAM);
            filteredList.add(subtitle);
        }
    }
    return filteredList;
}