
package serg.config;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import serg.service.AnswerService;
import serg.service.QuestionService;
import serg.service.TestService;
import serg.service.UserService;

@Configuration
@ComponentScan(basePackages = {"serg.basicClasses", "serg.controller", "serg.repository", "serg.service", "serg.servlet"})
@EnableScheduling //task:annotation-driven
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"serg.repository"}, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "jpaTransactionManager")
public class ApplicationConfig {

    
    @Value("com.mysql.jdbc.Driver")
    private String driverClass;
    @Value("jdbc:mysql://localhost:3306/myproject")
    private String jdbcUrl;
    @Value("root")
    private String jdbcUserName;
    @Value("12345")
    private String jdbcPassword;
    
    @Bean(name = "dataSource")
    public BasicDataSource getBasicDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }
    
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan(new String[] {"serg.basicClasses"});
        em.setDataSource(getBasicDataSource());
 
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        ((HibernateJpaVendorAdapter)vendorAdapter).setGenerateDdl(true);
        ((HibernateJpaVendorAdapter)vendorAdapter).setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);
 
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        jpaProperties.put("hibernate.show_sql",true);
        jpaProperties.put("hibernate.bytecode.use_reflection_optimizer","false");
        jpaProperties.put("hibernate.hbm2ddl.auto","update");
 
        em.setJpaProperties(jpaProperties);
        return em;
    }
 
    @Bean(name = "jpaTransactionManager")
    public JpaTransactionManager getJpaTransactionManager() {
        JpaTransactionManager jpa = new JpaTransactionManager();
        jpa.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean().getNativeEntityManagerFactory());
        return jpa;
    }
    
    @Bean
    public MessageSource messageSource() {
	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    
    
    @Bean(name = "userService")
    public UserService userService() {
        return new UserService();
    }
     
    @Bean(name = "TestService")
    public TestService TestService() {
        return new TestService();
    }
     
    @Bean(name = "questionService")
    public QuestionService questionService() {
        return new QuestionService();
    }
    
    @Bean(name = "answerService")
    public AnswerService answerService() {
        return new AnswerService();
    }
}
