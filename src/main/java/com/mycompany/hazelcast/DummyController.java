package com.mycompany.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @GetMapping(value = "/list")
    public Map<String, String> get() {
        return hazelcastInstance.getMap("myMap");
    }

    @PostMapping(value = "/list")
    public void post(@RequestBody Model model) {
        hazelcastInstance.getMap("myMap").put(model.getKey(), model.getValue());
    }
}
