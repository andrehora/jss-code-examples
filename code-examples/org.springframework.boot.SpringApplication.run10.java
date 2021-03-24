@SpringBootApplication
public class CoreApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.customerRepository.deleteAll();
        this.productRepository.deleteAll();
        // save a couple of customers
        Address address = new Address();
        address.setZip("2119");
        this.customerRepository.save(new Customer("Tester", "Smith", new Address()));
        this.customerRepository.save(new Customer("Again", "Smith", new Address()));

        Customer test = this.customerRepository.findByFirstName("Alice");


        long count = this.customerRepository.count();
        System.out.println(count + " customers in the repo");

        Product product = new Product();
        product.setSku("11234A");
        product.setTitle("Hard Times");
        product.setType("Book");
        product.setProductDetails(productDetails()).setPricing(pricing());
        product.setShipping(shipping());
        productRepository.save(product);

        Product found = productRepository.findBySku("11234A");
        System.out.println(found);

    }

    private ProductDetails productDetails() {
        ProductDetails details = new ProductDetails();
        details.setTitle("Hard Times");
        details.setGenre("Classic Fiction");
        return details;
    }

    private Pricing pricing() {
        Pricing pricing = new Pricing();
        pricing.setListPrice(1000);
        pricing.setRetailPrice(900);
        return pricing;
    }

    private Shipping shipping() {
        Shipping shipping = new Shipping();
        shipping.setDepth(10);
        shipping.setWeight(1000);
        shipping.setHeight(2);
        shipping.setWidth(30);
        return  shipping;
    }

}