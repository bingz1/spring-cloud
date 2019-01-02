package cloud.simple.client.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemoteHelloServiceTest {

    @Autowired
    RemoteHelloService remoteHelloService;

    @Test
    public void test(){
        String result = remoteHelloService.remoteHello();
        System.out.println(result);
    }
}