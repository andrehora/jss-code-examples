@RequestMapping(value="managerCheckRentHouseinit.do", method={RequestMethod.GET,RequestMethod.POST})
public ModelAndView managerCheckRentHouseinit(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	HttpSession session = request.getSession();
	
	List<RentHouse> rentHouseList = rentHouseDao.selectAllRentHouse();
	session.setAttribute("rentHouseList", rentHouseList);
	
	modelAndView.setViewName("SystemUser/managerCheck");
	return modelAndView;
}