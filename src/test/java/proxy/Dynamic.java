package proxy;
import com.jjs.proxy.Calculator;
import com.jjs.proxy.CalculatorImpl;
import com.jjs.proxy.ProxyFactory;
import org.junit.Test;

public class Dynamic {
    @Test
     public void test1(){
        ProxyFactory factory=new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.add(1,2);
    }



}
