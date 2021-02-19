package tech.aegean.next.pioneer.store.member.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rainyblossom
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(docketBasePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiInfoTitle)
                .description(apiInfoDescription)
                .contact(new Contact(apiInfoContactName, apiInfoContactUrl, apiInfoContactEmail))
                .termsOfServiceUrl(apiInfoTermsOfServiceUrl)
                .version(apiInfoVersion)
                .build();
    }

    // ----- ----- ----- -----

    @NacosValue(value = "${swagger.docket.basePackage:}", autoRefreshed = true)
    private String docketBasePackage;

    @NacosValue(value = "${swagger.apiInfo.title:}", autoRefreshed = true)
    private String apiInfoTitle;

    @NacosValue(value = "${swagger.apiInfo.description:}", autoRefreshed = true)
    private String apiInfoDescription;

    @NacosValue(value = "${swagger.apiInfo.contact.name:}", autoRefreshed = true)
    private String apiInfoContactName;

    @NacosValue(value = "${swagger.apiInfo.contact.url:}", autoRefreshed = true)
    private String apiInfoContactUrl;

    @NacosValue(value = "${swagger.apiInfo.contact.email:}", autoRefreshed = true)
    private String apiInfoContactEmail;

    @NacosValue(value = "${swagger.apiInfo.termsOfServiceUrl:}", autoRefreshed = true)
    private String apiInfoTermsOfServiceUrl;

    @NacosValue(value = "${swagger.apiInfo.version:}", autoRefreshed = true)
    private String apiInfoVersion;

}
