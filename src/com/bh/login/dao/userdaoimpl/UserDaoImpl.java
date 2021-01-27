package com.bh.login.dao.userdaoimpl;

import com.bh.login.dao.userdao.UserDao;
import com.bh.login.pojo.User;

import java.io.*;

/**
 * 这是用户操作的具体实现类(I/O)
 * 登录/注册
 */
public class UserDaoImpl implements UserDao {
    //为了保证
    public static File file = new File("a.txt");

    //静态代码块，随着类的加载而加载
    static {
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("创建文件失败");
        }
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean isLogin(String username, String password) {
        // 遍历集合，获取每一个用户，并判断该用户的用户名和密码是否和传递过来的匹配
        boolean flag = false;
        //创建字符缓冲输出流对象
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("a.txt"));
            //一行一行的读取文件中的内容：----》readLine()
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] solits = line.split("\\$");
                if (solits[0].equals(username) && solits[1].equals(password)) {
                    flag = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到该文件！！！");
        } catch (IOException e) {
            System.out.println("登录失败！！！");
        } finally {
            if (br != null) {
                try {
                    //关闭流
                    br.close();
                } catch (IOException e) {
                    System.out.println("资源释放失败！！！");
                }
            }
        }
        return flag;
    }

    /**
     * 注册
     *
     * @param user
     */
    @Override
    public void regist(User user) {
        //创建字符缓冲输出流对象
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(user.getUsername() + "$" + user.getPassword());
            //写入一个行分隔符
            bw.newLine();
            //强制刷新
            bw.flush();
        } catch (IOException e) {
            System.out.println("用户注册失败！！！");
        } finally {
            if (bw != null) {
                try {
                    //关闭流
                    bw.close();
                } catch (IOException e) {
                    System.out.println("释放失败！！！");
                }
            }
        }
    }
}
