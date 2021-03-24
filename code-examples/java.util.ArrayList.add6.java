public void execute() throws AlgorithmExecutionException{
	////////////////////////////////////////////
	// THE DISCOVERY ALGORITHM LIVES HERE :-) //
	////////////////////////////////////////////
	

input = this.inputGenerator.generateNewCopy();
   this.relationName = input.relationName();
   this.columnNames = input.columnNames();
   ArrayList<HyperLogLog> Columns = new ArrayList<HyperLogLog>();
   for (int i = 0; i < columnNames.size(); i++)
     Columns.add(new HyperLogLog(eps));
    
   while (input.hasNext()) {
     List<String> CurrentTuple=input.next();
     for (int i = 0; i < columnNames.size(); i++)
     
          Columns.get(i).offer(CurrentTuple.get(i));

	
}
 
   for (int i = 0; i < columnNames.size(); i++)
   {addStatistic(NUMBEROFDISTINCT, Columns.get(i).cardinality(), columnNames.get(i), relationName); }
   
}