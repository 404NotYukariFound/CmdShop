import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class CmdShop {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws ClassNotFoundException {
        int bag_max=5;
        int count=0;
        boolean flag=true;
        boolean R=true;
        InputStream inUser = Class.forName("CmdShop").getResourceAsStream("/users.xlsx");
        InputStream inProduct = Class.forName("CmdShop").getResourceAsStream("/product.xlsx");
        ReadExcel readExcel=new ReadExcel();
        ReadProductExcel readProductExcel=new ReadProductExcel();
        User[] users=readExcel.readExcel(inUser);
        User user;
        Product[] products=readProductExcel.readExcel(inProduct);
        Product[] bag=new Product[bag_max];

        String username;
        String password;

        for(;flag;)
        {
            System.out.println("请输入用户名");
            username=sc.next();
            System.out.println("请输入密码");
            password=sc.next();
            for (int i=0;i<users.length;i++)
            {
                if(users[i].getUsername().equals(username)&&users[i].getPassword().equals(password))
                {
                    user=users[i];
                    System.out.println("登陆成功");
                    flag=false;
                    for (;;)
                    {
                        int choose;
                        info_Headline();
                        for(Product product:products)
                        {
                            info_Product(product);
                        }
                        System.out.println("请输入商品ID把该商品加入购物车中");
                        String id=sc.next();
                        inProduct=null;
                        inProduct = Class.forName("CmdShop").getResourceAsStream("/product.xlsx");
                        Product product=readProductExcel.getProduct(inProduct,id);
                        if(product!=null)
                        {
                            System.out.println("您加入购物车的商品价格为:"+product.getPrice());
                            bag[count]=product;
                            count++;
                            if(count==bag_max-2)
                            {
                                Product[] tmpArr= Arrays.copyOf(bag,2*bag.length);
                            }
                            System.out.println("继续购物请输入1，查看购物车请输入2");
                            choose=sc.nextInt();
                            if(choose==1)
                            {
                                continue;
                            }
                            else if (choose==2)
                            {
                                info_Headline();
                                for(Product t_product:bag)
                                {
                                    if(!R)
                                    {
                                        R = true;
                                        break;
                                    }
                                    if(t_product!=null)
                                    {
                                       info_Product(t_product);
                                    }
                                    System.out.println("继续购物请输入1，付款请输入2");
                                    for(;;)
                                    {
                                        int re=sc.nextInt();
                                        if(re==1)
                                        {
                                            R=false;
                                            break;
                                        }
                                        else if (re==2)
                                        {
                                            boolean f=false;
                                            int x=1;
                                            Order order=new Order();
                                            order.setProducts(bag);
                                            order.setUser(user);
                                            for(Product product1 :bag)
                                            {
                                                if (order.getProducts()==null)
                                                {
                                                    order.getProducts()[0]=product1;
                                                    order.getProducts()[0].setShangPinShuLiang(order.getShangPinShuLiang()+1);
                                                }
                                                else
                                                {
                                                    for(Product product2:order.getProducts())
                                                    {
                                                        if (product1.getpId()==product2.getpId())
                                                        {
                                                            product2.setShangPinShuLiang(product2.getShangPinShuLiang() + 1);
                                                            f=true;
                                                        }
                                                    }
                                                    if (f==false)
                                                    {
                                                        order.getProducts()[x]=product1;
                                                        order.getProducts()[x].setShangPinShuLiang(order.getShangPinShuLiang()+1);
                                                    }
                                                }
                                            }
                                            System.exit(0);
                                        }
                                        else
                                            System.out.println("请输入正确的编号以进行下一步操作");
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("请输入正确的编号以进行下一步操作");
                            }
                        }
                        else
                        {
                            System.out.println("该商品不存在，请输入正确的商品id");
                        }
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
    public static void shopping()
    {

    }
    public static void info_Headline()
    {
        System.out.print("商品id");
        System.out.print("\t"+"商品名称");
        System.out.print("\t"+"商品价格");
        System.out.println("\t"+"商品描述");
    }
    public static void info_Product(Product product)
    {
        System.out.print(product.getpId());
        System.out.print("\t"+product.getpName());
        System.out.print("\t"+product.getPrice());
        System.out.println("\t"+product.getpDescr());
    }
}
