# Item 3: Enforce the singleton property with a private constructor or an enum type

Singleton is simply a class that is instantiated exactly once. However, **making a class a singleton can make it difficult
to test its clients**.

Before release 1.5, there are two ways to implement singleton. Both are based on keeping the constructor private
and exporting a public static member to provide access to sole instance. In the [first approach](https://github.com/farruhx/java-best-practices/tree/master/src/item3/singleton_first_approach), the member is a final field:

In the first approach, the private constructor is called only once, to instantiate the public static final field `Elvis.INSTANCE`
No existence of public and protected constructor guarantees a `monoelvistic ` universe: exactly one Elvis instance will exist once the Elvis class is instantiated.
Nothing  the client does can change this. However, the client with privilege can invoke the private constructor reflectively with the help of `AccessibleObject.setAccessible` method.
One way to prevent such an attack is to modify the constructor  to make it throw an exception if it is asked to create a second instance.

## Advantage

1. From the declaration, it is clear the class is  a singleton: the public static field is final, so it will always  contain the same object reference. No longer performance issue.

In the [second approach](https://github.com/farruhx/java-best-practices/tree/master/src/item3/singleton_second_approach) to implementing  singletons, the public member is a static factory method.
All calls to `Elvis.getInstance` return the same object reference, and no other `Elvis` instance will ever be created (with the same problem as mentioned above).

## Advantage

1. One advantage of the factory method is it gives the flexibility to change your mind about whether the class should be a singleton
without  changing its API. The factory method return the sole instance but could easily be modified to return, for example, a unique instance for each thread that invokes.


To make the singleton class that is implemented using either of the approaches mentioned above _serializable_, it is not sufficient merely to add _implements Serializable_ to its declaration. To maintain the singleton, you have to declare  all the instance fields `transient` and provide
a `readResolve` method. Otherwise, each time a serialized instance is deserialized, a new instance will be created, leading to broken singleton property.
To prevent this, add this `readResolve` method to the `Elvis` class.


Finally, as of 1.5 release, there is a third approach to implementing singletons. Simply make an enum type with one element.
This approach is preferable, and this approach is functionally equivalent to the public field approach, except that it is more concise, and provides
the serialization machinery for free, and provides an ironclad guarantee against multiple instances, even in the face of sophisticated serialization or refection attacks.

In short, single-element type is the best way to implement a singleton.




