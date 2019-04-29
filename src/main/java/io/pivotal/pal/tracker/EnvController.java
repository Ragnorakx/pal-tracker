/**
 * Copyright 2019 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

    private final String port;
    private final String memoryLimit;
    private final String cfInstanceIndex;
    private final String cfInstanceAddr;

    public EnvController(@Value(value = "${port:NOT SET}") String port, @Value(value = "${memory.limit:NOT SET}") String memoryLimit, @Value(value = "${CF.instance.index:NOT SET}") String cfInstanceIndex, @Value(value = "${CF.instance.addr:NOT SET}") String cfInstanceAddr){
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddr = cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddr);

        return env;
    }

}
