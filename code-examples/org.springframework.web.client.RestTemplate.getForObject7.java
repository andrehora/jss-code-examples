public ProductInformation byId(String id) {
    Map<String, String> uriParameters = new HashMap<>();
    uriParameters.put("id", id);
    RestTemplate rest = new RestTemplate();
    InventoryItemAmount amount =
            rest.getForObject(piSUBuilder.url("inventory"),
                    InventoryItemAmount.class,
                    uriParameters);
    log.info("amount {}.",amount);
    if ( amount.getAmount() > 0) {
        log.info("There items from {}. We are offering",id);
        return rest.getForObject(piSUBuilder.url("pi"),
                ProductInformation.class,
                uriParameters);
    } else {
        log.info("There are no items from {}. Amount is {}",id,amount);
        return ProductInformation.emptyProductInformation;
    }
}