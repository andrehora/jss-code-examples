public void demoFileWrite(final String fileName, final String contents)
   {
      checkNotNull(fileName, "Provided file name for writing must NOT be null.");
      checkNotNull(contents, "Unable to write null contents.");
      final File newFile = new File(fileName);
      try
      {
         Files.write(contents.getBytes(), newFile);
      }
      catch (IOException fileIoEx)
      {
         err.println(  "ERROR trying to write to file '" + fileName + "' - "
                     + fileIoEx.toString());
      }
   }