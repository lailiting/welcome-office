package cn.homyit.website.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: inweb
 * @description:
 * @author: ZHANG
 * @create: 2022-08-22 19:55
 **/

    @Configuration
    public class PicConfig implements WebMvcConfigurer {

        @Value("${pic.dir}")
        private String picDir;

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/file/**")
                    .addResourceLocations("file:" + picDir);
        }
    }
