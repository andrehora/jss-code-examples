public void execute(ICommandSender sender, EntityPlayerMP player, List<String> params, String worldName)
{
    if (params.isEmpty())
    {
        sendCmdHelp(sender);
        return;
    }

    ArrayList<String> commands = WorldBorder.COMMAND.getCommandNames();
    for (String param : params)
        if (commands.contains(param.toLowerCase()))
        {
            WorldBorder.COMMAND.subCommands.get(param.toLowerCase()).sendCmdHelp(sender);
            return;
        }

    sendErrorAndHelp(sender, "No command recognized.");
}