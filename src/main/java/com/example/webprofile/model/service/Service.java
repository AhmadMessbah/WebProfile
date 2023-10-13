package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.Group;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.Part;
import jakarta.transaction.Transactional;


import javax.management.*;
import java.io.IOException;
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
            file.write("test.txt");
            System.out.println("ENV");
            for (String s : System.getenv().keySet()) {
                System.out.println(s+" : "+System.getenv(s));
            }


            System.out.println("Property");
            for (Object o : System.getProperties().keySet()) {
                System.out.println(o+" : "+System.getProperty(o.toString()));

            }

            System.out.println(file.getSize());
        } catch (IOException e) {
            System.out.println("Upload error");
        }

        System.out.println(System.getenv("PATH"));
    }

    @Transactional
    public void save(Group group) {
        System.out.println("Service - Save " + group);
        entityManager.persist(group);
        System.out.println(group);
    }

    public void jmx() throws Exception {
//        MBeanServer mBeanServer = MBeanServerFactory.findMBeanServer(null).get(0);
//        ObjectName name = new ObjectName("Catalina", "type", "Server");
//        Server tomcatServer = (org.apache.catalina.Server) mBeanServer.getAttribute(name, "managedResource");
//        Service service = tomcatServer.findService("Catalina");
//        Plugin.Engine engine = (Engine) service.getContainer();
//        Host host = (Host) engine.findChild(engine.getDefaultHost());
//        Context context = (Context) host.findChild("");
//        StandardManager manager = (StandardManager) context.getManager();
//        Session[] sessions=manager.findSessions();
    }
}
