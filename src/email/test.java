package email;

import javax.mail.MessagingException;

public class test {
    public static void main(String[] args) throws MessagingException {
        for (int i = 0;i < 10;i++) {
            String str = "没啥事，傻逼刘睿哈哈哈，我测试一个循环调用邮箱api！！！哈哈哈哈,第"+i+"次";
            Email.send(str, "2604423987@qq.com");
            System.out.println(i);
//            var len = str.length;   //当前HTML对象text的长度
//            if(len > 30){
//                str=str.substring(0,30)+"......";  //使用字符串截取，获取前30个字符，多余的字符使用“......”代替//将替换的值赋值给当前对象
//            }

        }
    }
}
