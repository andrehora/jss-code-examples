public void parseArgs(String[] args)
{
  jobName = null;
  parameters = null;
  commandLine = null;
  if (args != null && args.length > 0)
  {
    commandLine = StringUtils.join(args, " ");
    jobName = parseJobName(args[0]);
    parameters = parseParameters(args);
  }
  else
  {
    throw new CmdlineException("Syntax Error: Please specify some arguments");
  }
}