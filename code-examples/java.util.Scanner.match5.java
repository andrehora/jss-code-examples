public static void main(String[] args) {
      Scanner scanner = new Scanner(threatData);
      String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
        "(\\d{2}/\\d{2}/\\d{4})";
  	      while(scanner.hasNext(pattern)) {
        scanner.next(pattern);
        MatchResult match = scanner.match();
        String ip = match.group(1);
        String date = match.group(2);
        System.out.format("Threat on %s from %s\n", date,ip);
     }