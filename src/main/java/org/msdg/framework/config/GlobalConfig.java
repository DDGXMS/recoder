
package org.msdg.framework.config;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.msdg.framework.util.IpUtils;

public class GlobalConfig {
    private String env;
    private String appCode;
    private String rtxServer = "http://rtxmsg.dooioo.com/rtx/sendRtx";
    private String version;
    private String domain;
    private int memExpired = 2592000;
    private int logTime = 2;
    private static GlobalConfig config;

    public GlobalConfig() {
    }

    public int getMemExpired() {
        return this.memExpired;
    }

    public void setMemExpired(int memExpired) {
        this.memExpired = memExpired;
    }

    public int getLogTime() {
        return this.logTime;
    }

    public void setLogTime(int logTime) {
        this.logTime = logTime;
    }

    public String getEnv() {
        return this.env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAppCode() {
        return this.appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getRtxServer() {
        return this.rtxServer;
    }

    public void setRtxServer(String rtxServer) {
        this.rtxServer = rtxServer;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static synchronized GlobalConfig getInstance() {
        if(config == null) {
            config = new GlobalConfig();
            PropertiesConfiguration prop = new PropertiesConfiguration();
            prop.setEncoding("utf-8");

            String env;
            try {
                prop.load("global.properties");
                setEnv(prop);
                config.setAppCode(prop.getString("appCode", ""));
                env = prop.getString("rtxServer");
                if(!StringUtils.isBlank(env)) {
                    config.setRtxServer(env);
                }

                config.setVersion(prop.getString("version"));
            } catch (ConfigurationException var2) {
                config.setEnv("development");
                config.setAppCode("");
            }

            env = config.getEnv();
            if("production".equalsIgnoreCase(env)) {
                config.setDomain("com");
            } else if("integration".equalsIgnoreCase(env)) {
                config.setDomain("org");
            } else if("preview".equalsIgnoreCase(env)) {
                config.setDomain("me");
            } else if("development".equalsIgnoreCase(env)) {
                config.setDomain("net");
            } else if("test".equalsIgnoreCase(env)) {
                config.setDomain("net");
            }
        }

        return config;
    }

    private static void setEnv(PropertiesConfiguration prop) {
        String productionIp = prop.getString("production_ip", "");
        String testIp = prop.getString("test_ip", "");
        String developmentIp = prop.getString("development_ip", "");
        String integrationIp = prop.getString("integration_ip", "");
        String previewIp = prop.getString("preview_ip", "");
        if(StringUtils.isNotBlank(productionIp) || StringUtils.isNotBlank(integrationIp) || StringUtils.isNotBlank(developmentIp) || StringUtils.isNotBlank(testIp) || StringUtils.isNotBlank(previewIp)) {
            List env = IpUtils.getLocalIp();
            if(StringUtils.isNotBlank(productionIp) && containsIp(productionIp, env)) {
                config.setEnv("production");
            } else if(StringUtils.isNotBlank(integrationIp) && containsIp(integrationIp, env)) {
                config.setEnv("integration");
            } else if(StringUtils.isNotBlank(testIp) && containsIp(testIp, env)) {
                config.setEnv("test");
            } else if(StringUtils.isNotBlank(developmentIp) && containsIp(developmentIp, env)) {
                config.setEnv("development");
            } else if(StringUtils.isNotBlank(previewIp) && containsIp(previewIp, env)) {
                config.setEnv("preview");
            }
        }

        if(StringUtils.isBlank(config.getEnv())) {
            String env1 = prop.getString("env", "");
            config.setEnv(StringUtils.isEmpty(env1)?"development":env1);
        }

        if(!config.getEnv().equals("development") && !config.getEnv().equals("production") && !config.getEnv().equals("preview") && !config.getEnv().equals("test") && !config.getEnv().equals("integration")) {
            config.setEnv("development");
        }

    }

    private static boolean containsIp(String ipSet, List<String> localIps) {
        String[] ips = ipSet.split("\\|\\|");
        String[] var6 = ips;
        int var5 = ips.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            String ip = var6[var4];
            if(localIps.contains(ip)) {
                return true;
            }
        }

        return false;
    }
}
