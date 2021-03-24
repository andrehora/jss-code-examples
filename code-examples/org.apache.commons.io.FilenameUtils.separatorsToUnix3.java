protected boolean accept( String path ) {     
  for (Pattern pattern : pathPatterns) {
    //separatorsToUnix is used to convert \ to /
    if ( pattern.matches( FilenameUtils.separatorsToUnix( path ) )) {
      return true;
    }
  }
  return false;
}