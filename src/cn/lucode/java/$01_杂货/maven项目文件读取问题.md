```
public class Test3 {
    /*
    *  使用 maven 创建项目的时候,
    *  配置文件(其实就是非 java 文件）
    *  只能放在 「resources」 文件夹下面,否则编译的时候无法加载到「target」文件夹下面
    *  所以我们 在尝试读取文件有点麻烦（主要不是知道 路劲怎么写）
    *  所以采用这个方式 得到路径
    *
    * */
    @Test
    public void test(){
        // 前提是 在「resources」下 已经存在了111.txt 这个文件
        // 加载本类
        ClassLoader classLoader = Test2.class.getClassLoader();
        // 得到资源的 url
        URL resource = classLoader.getResource("111.txt");
        // 得到资源路径
        String path = resource.getPath();
        // 打印资源路径
        System.out.println(path);
        // 验证 文件是否存在
        File f=new File(path);
        System.out.println(f.exists());
    }
}
```