public class LoginManager implements ApplicationContextAware {
    @Autowired
    private UserDao userDao;
 
    public User login(String userId, String password) {
        try {
            System.out.println("Try Logging in " + userId);
            User user = userDao.findUser(userId);
            if (!user.getPassword().equals(password)) {
                System.out.println("Login failed");
                return null;
            }
            System.out.println("Login succesful");
            System.out.println("Publish successful login event for "
                    + user.getUserId());
            applicationContext.publishEvent(new LoginEvent(user));
            return user;
        } catch (Exception e) {
            System.out.println("Login failed " + e);
            return null;
        }
    }
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }
 
    private ApplicationContext applicationContext;
}