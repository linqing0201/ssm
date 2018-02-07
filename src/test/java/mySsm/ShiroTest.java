package mySsm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class ShiroTest {
	Subject subject=null;
	private void login(String configFile) {  
	    //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory(configFile);  
	  
	    //2、得到SecurityManager实例 并绑定给SecurityUtils  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);  
	  
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    subject= SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
	  
	    subject.login(token);  
	}
	@Test
	public void test1(){
//		login("classpath:shiro-role.ini");
//		System.out.println(subject.hasRole("role12"));
//		subject.checkPermission("user:create1");
	}
}
