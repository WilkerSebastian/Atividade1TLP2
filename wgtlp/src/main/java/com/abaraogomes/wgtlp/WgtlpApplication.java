package com.abaraogomes.wgtlp;

import java.text.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@SpringBootApplication
public class WgtlpApplication implements CommandLineRunner{

	// @Autowired
	// private JogoRepository jogoRepository;
	public static void main(String[] args) {
		SpringApplication.run(WgtlpApplication.class, args);
	}

	@Override
	public void run(String...args) throws ParseException{

		// SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		// jogoRepository.save(new Jogo("dragon dogman" , formato.parse("2005-09-22 ") , 100.00 , "jogo top" , "capcom" , 16 , "https://upload.wikimedia.org/wikipedia/pt/6/6c/DragonsDogma.jpg" , "RPG"));

	}


	@Bean
    public MessageSource messageSource() { 
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }


}
