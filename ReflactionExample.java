
/*
public class ReflactionExample {
    public static void main (String[] args) throws ClassNotFoundException {
        //1 - By using Class.forname() method
        Class c1 = Class.forName("ReflactionExample");
        System.out.println(c1.getName());

        //2- By using getClass() method
        ReflactionExample obj = new ReflactionExample();
        Class c2 = obj.getClass();

        //3- By using .class
        Class c3= ReflactionExample.class;

        Class stringMetaClass = String.class;
        System.out.println(stringMetaClass.getName());
        Class stringSuperClassMeta = stringMetaClass.getSuperclass();
        System.out.println(stringSuperClassMeta.getName());
    }
}
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflactionExample {
    // Create Class object for ClassExample01.class
    static Class classExample01MC = ClassExample01.class;
    public static void main(String[] args) throws ClassNotFoundException {
        // Print name of the class
        System.out.println("Name of the class is : " + classExample01MC.getName());

        // Print Super class name
        System.out.println("Name of the super class is : " + classExample01MC.getSuperclass().getName());

        // Get the list of implemented interfaces in the form of Class array using getInterfaces() method
        Class[] interfaceArray = classExample01MC.getInterfaces();

        // Print the implemented interfaces using foreach loop
        System.out.print("Implemented interfaces are : ");
        for (Class currentInterface : interfaceArray) {
            System.out.println(currentInterface.getName() + " ");
        }
        System.out.println();

        //Get access modifiers using get Modifiers() method and toString() method of java.lang.reflect.Modifier class
        int modificators = classExample01MC.getModifiers();
        // Print the access modifiers
        System.out.println("Access modifiers of the class are : " + Modifier.toString(modificators));

        // Create Class object for ClassExample02.class
        ClassExample01 objClassExample01 = new ClassExample01(1);
        // Get the metadata of all the fields of the class ClassExample01
        Field[] fields = classExample01MC.getDeclaredFields();

        // Print name, datatypes, access modifiers and values of the varibales of the specified class
        for (Field field : fields) {
            try {
                System.out.println("Variable name : " + field.getName());
                System.out.println("Datatypes of the variable :" + field.getType());

                int modifiers = field.getModifiers();
                System.out.println("Access Modifiers of the variable : " + Modifier.toString(modifiers));
                System.out.println("Value of the variable : " + field.get(objClassExample01));
            } catch (Exception ex) {
                System.out.println("!!!!!!!!!!!!");
                System.out.println(ex.toString());
                System.out.println("!!!!!!!!!!!!");
            } finally {
                System.out.println("======================");
            }
        }
        // Get the metadata or information of all the methods of the class using getDeclaredMethods()
        Method[] methods = classExample01MC.getDeclaredMethods();

        for (Method method : methods) {
            // Print the method names
            System.out.println("Name of the method : " + method.getName());

            // Print return type of the methods
            System.out.println("Return type of the method : " + method.getReturnType());

            // Get the access modifier list and print
            int modifierList = method.getModifiers();
            System.out.println("Method access modifiers : " + Modifier.toString(modifierList));

            // Get and print parameters of the methods
            Class[] parametersClasses = method.getParameterTypes();
            System.out.print("Method parameter types : ");
            for (Class currentClass : parametersClasses) {
                System.out.println(currentClass.getName() + " ");
            }
            System.out.println();

            // Get and print exception thrown by the method
            Class[] exceptionsClasses = method.getExceptionTypes();
            System.out.println("Exception thrown by method :");
            for (Class currentClass : exceptionsClasses) {
                System.out.println(currentClass.getName() + " ");
            }
            System.out.println("=================================");
        }
        // Get all the constructor information in the Constructor array
        Constructor[] constuctors = classExample01MC.getConstructors();
        for (Constructor constructor : constuctors) {
            // Print all name of each constructor
            System.out.println("Constructor name : " + constructor.getName());

            //Get and print access modifiers of each constructor
            int modifiers = constructor.getModifiers();
            System.out.println("Constructor modifier : " + Modifier.toString(modifiers));

            // Get and print parameter types
            Class[] parametersClasses = constructor.getParameterTypes();
            System.out.println("Constructor parameter types :");
            for (Class currentClass : parametersClasses) {
                System.out.println("- " + currentClass.getName() + " ");
            }
            System.out.println();

            // Get and print exception thrown by constructors
            Class[] exceptionsClasses = constructor.getExceptionTypes();
            System.out.println("Exception thrown by constructors :");
            for (Class class1 : exceptionsClasses) {
                System.out.println(class1.getName() + " ");
            }
            System.out.println("========================================");
        }
    }
}


