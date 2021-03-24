public static HashMap<Profile, Float> getPercentages(HashMap<Profile, Double> distances, int informationSetSize) {
   Map<Profile, Float> result = new HashMap<Profile, Float>();

   if (distances.isEmpty() || distances == null) {
      return new HashMap<Profile, Float>();
   } else {
      for (Map.Entry<Profile, Double> entry : distances.entrySet()) {
         Profile profile = entry.getKey();
         Double distance = entry.getValue();

         // Calculate the percentage for the current distance
         // The maximum distance is sqrt(informationSetSize) because we have
         // 0-1 vectors
         // REMARK: Euclidean Distance Theory
         float maxDistance = (float) Math.sqrt(informationSetSize);
         float percentage = (float) (maxDistance - distance) * 100 / maxDistance;

         // put the percentage in Map formatted with two decimals.
         result.put(profile, (float) (Math.round(percentage * 100.0) / 100.0));
      }
   }
   // return the HashMap sorted by value (DESC)
   return (HashMap<Profile, Float>) MapUtil.sortByValueDESC(result);
}