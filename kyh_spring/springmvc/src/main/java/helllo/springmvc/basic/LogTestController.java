package helllo.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j//private final Logger log = LoggerFactory.getLogger(getClass()); 대체 Lombok 기능
@RestController
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        //log.trace("trace log = {}, {}" +name); 덧셈 연산 자체에서 이미 불필요한 cpu 소모 따라서 사용 x
        log.trace("trace log = {}, {}",name);// 파라미터 형식으로 넘겨주자!
        log.debug("debug log = {}, {}",name);
        log.info(" info log={}", name);
        log.warn("warn log = {}",name);
        log.error("error log = {}",name);
        return "ok";
    }
}
