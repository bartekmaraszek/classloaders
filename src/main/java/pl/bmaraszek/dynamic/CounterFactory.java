package pl.bmaraszek.dynamic;

import java.net.URLClassLoader;

public class CounterFactory {
    public static ICounter newInstance() throws Exception {
        URLClassLoader tmp = new URLClassLoader(((URLClassLoader)Counter.class.getClassLoader()).getURLs()){
            public Class loadClass(String name) {
                try {
                    if (Counter.class.getName().equals(name)) return findClass(name);
                    return super.loadClass(name);
                } catch(Exception e) {
                    throw new Error("BOOM!");
                }
            }
        };
        return (ICounter) tmp.loadClass("pl.bmaraszek.dynamic.LeakyCounter").getConstructor().newInstance();
    }
}
