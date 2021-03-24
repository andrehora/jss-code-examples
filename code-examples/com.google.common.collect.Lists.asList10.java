protected Process runAdb(String... arguments){
  List<String> commandLine=Lists.asList(adbPath,arguments);
  ProcessBuilder processBuilder=newProcessBuilder(commandLine);
  Map<String,String> environment=processBuilder.environment();
  if (adbServerPort != null) {
    environment.put("ANDROID_ADB_SERVER_PORT",adbServerPort.toString());
  }
  if (emulatorConsolePort != null) {
    environment.put("ANDROID_EMULATOR_CONSOLE_PORT",emulatorConsolePort.toString());
  }
  if (emulatorAdbPort != null) {
    environment.put("ANDROID_EMULATOR_ADB_PORT",emulatorAdbPort.toString());
  }
  try {
    return callProcessBuilderStart(processBuilder);
  }
 catch (  IOException exception) {
    throw new AdbException("An IOException occurred when starting ADB.",exception);
  }
}