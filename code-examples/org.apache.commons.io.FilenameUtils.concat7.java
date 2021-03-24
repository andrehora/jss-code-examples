public ClusterConfigurationService(Cache cache) throws IOException {
  this.cache = (GemFireCacheImpl) cache;
  Properties properties = cache.getDistributedSystem().getProperties();
  // resolve the cluster config dir
  String clusterConfigRootDir = properties.getProperty(CLUSTER_CONFIGURATION_DIR);

  if (StringUtils.isBlank(clusterConfigRootDir)) {
    clusterConfigRootDir = System.getProperty("user.dir");
  } else {
    File diskDir = new File(clusterConfigRootDir);
    if (!diskDir.exists() && !diskDir.mkdirs()) {
      throw new IOException("Cannot create directory : " + clusterConfigRootDir);
    }
    clusterConfigRootDir = diskDir.getCanonicalPath();
  }

  // resolve the file paths
  String configDiskDirName =
      CLUSTER_CONFIG_DISK_DIR_PREFIX + cache.getDistributedSystem().getName();

  configDirPath = FilenameUtils.concat(clusterConfigRootDir, CLUSTER_CONFIG_ARTIFACTS_DIR_NAME);
  configDiskDirPath = FilenameUtils.concat(clusterConfigRootDir, configDiskDirName);
  sharedConfigLockingService = getSharedConfigLockService(cache.getDistributedSystem());
  status.set(SharedConfigurationStatus.NOT_STARTED);
}