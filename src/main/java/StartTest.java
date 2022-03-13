import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StartTest {

 public Test test = new Test();

    public void start(Class c) {
        List<Method> methods = new ArrayList<>();
        Method[] classMethods = c.getDeclaredMethods();

        for (Method m : classMethods) {
            if (m.isAnnotationPresent(MyTest.class)) {
                methods.add(m);
            }
        }

        methods.sort(Comparator
                .comparingInt((Method i) -> i.getAnnotation(MyTest.class).priority())
                .reversed());


        for (Method m : classMethods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (methods.size() > 0 && methods.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("@BeforeSuite annotation method > 1");
                }
                methods.add(0, m);
            }
        }

        for (Method m : classMethods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (methods.size() > 0 && methods.get(methods.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("@AfterSuite annotation method > 1");
                }
                methods.add(m);
            }
        }

        for (Method m : methods) {
            try {
                m.invoke(test);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
