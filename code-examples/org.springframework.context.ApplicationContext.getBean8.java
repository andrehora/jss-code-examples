public void delete() {
	ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
	OrderRentHouseDao dao = (OrderRentHouseDao) ac.getBean("orderRentHouseDao");
	OrderRentHouse c = new OrderRentHouse();
	c.setOrderId(1);
	System.out.println(dao.deleteOrderRentHouse(c));
}