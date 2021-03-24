public static void main(String[] args) throws Exception {
    ApplicationContext context = SpringApplication.run(FreqTradeApplication.class, args);

    FreqTradeExchangeService exchangeService = context.getBean(FreqTradeExchangeService.class);
    AnalyzeService analyzeService = context.getBean(AnalyzeService.class);

    ZonedDateTime minimumDate = ZonedDateTime.now().minusHours(6);
    List<BittrexChartData> rawTickers = exchangeService.fetchRawticker(new CurrencyPair("ETH/BTC"), minimumDate);
    TimeSeries tickers = new BittrexDataConverter().parseRawTickers(rawTickers);
    boolean buySignal = analyzeService.getBuySignal(tickers);
    
    LOGGER.info("buy signal: {}", buySignal);
    
    SpringApplication.exit(context);
}