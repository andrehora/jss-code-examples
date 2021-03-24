public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos)
{
    if (args.length == 1)
    {
        Scoreboard scoreboard = MinecraftServer.getServer().worldServerForDimension(0).getScoreboard();
        List<String> list = Lists.<String>newArrayList();

        for (ScoreObjective scoreobjective : scoreboard.getScoreObjectives())
        {
            if (scoreobjective.getCriteria() == IScoreObjectiveCriteria.TRIGGER)
            {
                list.add(scoreobjective.getName());
            }
        }

        return getListOfStringsMatchingLastWord(args, (String[])list.toArray(new String[list.size()]));
    }
    else
    {
        return args.length == 2 ? getListOfStringsMatchingLastWord(args, new String[] {"add", "set"}): null;
    }
}