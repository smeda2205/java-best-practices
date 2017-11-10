# Item 3: Enforce noninstantiability with a private constructor

Sometimes, we need to write a class that is just a group of static methods and static fields.
They can be used to group related methods on primitive values or arrays, for example `java.lang.Math` or
`java.util.Arrays`.

They can also be used to group static methods, including factory methods, for objects that implements a particular interface, for example `java.util.Collections`.
However, such classes were not designed to be instantiated: an instance would be nonsensical. And in the absence of explicit constructors, however, the compiler provide a public, parameterless default constructor.
To a client, this constructor is no different from any other.

**Attempting to enforce noninstantiability by making a class abstract does not work.** Because the class can be subclassed and subclass instantiated.
Furthermore, it misleads the user into thinking the class was designed for inheritance.

However, there is one way to make a class noninstantiable by including a private constructor as [shown here](). Because, a default constructor is generated only if a class contains no explicit constructors.






