package cn.homyit.website.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件-文件存储路径属性
 * @author mo
 */
@Getter
@Setter
@Component
@ConfigurationProperties("file")
public class FilePathProperties {
    /**
     * 文件存储路径
     */
    private String savePath;

    /**
     * 文件图床路径
     */
    private String view;
}
