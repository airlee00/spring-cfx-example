package frame.dynamic;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import framexpert.run.oltp.ext.vo.PageVo;
import ifrs17.ace.lbs.board.bc.BoardBc;
import ifrs17.ace.lbs.board.bc.vo.BoardInPageVo;

public class DynamicSpringBeanGenerator {

    static ApplicationContext appContext = null;

    private void createDynamicBean(Class<?> type,String add) {
        if(appContext == null) {
            appContext = new ClassPathXmlApplicationContext("client-beans.xml");
        }
        Object target = getBean(type);
        if(target == null) {
            AutowireCapableBeanFactory factory = null;
            factory = appContext.getAutowireCapableBeanFactory();
            BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(JaxWsProxyFactoryBean.class);
            beanDefinition.setAutowireCandidate(true);
            
            MutablePropertyValues mpv = new MutablePropertyValues();
            mpv.addPropertyValue("serviceClass", type);
            mpv.addPropertyValue("address", add);
            beanDefinition.setPropertyValues(mpv);
            
            registry.registerBeanDefinition(type.getName(), beanDefinition);
            factory.autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
            
            for(String name : appContext.getBeanDefinitionNames())
                System.out.println(name);
        }
    }
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println("--------start-------------");
        test3();
        System.out.println("===elapsed:" + (System.currentTimeMillis() - l));
        test3();
        l = System.currentTimeMillis();
        test3();
        System.out.println("===elapsed:" + (System.currentTimeMillis() - l));
       
    }
    private static void test3() {
        BoardBc sampleBean = JaxWsProxyBeanCache.getInstance().getBean(BoardBc.class, "http://localhost:8080/services/BoardBc");
        BoardInPageVo boardInPageVo = new BoardInPageVo();
        boardInPageVo.setBoardType("notice");
        PageVo page = new PageVo();
        page.setPageSize(10);
        page.setPageNumber(1);
        boardInPageVo.setPageVo(page);
        System.out.println("===========> " + sampleBean.getBoardList(boardInPageVo));
    
    }
    
    private static void test2() {
        DynamicSpringBeanGenerator dynamicBeanTest = new DynamicSpringBeanGenerator();
        dynamicBeanTest.createDynamicBean(BoardBc.class, "http://localhost:8080/services/BoardBc");
        JaxWsProxyFactoryBean factory = (JaxWsProxyFactoryBean) getBean(BoardBc.class);
        BoardBc sampleBean = (BoardBc) factory.create();
        
        Client proxy = ClientProxy.getClient(sampleBean);
        LoggingInInterceptor loginterceptor =  new LoggingInInterceptor();
        loginterceptor.setPrettyLogging(true);
        proxy.getInInterceptors().add(loginterceptor);
        
        System.out.println(proxy.getRequestContext());
                
        BoardInPageVo boardInPageVo = new BoardInPageVo();
        boardInPageVo.setBoardType("notice");
        PageVo page = new PageVo();
        page.setPageSize(10);
        page.setPageNumber(1);
        boardInPageVo.setPageVo(page);
        System.out.println("===========> " + sampleBean.getBoardList(boardInPageVo));
    }
    
    private static void test1() {
        
//        DynamicSpringBeanGenerator dynamicBeanTest = new DynamicSpringBeanGenerator();
//        dynamicBeanTest.createDynamicBean(DeptProcess.class, "http://localhost:8080/cfx-spring-example/DeptProcess");
//        JaxWsProxyFactoryBean factory = (JaxWsProxyFactoryBean) getBean(DeptProcess.class);
//        DeptProcess sampleBean = (DeptProcess) factory.create();
//        System.out.println("===========> " + sampleBean.processDept());
//        System.out.println("------------2------------------------");
//        
//        JaxWsProxyFactoryBean factory2 = (JaxWsProxyFactoryBean) getBean(DeptProcess.class);
//        DeptProcess sampleBean2 = (DeptProcess) factory.create();
//        System.out.println("===========> " + sampleBean2.processDept());
        
    }

    @SuppressWarnings("unchecked")
    private static Object getBean(Class <?> type) {
        try{
            String beanName = type.getSimpleName();
            beanName = beanName.substring(0, 1).toLowerCase()
                    + beanName.substring(1);
            return  appContext.getBean(type.getName());
        }catch(Exception e) {
           // e.printStackTrace();
            return null;
        }
    }
//    public static JaxWsProxyFactoryBean clientFactory(Class<?> type,String add) {
//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//        factory.setServiceClass(type);
//        factory.setAddress(add);
//        return factory.create();
//    }
}
