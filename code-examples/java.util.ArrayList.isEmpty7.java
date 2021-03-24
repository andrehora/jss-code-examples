private static ArrayList<Integer> interpretTime(String[] commands) throws InvalidDisplayOptionException{
  int indice = 0;
  ArrayList<Integer> actions = new ArrayList<Integer>(3);
  for(String command : commands){
    if (command.contains(Main.SINGLECOLUM) || command.contains(Main.DOUBLECOLUM) || command.contains(Main.TRIPLECOLUM))
      ;
    else if(command.contains(Main.INDICATIVO))
      actions.add(1);
    else if(command.contains(Main.CONJUNTIVO))
      actions.add(2);
    else if(command.contains(Main.IMPERATIVO))
      actions.add(3);
    else
      throw new InvalidDisplayOptionException(command);
  }
  if (actions.isEmpty()) {
    actions.add(1);
    actions.add(2);
    actions.add(3);
  }
  return actions;
}