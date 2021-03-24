private static List<String> generateHtmlChunks(List<ReportItem> reportItemList) {
  List<String> htmlChunks = new ArrayList<>();

  VelocityEngine velocityEngine = new VelocityEngine();
  Properties p = new Properties();
  p.setProperty("resource.loader", "class");
  p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
  velocityEngine.init(p);
  Template template = velocityEngine.getTemplate("template/report_template.html");

  int maxItemsInReport = CliHelper.getMaxItemsInReport();
  List<List<ReportItem>> reportItemsChunks = Lists.partition(reportItemList, maxItemsInReport);

  for (List<ReportItem> reportItemsChunk : reportItemsChunks ) {
    VelocityContext velocityContext = new VelocityContext();
    velocityContext.put("jarPath", CliHelper.getPathToAnalyze());
    velocityContext.put("ruleName", reportItemsChunk.get(0).getRuleName());
    velocityContext.put("reportItems", reportItemsChunk);

    StringWriter stringWriter = new StringWriter();
    template.merge(velocityContext, stringWriter);
    htmlChunks.add(stringWriter.toString());
  }
  return htmlChunks;
}