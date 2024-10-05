package com.ali.OOPS4.access;

public class A {
    // 'private' variables are only accessible within the class. This means no access to this variable
    // outside this class (not even by subclasses).
    private int num;

    // 'public' variables can be accessed anywhere, in any package or class.
    public int numpublic = 3;

    // 'no modifier' (package-private) can only be accessed within the same package.
    String name;

    // 'protected' can be accessed within the same package, and also by subclasses in different packages.
    protected String name2 = "protected";

    int[] arr;

    // Constructor
    public A(int num, String name, int[] arr) {
        // Assigning values to instance variables using 'this' to refer to the current object's fields.
        this.num = num;
        this.name = name;
        this.arr = arr;
    }

    // Getter for the 'private' variable 'num'. Since 'num' is private, we use this public getter
    // to retrieve its value outside the class.
    public int getNum() {
        return num;
    }

    // Setter for the 'private' variable 'num'. This allows us to modify the value of 'num' from outside the class
    // without exposing the actual variable directly, ensuring better control and security.
    public void setNum(int num) {
        this.num = num;
    }
}

// Access Modifiers Table
// + indicates accessibility

/*
| Modifier      | Class | Package | Subclass (same package) | Subclass (different package) | World (different package and not subclass) |
|---------------|-------|---------|-------------------------|------------------------------|--------------------------------------------|
| public        |   +   |    +    |            +            |              +               |                     +                      |
| protected     |   +   |    +    |            +            |              +               |                                            |
| no modifier   |   +   |    +    |            +            |                              |                                            |
| private       |   +   |         |                         |                              |                                            |
*/

/*
Detailed Explanation of Access Modifiers:

1. **Public**:
   - Accessible from anywhere, any package, and any class or subclass.
   - In this example, `numpublic` can be accessed from all classes, including `SubClass2` in a different package.

2. **Protected**:
   - Accessible from the same package and subclasses even if they are in different packages.
   - In this example, `name2` is accessible in `SubClass2` because it is a subclass of `A` (even though it's in a different package).
   - Note: Protected access does not work for objects of superclass type in subclass code, e.g., `A obj2 = new SubClass2()` won't allow access to `name2`.

3. **No Modifier (Package-Private)**:
   - Accessible only within the same package.
   - In this example, `name` can be accessed only by classes in the same package as `A`, not by `SubClass2` in a different package.

4. **Private**:
   - Accessible only within the class itself.
   - In this example, `num` is private, so it can only be accessed within the class `A`. To allow access to its value, we use getter and setter methods (`getNum` and `setNum`).
*/

/*
Summary:
- **Public** is for full access.
- **Protected** is for inheritance-related access, allowing subclasses to access members, even if they are in different packages.
- **Package-private (No modifier)** allows access within the same package only.
- **Private** ensures that members are not accessible outside the class they are defined in.
*/


