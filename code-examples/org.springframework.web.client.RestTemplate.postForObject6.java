public static String getAnswer(RestTemplate restTemplate, String question) {
    String url = "http://www.tuling123.com/openapi/api";
    HttpHeaders headers = new HttpHeaders();
    headers.add("Ocp-Apim-Subscription-Key", "3f5a37d9698744f3b40c89e2f0c94fb1");
    headers.add("Content-Type", "application/x-www-form-urlencoded");


    MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
    bodyMap.add("key", "e2e33efb4efb4e5794b48a18578384ee");
    bodyMap.add("info", question);


    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyMap, headers);
    String result = restTemplate.postForObject(url, requestEntity, String.class);
    return JsonPath.read(result, "$.text");
}