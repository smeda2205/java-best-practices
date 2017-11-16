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
Here is an example of [`isBabeBoomer`]() which tells whether a person is baby boomer, in other words whether baby was born between 1946 and 1964.





