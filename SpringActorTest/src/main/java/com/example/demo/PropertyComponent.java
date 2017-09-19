

package com.example.demo;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class PropertyComponent {
    @Autowired
    private SampleProperty sampleProperty;

    @Autowired
    private Environment env;

    @Value("${stringProp1}")
    private String stringProp1;

    public void foo() {
        String stringProp1 = env.getProperty("stringProp1");
        System.out.println("stringprop1 " + stringProp1);

        System.out.println("stringprop1  from value  " + stringProp1);
    }


    void propertyTest() {
        System.out.println("stringprop1 " + sampleProperty.getStringProp1());


        Map<String, String> map = sampleProperty.getMap();

        Set<Entry<String, String>> entrySet = map.entrySet();

        for (Entry entry : entrySet) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }
}
