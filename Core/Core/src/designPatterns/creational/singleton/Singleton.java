package designPatterns.creational.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private Singleton() {
        if (Holder.INSTANCE != null) {
            throw new RuntimeException("Use getInstance()");
        }
    }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    // Serialization safety
    protected Object readResolve() {
        return getInstance();
    }
}


/*
        | Feature                         |      Explanation                                             |
        | -------------------            | -------------------------------------                 |
        | Thread safety               |      Class loading is synchronized                  |
        | Lazy loading                   | Inner class loads only when accessed          |
        | Class loader safety        | JVM class loading rules                               |
        | Serialization safe          | `readResolve()` returns same instance       |
        | Reflection safe              | Constructor guard                                       |

*/
