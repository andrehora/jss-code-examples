void render(PerformanceTestHistory testHistory, Transformer<String, MeasuredOperationList> valueRenderer, PrintWriter out) {
    List<? extends PerformanceTestExecution> sortedResults = Lists.reverse(testHistory.getExecutions());
    out.println("  [");
    List<String> labels = testHistory.getScenarioLabels();
    for (int i = 0; i < labels.size(); i++) {
        if (i > 0) {
            out.println(",");
        }
        out.println("  {");
        out.println("    \"label\": \"" + labels.get(i) + "\",");
        out.print("\"data\": [");
        boolean empty = true;
        for (int j = 0; j < sortedResults.size(); j++) {
            PerformanceTestExecution results = sortedResults.get(j);
            MeasuredOperationList measuredOperations = results.getScenarios().get(i);
            if (!measuredOperations.isEmpty()) {
                if (!empty) {
                    out.print(", ");
                }
                out.print("[" + j + ", " + valueRenderer.transform(measuredOperations) + "]");
                empty = false;
            }
        }
        out.println("]");
        out.print("  }");
    }
    out.println();
    out.println("]");
}