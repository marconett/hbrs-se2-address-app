package model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeansFactory {
    
    private static ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");

    public static IEmailOnlyAddress getIEmailOnlyAddress() {
        return ctx.getBean(IEmailOnlyAddress.class);
    }

    public static IPostalAddress getIPostalAddress() {
        return ctx.getBean(IPostalAddress.class);
    }

    public static IAbstractAddress getIAbstractAddress() {
        return ctx.getBean(IAbstractAddress.class);
    }

    public static IAddressList getIAddressList() {
        return ctx.getBean(IAddressList.class);
    }
}
