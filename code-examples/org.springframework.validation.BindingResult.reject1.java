@Controller
public class MyController {

    @RequestMapping(method = RequestMethod.POST, value = "myPage.html")
    public void myHandler(MyForm myForm, BindingResult result, Model model) {
        result.reject("field1", "error message 1");
    }
}