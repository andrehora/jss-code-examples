protected Configuration setupCommonConfig() {
  tmpOivImgDir = Files.createTempDir();

  Configuration conf = new Configuration();
  conf.setInt(DFSConfigKeys.DFS_NAMENODE_CHECKPOINT_CHECK_PERIOD_KEY, 1);
  conf.setInt(DFSConfigKeys.DFS_NAMENODE_CHECKPOINT_TXNS_KEY, 5);
  conf.setInt(DFSConfigKeys.DFS_HA_TAILEDITS_PERIOD_KEY, 1);
  conf.set(DFSConfigKeys.DFS_NAMENODE_LEGACY_OIV_IMAGE_DIR_KEY,
      tmpOivImgDir.getAbsolutePath());
  conf.setBoolean(DFSConfigKeys.DFS_IMAGE_COMPRESS_KEY, true);
  conf.set(DFSConfigKeys.DFS_IMAGE_COMPRESSION_CODEC_KEY,
      SlowCodec.class.getCanonicalName());
  CompressionCodecFactory.setCodecClasses(conf,
      ImmutableList.<Class>of(SlowCodec.class));
  return conf;
}