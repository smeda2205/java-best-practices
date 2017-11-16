# Item 5: Avoid creating unnecessary objects

It is often good practice to reuse a single object instead of creating a new functionally equivalent object each time it is needed.
Reuse is both faster and stylish. An object can be used if it is immutable.

Here is an extreme example of what not to do, the see the following statement

            `String s = new String("stringette");`
            
It creates new instance each time it is executed, and none of those object creations necessary. Actually, argument is itself a String instance.
            
     





