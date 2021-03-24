public class UserController extends MultiActionController{
	
   public ModelAndView home(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("home");
      model.addObject("message", "Home");
      return model;
   }

   public ModelAndView add(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("user");
      model.addObject("message", "Add");
      return model;
   }

   public ModelAndView remove(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      ModelAndView model = new ModelAndView("user");
      model.addObject("message", "Remove");
      return model;
   }
}