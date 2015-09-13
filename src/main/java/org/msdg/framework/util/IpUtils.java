package org.msdg.framework.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;

/**
 * IP帮助类
 */
public class IpUtils {

    private static final Logger LOGGER = LogManager.getLogger(IpUtils.class);
	
	/**
     * 判断当前系统是否是windows系统
     * @return
     */
    public static boolean isWinOS() { 
        if (System.getProperty("os.name").toLowerCase().contains("windows")) { 
        	return true; 
        } 
        
        return false; 
    } 
   
    /**
     * 获取本机IP地址
     * 并自动区分Windows还是Linux操作系统 
     * @return
     * @throws UnknownHostException 
     * @throws SocketException 
     */
    public static String getLocalIP() { 
        String sIp = ""; 
        InetAddress ip = null;
        
        // 如果是Windows操作系统 
        if (isWinOS()) { 
        	try {
				ip = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				LOGGER.error(e.getMessage(), e);
			}
        	
            if (null != ip) { 
            	sIp = ip.getHostAddress();
            	ip = null;
            	return sIp;
            }
        } 
        
        // 如果是Linux操作系统 
        boolean bFindIP = false;
        NetworkInterface network = null;
        Enumeration<InetAddress> ips = null;
        Enumeration<NetworkInterface> netInterfaces = null;
        
		try {
			netInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			LOGGER.error(e.getMessage(), e);
		} 
        
		while (netInterfaces.hasMoreElements()) { 
            if (bFindIP) { 
                break; 
            } 
            
            network = netInterfaces.nextElement();
            
            // ----------特定情况，可以考虑用ni.getName判断 
            // 遍历所有ip 
            ips = network.getInetAddresses(); 
			while (ips.hasMoreElements()) {
				ip = ips.nextElement();
				
				if(ip.isLoopbackAddress()){
					continue;
				}
				
				if(ip.getHostAddress().contains(":")){
					continue;
				}
				
				if (ip.isSiteLocalAddress()) {
					bFindIP = true;
					break;
				}
			}
   
        } 
   
        if (null != ip) { 
        	sIp = ip.getHostAddress(); 
        }
        
        ip = null;
        ips = null;
        network = null;
        netInterfaces = null;
        
        return sIp; 
    }
    
    /**
     * 获取客户端请求的IP地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("Cdn-Src-Ip");//增加CDN获取ip
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static List<String> getLocalIp() {
        ArrayList ipList = new ArrayList();
        Pattern pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");

        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();

            while(e.hasMoreElements()) {
                Enumeration list = ((NetworkInterface)e.nextElement()).getInetAddresses();

                while(list.hasMoreElements()) {
                    String ip = ((InetAddress)list.nextElement()).getHostAddress();
                    if(pattern.matcher(ip).matches()) {
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException var5) {
            var5.printStackTrace();
        }

        return ipList;
    }
}
