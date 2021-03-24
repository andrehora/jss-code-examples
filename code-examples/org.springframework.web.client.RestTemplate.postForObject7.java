public void test() {
    
    RestTemplate rt = new RestTemplate();
    
    for (int i = 10; i< 100;i++) {
        System.out.println(i%2);
        RegistReq req = new RegistReq();
        req.setName("" + i);
        req.setSex(i%2);
        req.setPhone("0000" + i);
        req.setPassword(SecurityUtils.getInstance().EncryptPass("" + i));
        req.setEmail(i + "@hifipi.com");
        BaseModel res = rt.postForObject("http://tt.hifipi.com/regist", req, BaseModel.class);
        System.out.println(res.getCode());
    }
    
}