import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class CmdShop {
    public static void main(String[] args) {
        boolean flag=true;
        String cName="CmdShop";
        //InputStream inUser=Class.forName("CmdShop."+cName).getResourceAsStream("/users.xlsx");
        File file=new File("C:\\Users\\lenovo\\Desktop\\CmdShop\\src\\users.xlsx");
        File pfile=new File("C:\\Users\\lenovo\\Desktop\\CmdShop\\src\\product.xlsx");
        ReadExcel readExcel=new ReadExcel();
        ReadProductExcel readProductExcel=new ReadProductExcel();
        User[] users=readExcel.readExcel(file);
        Product[] products=readProductExcel.readExcel(pfile);
        Product[] bag=new Product[5];

        String username;
        String password;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        username=sc.next();
        System.out.println("请输入密码");
        password=sc.next();
        for(;flag;)
        {
            for (int i=0;i<users.length;i++)
            {
                if(users[i].getUsername().equals(username)&&users[i].getPassword().equals(password))
                {
                    System.out.println("登陆成功");
                    flag=false;
                    for(Product product:products)
                    {
                        System.out.print(product.getpId());
                        System.out.print("\t"+product.getpName());
                        System.out.print("\t"+product.getPrice());
                        System.out.println("\t"+product.getpDescr());
                    }
                    System.out.println("请输入商品ID把该商品加入购物车中");
                    String id=sc.next();
                    Product product=readProductExcel.getProduct(pfile,id);
                    if(product!=null)
                    {

                    }
                }
                else if(i==users.length-1)
                {
                    System.out.println("用户名或密码错误");
                }
                else
                    continue;
            }
        }

    }
}
