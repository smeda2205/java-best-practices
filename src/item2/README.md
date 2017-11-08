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
parameterless constructor to create the object and then call setter methods to set each required parameter and each optional parameters. However, Java Bean pattern allows inconsistency, mandates mutability. Because construction is split across multiple calls, the class does not have
an option  of enforcing consistency merely by checking the validity of the constructor parameters. Since it is not possible to make the class immutable with javabeans pattern, it requires added effort on the part of the programmer to ensure thread safety.

Finally and luckily, there is safe and better approach that is [_Builder_](https://github.com/farruhx/java-best-practices/tree/master/src/item2/builder_pattern) pattern which combines the safety of the telescoping constructor pattern
with the readability od the Java Beans pattern. It works this way: it makes the desired object directly, the client calls a constructor (or static factory) with all of the required parameters
and gets a builder object, and then the client calls setter like methods on the builder object to set each optional parameters of interest.
Finally, the client calls a parameterless build method to generate the object which is immutable.
Builder is a static member class of the class it builds.

**Builder pattern simulates named optional parameters.**

Like constructors, a builder can impose the invariant on its parameters. The build method can check the invariants.
It is important the fields must be checked in object fields after copying from the builders fields, and then the build method must throw an Illegal State exception, if any fields are violated against invariants.

Better way to impose the invariants involving multiple parameters is to have setter methods take entire groups of parameters on which some invariants must hold.

## Advantages of Builder pattern

1. Builders can have multiple varargs parameters. However, constructors, like methods can have only one varargs parameters. Because
builders use separate methods to set each parameter, they can have as many varargs parameters as you like, up to one per setter method.

2. Builder pattern is flexible. A single builder can be used to build multiple objects. The parameters of the builder can be tweaked between object creations to vary the objects.
The builder can fill in some fields automatically, such as a serial number that automatically increases each time an object is created.


## Disadvantages of Builder pattern

1. It is verbose, compared to telescoping constructor pattern. So it should be used only if there are enough parameters, say four or more.
It is often better to start with a builder in the first place.

2. The cost of creating the builder is unlikely to be noticeable in practice, it could be a problem in some performance critical situations.


In summary, the builder pattern is good a choice  when designing classes whose constructors or static factories would have more than a handful of parameters, especially if most of those parameters are optional.
Client code is much easier to read and write with builders than with the traditional telescoping constructors pattern, and builder are much safer than java beans.





