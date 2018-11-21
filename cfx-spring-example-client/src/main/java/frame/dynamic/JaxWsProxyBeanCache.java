package frame.dynamic;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;

public class JaxWsProxyBeanCache {

    private static JaxWsProxyBeanCache instance;
    private static Object monitor = new Object();
    private static String cacheName ="_webServiceSoapBeanCache_";
    private static int capacity = 2000;
    private Cache<String, Object> cache;

    private JaxWsProxyBeanCache(String cachename, int capacity) {
        cache = new Cache2kBuilder<String, Object>() {}
        .name(cachename)
        .eternal(true)
        .entryCapacity(capacity)
        .build();
    }
    
    public <T> T getBean(final Class<T> serviceClass,final String address) {
        Object bean = cache.get(serviceClass.getName());
        System.out.println("=============================bean:");
        if(bean == null) {
            bean = createBean(serviceClass, address);
            cache.put(serviceClass.getName(), bean);
        }
        
        return (T)bean;
    }
    

    private Object createBean(final Class<?> serviceClass,final String address) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(serviceClass);
        factory.setAddress(address);
        Object bean = factory.create();
        Client proxy = ClientProxy.getClient(bean);
        LoggingInInterceptor loginterceptor =  new LoggingInInterceptor();
        loginterceptor.setPrettyLogging(true);
        proxy.getInInterceptors().add(loginterceptor);
        return bean;
    }
    
   
    private void clear() {
        cache.clear();
    }


    public static JaxWsProxyBeanCache getInstance() {
        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new JaxWsProxyBeanCache(cacheName,capacity);
                }
            }
        }
        return instance;
    }

}
