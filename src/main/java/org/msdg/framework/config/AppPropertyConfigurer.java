package org.msdg.framework.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.msdg.framework.util.IpUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * 应用的配置文件
 */
public class AppPropertyConfigurer extends PropertyPlaceholderConfigurer {

    private static final Logger LOGGER = LogManager.getLogger(AppPropertyConfigurer.class);

    @Override
    protected Properties mergeProperties() throws IOException {
    	Properties superProps = super.mergeProperties();
        superProps.put("env", ResourceMap.getEvnDir());

        // 填充jdbc配置
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource jdbcResource = resourceLoader.getResource("classpath:" + ResourceMap.getEvnDir() + "/jdbc.properties");
        PropertiesLoaderUtils.fillProperties(superProps, jdbcResource);

        File file = new File(ResourceMap.getClassRootPath() + superProps.getProperty("env") + "/log4j2.xml");

        LoggerContext context =(LoggerContext)LogManager.getContext(false);
        context.setConfigLocation(file.toURI());

        //重新初始化Log4j2的配置上下文
        context.reconfigure();

        LOGGER.info(">>>>> 运行环境：" + superProps.getProperty("env"));
        LOGGER.info(">>>>> 服务器IP：" + IpUtils.getLocalIP());
        LOGGER.info(">>>>> 执行脚本：" + ResourceMap.isJobRun());
        return superProps;
    }


}
