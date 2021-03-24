public void testComponentFields() throws IOException {
  File outputDir = Files.createTempDir();
  System.out.println("Generating into " + outputDir.getAbsolutePath());
  assertAbout(javaSources())
          .that(Arrays.asList(componentClassBadField))
          .processedWith(new VerifiedSpringConfiguration())
          .failsToCompile()
          .withErrorContaining("@Component classes my only have static final constant fields or final private fields")
          .in(componentClassBadField)
          .onLine(15)
          .and()
          .withErrorContaining("@Component classes my only have static final constant fields or final private fields")
          .in(componentClassBadField)
          .onLine(15);
}