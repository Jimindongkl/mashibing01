package org.ld.utils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @ClassName: MiaoUitl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author miaoxiaochen
 * @date 2015-3-10 下午01:40:22
 * 
 */
public class MiaoUitl {
	private static final  Log log = LogFactory.getLog(MiaoUitl.class);
	public static String pageMiao="-1";
	private static char mapTable[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
		'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
		'9' };
	//属性文件的路径   
    static String profilepath="config.properties";   
	/**
	 * 
	 * @Title: getCode
	 * @Description: 验证码
	 * @author miaoxiaochen
	 * @date 2015-3-19 下午06:42:34
	 * @param index
	 * @return
	 */
	public static String getCode(int index){
		String code="";
		for (int i=0;i<index;i++) {
			code += mapTable[(int) (mapTable.length * Math.random())];
		}
		return code;
	}
	
	
	//创建签名SHA1
	public static String createSHA1Sign(SortedMap<String, String> signParams) throws Exception {
		StringBuffer sb = new StringBuffer();
		Set es = signParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			sb.append(k + "=" + v + "&");
			//要采用URLENCODER的原始值！
		}
		String params = sb.substring(0, sb.lastIndexOf("&"));
		return getSha1(params);
	}
	//Sha1签名
	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			//mdTemp.update(str.getBytes("GBK"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 通过key获取config.properties的value
	 * @param key	key值
	 * @return		返回value值,为空的话返回null
	 */
	public static String getConfigString(String key){
		String s_return=null;
		 InputStream in = MiaoUitl.class.getClassLoader().getResourceAsStream(  
	                "config.properties");
		 Properties properties = new Properties();  
	        try {  
	            properties.load(in);// 将输入流加载到配置对象,以使配置对象可以读取config.propertis信息  
	            if(properties.get(key)!=null)
	            s_return=properties.get(key).toString();
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
		return s_return;
	}
	
	

	public static String getTimeStamp(){
		int time=(int)(System.currentTimeMillis()/1000);
		return time+"";
	}

	
	
	
    /**  
    * 采用静态方法  
    */   
    private static Properties props = new Properties();  
    private static File f;
    static {   
    	try { 
    	InputStream in = MiaoUitl.class.getClassLoader().getResourceAsStream(  
        "config.properties");
    	f = new File(MiaoUitl.class.getClassLoader().getResource("").toURI());
            props.load(in);   
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
            System.exit(-1);   
        } catch (IOException e) {          
            System.exit(-1);   
        } catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}   
    }   
  
    /**  
    * 读取属性文件中相应键的值  
    * @param key  
    *            主键  
    * @return String  
    */   
    public static String getKeyValue(String key) {   
        return props.getProperty(key);   
    }   
  
    /**  
    * 根据主键key读取主键的值value  
    * @param filePath 属性文件路径  
    * @param key 键名  
    */   
    public static String readValue(String filePath, String key) {   
        Properties props = new Properties();   
        try {   
            InputStream in = new BufferedInputStream(new FileInputStream(   
                    filePath));   
            props.load(in);   
            String value = props.getProperty(key);   
            System.out.println(key +"键的值是："+ value);   
            return value;   
        } catch (Exception e) {   
            e.printStackTrace();   
            return null;   
        }   
    }   
   
      
    /**  
    * 更新（或插入）一对properties信息(主键及其键值)  
    * 如果该主键已经存在，更新该主键的值；   
    * 如果该主键不存在，则插件一对键值。  
    * @param keyname 键名  
    * @param keyvalue 键值  
    */   
    public static void writeProperties(String keyname,String keyvalue) {
        try {   
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。   
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。   
            OutputStream fos = new FileOutputStream(f.getAbsolutePath()+"/"+profilepath);   
            props.setProperty(keyname, keyvalue);   
            // 以适合使用 load 方法加载到 Properties 表中的格式，   
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流   
            props.store(fos, "Update '" + keyname + "' value");   
        } catch (IOException e) {  
        	e.printStackTrace();
            System.err.println("属性文件更新错误");   
        } catch (Exception e) {
			// TODO: handle exception
		} 
    }   
  
    /**  
    * 更新properties文件的键值对  
    * 如果该主键已经存在，更新该主键的值；  
    * 如果该主键不存在，则插件一对键值。  
    * @param keyname 键名  
    * @param keyvalue 键值  
    */   
    public static void updateProperties(String keyname,String keyvalue) {   
        try {   
            props.load(new FileInputStream(profilepath));   
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。   
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。   
            OutputStream fos = new FileOutputStream(f.getAbsolutePath()+"/"+profilepath);              
            props.setProperty(keyname, keyvalue);   
            // 以适合使用 load 方法加载到 Properties 表中的格式，   
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流   
            props.store(fos, "Update '" + keyname + "' value");   
        } catch (IOException e) {   
        	e.printStackTrace();
            System.err.println("属性文件更新错误");   
        }   
    }   
    
    public String  getServerIp(){  
    	String SERVER_IP=null;
        try {  
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();  
            InetAddress ip = null;  
            while (netInterfaces.hasMoreElements()) {  
                NetworkInterface ni = (NetworkInterface) netInterfaces  
                        .nextElement();  
                ip = (InetAddress) ni.getInetAddresses().nextElement();  
                SERVER_IP = ip.getHostAddress();  
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()  
                        && ip.getHostAddress().indexOf(":") == -1) {  
                    SERVER_IP = ip.getHostAddress();  
                    break;  
                } else {  
                    ip = null;  
                }  
            }  
        } catch (SocketException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
         
         return SERVER_IP;  
       }  
    public static String getLocalIP(){     
        InetAddress addr = null;     
                    try {  
                        addr = InetAddress.getLocalHost();  
                    } catch (UnknownHostException e) {  
                        // TODO Auto-generated catch block  
                        e.printStackTrace();  
                    }     
                  
                byte[] ipAddr = addr.getAddress();     
                String ipAddrStr = "";     
                for (int i = 0; i < ipAddr.length; i++) {     
                    if (i > 0) {     
                        ipAddrStr += ".";     
                    }     
                    ipAddrStr += ipAddr[i] & 0xFF;     
                }     
                //System.out.println(ipAddrStr);     
                        return ipAddrStr;     
        }    
}

