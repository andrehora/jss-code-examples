@RequestMapping(value = "/showCars", method = RequestMethod.GET)
public ModelAndView showApp() {

    ModelAndView modelAndView = new ModelAndView();

    //adding a single attribute for the modelMap
    PageContent pageContent = new PageContent();
    pageContent.setHeaderName("All Cars - From Controller");
    modelAndView.addObject(pageContent);

    List<Car> carList = new ArrayList<>();

    Car car1 = new Car();
    car1.setModel("Toyota");
    car1.setRegNo("223456");
    car1.setYear("2005");

    Car car2 = new Car();
    car2.setModel("Mazda");
    car2.setRegNo("24244");
    car2.setYear("2015");

    Car car3 = new Car();
    car3.setModel("Nissan");
    car3.setRegNo("4465757");
    car3.setYear("2013");

    carList.add(car1);
    carList.add(car2);
    carList.add(car3);

    Map<String,Object> allObjectsMap = new HashMap<String,Object>();
    allObjectsMap.put("allCarObjects", carList);

    //adding a set of objects for the model map
    modelAndView.addAllObjects(allObjectsMap);

    modelAndView.setViewName("CarView");
    return modelAndView;
}