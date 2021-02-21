package cloud.simple.client.service;

import cloud.simple.client.config.FeignSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zxb on 7/6/16.
 */
@FeignClient(value = "test-server", configuration = FeignSupportConfig.class)
public interface RemoteHelloService {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    String remoteHello();

    @PostMapping(value = "transferFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String transferFile(@RequestPart(name = "files") MultipartFile[] files);

}
