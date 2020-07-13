package jvm;

/**
 * ClassLoaderDemo's classloader is: sun.misc.Launcher$AppClassLoader@18b4aac2
 * Parent classloader is: sun.misc.Launcher$ExtClassLoader@54bedef2
 * GrandPa classloader is: null
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLoaderDemo's classloader is: "+ClassLoaderDemo.class.getClassLoader());
        System.out.println("Parent classloader is: "+ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("GrandPa classloader is: "+ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
