public class RestTemplateExample
{
    public static void main(String[] args)
    {
         RestTemplate restTemplate = new RestTemplate();
         String url = "http://localhost:8080/SpringMVCloginExample/jsp/json.jsp";
         List<HttpMessageConverter> messageConverters = 
                    new ArrayList<HttpMessageConverter>();
         MappingJacksonHttpMessageConverter map =
                    new MappingJacksonHttpMessageConverter();
         messageConverters.add(map);
         restTemplate.setMessageConverters(messageConverters);
         UserBean bean = restTemplate.getForObject(url, UserBean.class);
         System.out.println("The object received from REST call : "+bean);
    }
}