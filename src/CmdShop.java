import java.io.File;
import java.util.Scanner;

public class CmdShop {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\lenovo\\Desktop\\CmdShop\\src\\users.xlsx");
        ReadExcel readExcel=new ReadExcel();
        User[] users=readExcel.readExcel(file);

        String username;
        String password;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        username=sc.next();
        System.out.println("请输入密码");
        password=sc.next();
        for (int i=0;i<users.length;i++)
        {
            if(users[i].getUsername().equals(username)&&users[i].getPassword().equals(password))
            {
                System.out.println("登陆成功");
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
