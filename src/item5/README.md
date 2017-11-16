# Item 5: Avoid creating unnecessary objects

It is often good practice to reuse a single object instead of creating a new functionally equivalent object each time it is needed.
Reuse is both faster and stylish. An object can be used if it is immutable.

Here is an extreme example of what not to do, the see the following statement

            String s = new String("stringette");
            
It creates new instance each time it is executed, and none of those object creations necessary. Actually, the argument to the constructor is itself a String instance.
If this kind of object creation occurs in a loop or frequently invoked methods, millions of String instances can be created endlessly.

Improved version:

            String s = "Farruh"
            
This version uses single String instance, rather than creating new instance each time. And it is guaranteed that the object will be reused by
any other code running in the same virtual machine that happens to contain the same string literal.

Another way to avoid creation of unnecessary object  is using static factory method rather than constructor. For example,
`Boolean.valueOf(String)` is preferable to `new Boolean(String) `  The former is not required to create an object each time but the latter is.


In addition, it is also possible to reuse mutable object if you know they wont be modified. Here is a slightly more subtle
and much more common example of what not to do. It involves in mutable Date objects that are never modified once their values have been computed.
Here is an example of [`isBabeBoomer`](https://github.com/farruhx/java-best-practices/tree/master/src/item5/babeboomer) which tells whether a person is baby boomer, 
in other words whether baby was born between 1946 and 1964.

The isBabyBoomer method unnecessarily created new Calendar, TimeZone, and two Date Instances each time is invoked. The [second version](https://github.com/farruhx/java-best-practices/tree/master/src/item5/babeboomer/ImprovedPerson) is much improved and avoids this inefficiency with a static initializer.
This version creates Calendar, TimeZone and date instances only one rather than creating them every time when `isBabyMethod` is invoked.

This improved version leads to significant performance gains. On the machine, the original the original version takes 32 000 ms for 10 million invocation, while the improved version takes 130 ms, which is about 250 times faster.
Beside, the code is more clear.

Learn more about lazy initialization for better performance and the keySet of Map interface for the creation of unnecessary objects.
There is a new way to create unnecessary objects in release 1.5. It is called autoboxing, and it allows the programmer to mix primitive and boxed primitive types, boxing and unboxing automatically as needed.

Consider the following [example](https://github.com/farruhx/java-best-practices/tree/master/src/item5/calculate). This program works correct but much slower than it should be, due to a one char typographical error.
The variable sum is declared as a Long instead of a long, which means that the program constructs about Math.pow(2,31) unnecessary objects.
Changing Long to long reduces the run time from 43 seconds to 6.8 seconds on the machine.

It is clear that **use primitives to boxed primitives and watch out for unintentional autoboxing.**

However, it is not good to be misled by the implication that object creation is expensive. On the contrary, creation and reclamation of small objects whose constructs do little explicit work is cheap specially on modern JVM implementation.
Creating additional objects to enhance the clarity, simplicity and the power of the program is generally a good thing.
 







