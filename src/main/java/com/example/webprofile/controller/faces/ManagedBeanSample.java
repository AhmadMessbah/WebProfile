package com.example.webprofile.controller.faces;


import jakarta.enterprise.context.RequestScoped;

import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class ManagedBeanSample  implements Serializable {
public void test(){
    System.out.println("Test");
}
}
