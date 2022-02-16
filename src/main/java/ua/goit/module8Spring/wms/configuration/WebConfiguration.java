package ua.goit.module8Spring.wms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import ua.goit.module8Spring.wms.configuration.converters.ProducerStringConverter;
import ua.goit.module8Spring.wms.configuration.converters.RoleStringConverter;
import ua.goit.module8Spring.wms.configuration.converters.StringProducerConverter;
import ua.goit.module8Spring.wms.configuration.converters.StringRoleConverter;
import ua.goit.module8Spring.wms.dto.ProducerDto;
import ua.goit.module8Spring.wms.dto.RoleDto;

import java.util.Locale;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private StringRoleConverter stringRoleConverter;

    @Autowired
    private StringProducerConverter stringProducerConverter;

    @Autowired
    private RoleStringConverter roleStringConverter;

    @Autowired
    private ProducerStringConverter producerStringConverter;

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/accessDenied").setViewName("accessDenied");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(String.class, ProducerDto.class, stringProducerConverter);
        registry.addConverter(String.class, RoleDto.class, stringRoleConverter);
        registry.addConverter(ProducerDto.class, String.class, producerStringConverter);
        registry.addConverter(RoleDto.class, String.class, roleStringConverter);
    }
}
