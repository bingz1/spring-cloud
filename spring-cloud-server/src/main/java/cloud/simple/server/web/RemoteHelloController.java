package cloud.simple.server.web;

import cloud.simple.server.service.RemoteHelloService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author zxb
 * @date 7/5/16
 */
@RestController
public class RemoteHelloController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private RemoteHelloService remoteHelloService;

    @RequestMapping("hello")
    public String hello() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("userID" + MDC.get("userID"));
        String instance = client.getServices().get(0);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> remoteHelloService.cale(10));
        System.out.println(future.get());

        long cost = System.currentTimeMillis() - start;

        return "Remote Hello ~" + instance + ", spent " + cost;
    }

    @PostMapping(value = "transferFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String transferFile(MultipartFile[] files) {
        Arrays.stream(files).forEach(x -> System.out.println(x.getOriginalFilename()));
        return files[0].getOriginalFilename();
    }

}
