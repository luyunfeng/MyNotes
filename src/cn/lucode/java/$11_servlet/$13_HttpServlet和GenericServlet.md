HttpServlet（重点）和GenericServlet
======================
## 1.GenericServlet（抽象类）
  这里面的init(StringConfig)方法，里面有this.config=config语句
  
不能在子类里面直接覆盖掉这个生命周期方法，

所以在重写的的时候重写**无参的init()**方法

> 带参init()方法在服务器调用 里面调用了无参的init方法

**实现了Servlet，ServletConfig，Serializable接口**

## 2.HttpServlet（GenericServlet的实现类）  

   HttpServlet类中提供了
   >service(HttpServletRequest,HttpServletResponse)

   这个方法并不是继承过来的

   继承过来的的方法时
   >service(ServletRequest,ServletResponse)
   
**这里面的运行原理如下**

1. 客户端请求
2. 服务器调用service(ServletRequest,ServletResponse)
3. `service(ServletRequest,ServletResponse)`
     对参数强转成
`service(HttpServletRequest,HttpServletResponse)`
4. 根据请求客户端请求去调用doPost()和doGet()

简单代码

```

    public abstract class HttpServlet extends GenericServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        ……
    }
    @Override
    public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException {

        HttpServletRequest  request;
        HttpServletResponse response;
         //下面就是强转
        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) res;
        } catch (ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
        service(request, response);
    }
    ……
    }

```



