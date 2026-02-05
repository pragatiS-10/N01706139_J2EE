package com.example.demo.employeelab4.app;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class EmployeeRestAPIapp extends Application {
    // JAX-RS automatically scans for @Path annotated classes
}
