public void testDynamicRegionFactoryDiskDir() throws CacheException {
  CacheCreation cache = new CacheCreation();
  File f = new File("diskDir");
  f.mkdirs();
  cache.setDynamicRegionFactoryConfig(new DynamicRegionFactory.Config(f, null, true, true));
  RegionAttributesCreation attrs = new RegionAttributesCreation(cache);
  cache.createRegion("root", attrs);
  // note that testXml can't check if they are same because enabling
  // dynamic regions causes a meta region to be produced.
  testXml(cache, false);
  assertEquals(true, DynamicRegionFactory.get().isOpen());
  assertEquals(f.getAbsoluteFile(), DynamicRegionFactory.get().getConfig().getDiskDir());
  Region dr = getCache().getRegion("__DynamicRegions");
  if (dr != null) {
    dr.localDestroyRegion();
  }
}