public class gzservlet extends HttpServlet {
    static final long serialVersionUID = 02L;
 
    ApplicationContext applicationContext = null;
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (applicationContext == null){
            System.out.println("setting context in get");
            applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        }
        if (applicationContext != null && applicationContext.containsBean("accessKeys")){
            AccessBean thisAccessBean = (AccessBean) applicationContext.getBean("accessKeys");
            req.setAttribute("keys", thisAccessBean.toString());
            System.out.println("setting keys");
        }
 
        req.getRequestDispatcher("/index2.jsp").include(req,resp);
    }
 
}