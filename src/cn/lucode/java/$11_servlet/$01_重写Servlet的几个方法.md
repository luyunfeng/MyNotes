```
public class MyServlet implements Servlet {
    //生命周期方法  销毁前调用   调用一次
    @Override
    public void destroy() {
         System.out.println("destroy()....");
    }
    //获取服务配置
    @Override
    public ServletConfig getServletConfig() {
         System.out.println("getServletConfig()....");
        return null;
    }
    //获取服务信息
    @Override
    public String getServletInfo() {
         System.out.println("getServletInfo()");
        return null;
    }
    //生命周期方法   初始化的  调用一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

         System.out.println("init()....");
    }
   //生命周期中不断被调用
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
         System.out.println("service()....");

    }

}

```
