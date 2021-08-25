package com.framework;
import static org.junit.Assert.assertEquals;
import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import com.config.PropConfig;
import com.config.YAMLConfig;
import com.opensymphony.xwork2.ActionProxy;
import com.strut.ProfileAction; 
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Struts_ControllerLayerTest  extends StrutsSpringJUnit4TestCase<ProfileAction> {
	@Autowired
	PropConfig p;
	@Autowired
	YAMLConfig y;

	@Test
	public void test1strutsRegister() throws Exception {
        request.addParameter("userid", "tester");	// pass param to url
        request.addParameter("pwd", "t123");
        ActionProxy proxy = getActionProxy("/register"); // invoke url
        String result = proxy.execute();
        assertEquals("success", result);        
    }
//	http://localhost/verify?userid=john&pwd=john1!				

	@Test
	public void test2strutsVerify() throws Exception{
		request.addParameter("userid", "tester");
		request.addParameter("pwd", "t123");
		ActionProxy proxy=getActionProxy("/verify");
		String result=proxy.execute();
		assertEquals("success", result);
	}
	@Test
	public void test3strutsUpdate() throws Exception{
		request.addParameter("userid", "tester");
		request.addParameter("pwd", "t12345");
		ActionProxy proxy=getActionProxy("/update");
		String result=proxy.execute();
		assertEquals("success", result);
	}
	@Test
	public void test4strutsDelete() throws Exception{
		request.addParameter("userid", "tester");
		ActionProxy proxy=getActionProxy("/delete");
		String result=proxy.execute();
		assertEquals("success", result);
	}
	
	
}