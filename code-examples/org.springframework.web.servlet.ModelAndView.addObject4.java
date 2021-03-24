@GetMapping("/getMessage2")
public ModelAndView getMessage() {

    var mav = new ModelAndView();
    mav.addObject("message", message);
    mav.setViewName("show");

    return mav;
}