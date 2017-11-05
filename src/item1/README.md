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
As an example of [service provider API]()




