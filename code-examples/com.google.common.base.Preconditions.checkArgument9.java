public TopConf(Configuration conf) {
  isEnabled = conf.getBoolean(DFSConfigKeys.NNTOP_ENABLED_KEY,
      DFSConfigKeys.NNTOP_ENABLED_DEFAULT);
  String[] periodsStr = conf.getTrimmedStrings(
      DFSConfigKeys.NNTOP_WINDOWS_MINUTES_KEY,
      DFSConfigKeys.NNTOP_WINDOWS_MINUTES_DEFAULT);
  nntopReportingPeriodsMs = new int[periodsStr.length];
  for (int i = 0; i < periodsStr.length; i++) {
    nntopReportingPeriodsMs[i] = Ints.checkedCast(
        TimeUnit.MINUTES.toMillis(Integer.parseInt(periodsStr[i])));
  }
  for (int aPeriodMs: nntopReportingPeriodsMs) {
    Preconditions.checkArgument(aPeriodMs >= TimeUnit.MINUTES.toMillis(1),
        "minimum reporting period is 1 min!");
  }
}