package model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import model.hibernatespring.*;

public class BeansFactory {
    
    private static ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");

    public static IEmailOnlyAddress getIEmailOnlyAddress() {
        return ctx.getBean(EmailOnlyAddress.class);
    }

    public static IPostalAddress getIPostalAddress() {
        return ctx.getBean(PostalAddress.class);
    }

    public static IAbstractAddress getIAbstractAddress() {
        return ctx.getBean(AbstractAddress.class);
    }

    public static IAddressList getIAddressList() {
        return ctx.getBean(AddressList.class);
    }
}
