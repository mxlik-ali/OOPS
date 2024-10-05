package com.ali.OOPS2.Human;

public class Singleton {

    // Private static variable that holds the single instance of the class.
    // It's initially set to null, meaning no instance has been created yet.
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside the class.
    // This ensures that no other code can create a new instance of Singleton
    // using the 'new' keyword.
    private Singleton() {
        // Private constructor to restrict instantiation
    }

    // Public static method to provide access to the single instance of the class.
    // This method checks whether an instance has already been created, and if not, it creates one.
    // If an instance has already been created, it simply returns the existing instance.
    public static Singleton isInstance() {
        // Check if the instance has already been created
        if (instance == null) {
            // If instance is null, no object has been created yet, so create a new one
            instance = new Singleton();
        }
        // Return the single instance (newly created or existing)
        return instance;
    }
}

/*
Internal Working of the Singleton Pattern:
Private Constructor:
    The constructor private Singleton() is private, meaning no other class or code outside of
    the Singleton class can create an instance of it using the new keyword. This is key to controlling
    the number of instances created.
    Since the constructor is private, any external attempt to create a new instance (e.g., new Singleton())
    will fail, preventing the creation of multiple objects.

Private Static Variable (instance):
    The static variable private static Singleton instance; holds the single instance of the Singleton class.
    It is initially null because no instance is created at the beginning.
    Public Static Method (isInstance()):

This method is responsible for ensuring only one instance of the class is created and providing access to that single instance.
The method checks if instance == null (i.e., no instance exists yet). If the condition is true, it creates a new Singleton
object and assigns it to the instance variable.
If instance != null (i.e., an instance already exists), it simply returns the already created instance without creating a new one.
Static Keyword:

Both the instance variable and the isInstance() method are static, meaning they belong to the class itself, not to any specific object. This allows the method to be called without needing an object of Singleton, and ensures there is only one shared instance across the entire application.
 */
