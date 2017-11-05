# Item 1: Consider static factory methods instead of constructors.

A class can provide its clients with static factory methods instead of, or in addition to, constructors.
This approach has both advantages and disadvantages:

## Advantages

1. One advantage of static factory methods is that, unlike constructors, they have names. Useful when a class seems to require
multiple constructors with the same signature, is the replacement of the constructors with static methods and carefully chosen names
to highlight their differences.

2. A second advantages of static factory methods is that unlike constructors, they are not required to create
a new object each time they are invoked. Very useful to avoid creating unnecessary duplicate objects, resulting improved
performance. And it enable to implement instance-controlled feature such as singleton. And it allows
an immutable class to make the guarantee that no two equal instances exist.

3. A third advantage of static factory methods is that, unlike constructors, they can return an object 
of any subtype of their return type. It enables API to return objects without making their classes public, as an example Java Collections Framework has thirty two 
convenience implementations of its collections interface, providing unmodifiable collections, synchronized collections, and the like.
The class of the object returned by a static factory method need not even exist at the time the class containing the method is written.
As an example of [Service Provider Framework Sketch API](https://github.com/farruhx/java-best-practices/tree/master/src/item1/service_provider_sketch).

4.A fourth advantage of static factory methods is that they reduce the verbosity of creating parametrized type instances. As shown in the example [here](https://github.com/farruhx/java-best-practices/tree/master/src/item1/fourth_advantage).
You must specify the type parameters when you invoke the constructor of a parametrized class even if they are obvious from context.
This redundant specification quickly becomes painful as the length and complexity of the type parameters increase. With static factories, however, the compiler can
figure out the type parameters for you. This is known as type inference. However, this inference is finally implemented from release 1.7 for the constructors.





