package test.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = {"test"})
@ComponentScan("test")
public class AppConfig extends WebMvcConfigurerAdapter{
		
	@Bean
	public TilesConfigurer tilesConf() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] {"/views/tiles/tiles.xml"});
		tilesConfigurer.setCheckRefresh(Boolean.TRUE);
		return tilesConfigurer;
	}

	@Bean
	public ViewResolver configViewResolver() {
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setViewClass(TilesView.class);
		return urlBasedViewResolver;
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("WEB-INF/bundles/messages");        
        messageSource.setDefaultEncoding("UTF-8");        
        return messageSource;
    }
	
	@Bean
	public DataSource testDataSource() throws Exception{
		JndiTemplate jndi = new JndiTemplate();
		DataSource dataSource = (DataSource) jndi.lookup("java:jboss/datasources/testDataSource");
		return dataSource;
	}
	
	@Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws Exception {       

        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(this.testDataSource());
        emf.setPackagesToScan("test");
        emf.setJpaVendorAdapter(this.jpaVendorAdapter());        
        //emf.setPersistenceUnitName(HsuDbConfig.PERSISTENCE_UNIT);

        final Map<String, Object> props = new HashMap<String,Object>();
//        props.put("hibernate.show_sql","true");
        
        
        emf.setJpaPropertyMap(props);       
        
        return emf;
    }
	
	@DependsOn("entityManagerFactory")
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        
        final JpaTransactionManager resultado = new JpaTransactionManager();
        resultado.setDataSource(this.testDataSource());
        
        return resultado;
    }
	
//	//@Bean
//	public JpaVendorAdapter jpaVendorAdapter() {
//	    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//	    jpaVendorAdapter.setShowSql(true);
//	    jpaVendorAdapter.setDatabase(Database.HSQL);
//	    //jpaVendorAdapter.setDatabasePlatform();
//	    jpaVendorAdapter.setGenerateDdl(false);
//	    return jpaVendorAdapter;
//	}
//	
		
	public JpaVendorAdapter jpaVendorAdapter() {
        final HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
        hibernateJpa.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
        hibernateJpa.setDatabase(Database.HSQL);
        return hibernateJpa;
    }
	
}
