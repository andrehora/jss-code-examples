public void testFlightList() throws Exception {
	MockHttpServletRequest request = new MockHttpServletRequest();
	String from = "AMS";
	request.setParameter("from", from);
	String to = "VCE";
	request.setParameter("to", to);
	LocalDate departureDate = new LocalDate();
	request.setParameter("departureDate", departureDate.toString());
	ServiceClass serviceClass = ServiceClass.FIRST;
	request.setParameter("serviceClass", serviceClass.toString());
	MockHttpServletResponse response = new MockHttpServletResponse();
	List<Flight> flights = new ArrayList<Flight>();
	flights.add(new Flight());
	expect(airlineServiceMock.getFlights(from, to, departureDate, serviceClass)).andReturn(flights);

	replay(airlineServiceMock);

	ModelAndView mav = flightsController.flightList(request, response);
	assertNotNull("No ModelAndView returned", mav);
	assertEquals("Invalid view name", "flights", mav.getViewName());
	assertTrue("No flights in ModelAndView", mav.getModel().containsKey("flights"));
	verify(airlineServiceMock);
}