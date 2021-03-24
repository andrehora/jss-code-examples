private static void occurenceAdderSink(HashMap<String, HashSet<String>> sinks, HashMap<String, HashSet<String>> sources, HashMap<String, Integer> sinksOccurred, HashMap<String, Integer> sinksOccurredNoSource) {
	for (String sink : sinks.keySet()) {
		//System.out.println(sink);
		if (sinksOccurred.containsKey(sink)) {
			sinksOccurred.put(sink, sinksOccurred.get(sink)+1);
		} else {
			sinksOccurred.put(sink, 1);
			sinksOccurredNoSource.put(sink,0);
		}

		if (sources.isEmpty()) {
			sinksOccurredNoSource.put(sink, sinksOccurredNoSource.get(sink)+1);
		}
	}
}