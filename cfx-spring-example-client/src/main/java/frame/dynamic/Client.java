package frame.dynamic;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.jeong.pro.DeptProcess;
import net.jeong.pro.DeptVo;

public class Client {
    public static void main(String[] args) throws Exception {
        // START SNIPPET: client
        ClassPathXmlApplicationContext context
            = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});

        DeptProcess client = (net.jeong.pro.DeptProcess)context.getBean("client");

        List<DeptVo> response = client.processDept();
        System.out.println("Response: " + response);
        System.exit(0);
        // END SNIPPET: client
    }
}
