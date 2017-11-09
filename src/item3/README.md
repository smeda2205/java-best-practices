# Item 3: Enforce the singleton property with a private constructor or an enum type

Singleton is simply a class that is instantiated exactly once. However, **making a class a singleton can make it difficult
to test its clients**.

Before release 1.5, there are 2 ways to implement singleton. Both are based on keeping the constructor private
and exporting a public static member to provide access to sole instance. In the [first approach], the member is a final field:

In the first approach, the private constructor is called only once, to instantiate the public static final field _Elvis.INSTANCE_
No existence of public and protected constructor guarantees a `monoelvistic ` universe: exactly one Elvis instance will exist once the Elvis class is instantiated.
Nothing  the client does can change this. However, the client with privilege can invoke the private constructor reflectively with the help of AccessibleObject.setAccessible method.
One way to prevent such an attack is to modify the constructor  to make it throw an exception if it is asked to create a second instance.



