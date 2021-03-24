private static void statInSeveralPasses(BufferedReader br, int column)
        throws IOException {
    System.out.println("#-----Statistics in several passes-------#");
    //Create a comparator to compare records by the column.
    Comparator<String> comparator
            = Comparator.comparing(
                    (String str) -> parseDouble(getCell(str, column)));
    //Find max record by using Collectors.maxBy(...)
    System.out.println(
            "Max: " + br.lines().collect(maxBy(comparator)).get());
    br.reset();
    //Find min record by using Collectors.minBy(...)
    System.out.println(
            "Min: " + br.lines().collect(minBy(comparator)).get());
    br.reset();
    //Compute the average value and sum with
    //Collectors.toDoubleSummaryStatistics(...)
    DoubleSummaryStatistics doubleSummaryStatistics
            = br.lines().collect(summarizingDouble(
                str -> parseDouble(getCell(str, column))));
    System.out.println("Average: " + doubleSummaryStatistics.getAverage());
    System.out.println("Sum: " + doubleSummaryStatistics.getSum());
}