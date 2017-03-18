ServletContext读取类路径资源（输出网页）
==============
 * 先得到类路径
> ClassLoader classLoader=this.getClass().getClassLoader();

* 在类路径下根据名字得到资源
 >InputStream in=classLoader.getResourceAsStream("ServletContext相关.html");

    public class CServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        ClassLoader classLoader=this.getClass().getClassLoader();
        InputStream in=classLoader.getResourceAsStream("ServletContext相关.html");
		     
       //在输出的时候需要先设置字符编码
        response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		BufferedReader br=new BufferedReader(new InputStreamReader(in,"utf-8"));		   
	    String s="";		   
		  while((s=br.readLine())!=null){//一行一行读
		     out.println(s);			
		  }
		out.flush();
		out.close();
		//System.out.println(s);
	}
    }

