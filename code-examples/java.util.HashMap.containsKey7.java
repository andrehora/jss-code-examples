public HashMap<Long,Integer> extractUniqueLocationIdCounts(
		List<ExtendedLocationTrace> traces) {
	HashMap<Long,Integer> idMap = new HashMap<Long, Integer>();
	
	for(ExtendedLocationTrace aTrace: traces){
		
		// all location ids start from 1. if there is a lower number, it is likely that DBSCAN assigned noise to that visit
		if(aTrace.getLocationId()>0){ 
			int count = 0;
			
			if (idMap.containsKey(aTrace.getLocationId()) == true){
				count = idMap.get(aTrace.getLocationId());
			}
			count++;
			idMap.put(aTrace.getLocationId(), count);
		}
	}
	return idMap ;
}