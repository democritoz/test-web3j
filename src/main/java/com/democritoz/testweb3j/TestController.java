package com.democritoz.testweb3j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {
    

    @GetMapping("/test001")
    public ResponseEntity<Map<String, Object>> test001() {

        
        Web3j web3j = Web3j.build(new HttpService("http://home.ziofront.com:19201"));
        log.info("web3j=[{}]", web3j);


        log.info("web3j.web3ClientVersion()=[{}]", web3j.web3ClientVersion());
        log.info("web3j.ethAccounts()=[{}]", web3j.ethAccounts());

        try {
            web3j.web3ClientVersion().send();
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }

        Map<String, Object> responseMap = new HashMap<>();

        return ResponseEntity.ok(responseMap);
    }


}
