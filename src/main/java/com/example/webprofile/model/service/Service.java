package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.Group;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;
import jakarta.transaction.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

@RequestScoped
@Named
public class Service implements Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    private Part file;

    public Service() {
        System.out.println("Service - Created");
    }

    @Transactional
    public void upload() {
        try {
            file.write("./test.txt");
            System.out.println(System.getProperty("."));
            System.out.println(System.getProperty("user.dir"));
            System.out.println(System.getProperty("user.home"));
            System.out.println(new File(".").getCanonicalPath());
            System.out.println(new File(".").getPath());
            System.out.println(new File(".").getAbsolutePath());
            System.out.println(new File(".").getPath());
            System.out.println(file.getSize());
        } catch (IOException e) {
            System.out.println("Upload error");
        }
    }

    @Transactional
    public void save(Group group) {
        System.out.println("Service - Save " + group);
        entityManager.persist(group);
        System.out.println(group);
    }
}
