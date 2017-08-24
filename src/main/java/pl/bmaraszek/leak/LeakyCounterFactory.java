package pl.bmaraszek.leak;

import java.net.URLClassLoader;

public class LeakyCounterFactory {
    public static ILeakyCounter newInstance() throws Exception {
        URLClassLoader tmp = new URLClassLoader(((URLClassLoader)LeakyCounter.class.getClassLoader()).getURLs()){
            public Class loadClass(String name) {
                try {
                    if (LeakyCounter.class.getName().equals(name) || Leak.class.getName().equals(name)) return findClass(name);
                    return super.loadClass(name);
                } catch(Exception e) {
                    throw new Error("BOOM!");
                }
            }
        };
        return (ILeakyCounter) tmp.loadClass("pl.bmaraszek.leak.LeakyCounter").getConstructor().newInstance();
    }
}
