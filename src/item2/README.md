# Item 2: Consider a builder when faced with many constructor parameters

Static factories and public constructors share a limitation when it comes to a time 
they need to  scale well to large numbers of optional parameters. Imagine a class
representing the Nutrition Facts label that appears on packaged foods. These labels have a few required fields such as serving size and 
calories per serving and over twenty optional fields such as total fat, saturated fat and so on. Most products
have non zero values for only a few of these optional fields.


To implement static factories or public constructors for such classes, the programmers have traditionally 
used [_telescoping constructor_](https://github.com/farruhx/java-best-practices/tree/master/src/item2/telescoping_constructor_pattern) pattern, in which you provide first constructor with only the required parameters,
the second one with single optional parameters, the third one with two optional parameters and so on.


**This [_telescoping constructor_](https://github.com/farruhx/java-best-practices/tree/master/src/item2/telescoping_constructor_pattern) pattern works, but it is hard to write 
client code when there are many parameters, and harder still to read it.** Most of the time, this leads to confusion,resulting in subtle bugs. For example,
if the client accidentally reverses two such parameters, the compiler won't complain, but the program will misbehave at the runtime.

Another way to solve such a problem when you are faced with many constructor parameters is use the [_Java Beans_](https://github.com/farruhx/java-best-practices/tree/master/src/item2/javabeans_pattern) pattern, in which you call
parameterless constructor to create the object and then call setter methods to set each required parameter and each optional parameters. However, Java Bean pattern allows inconsistency, mandates mutability.


