package com.pamit.io;

import org.springframework.stereotype.Component;

@Component
public class SimpleIO {
    // A sample class to be used as a Spring component.
    // The package listed in SpringbootDemoApplication.java

    public String stream() {
        return "Streaming...";
    }
}
