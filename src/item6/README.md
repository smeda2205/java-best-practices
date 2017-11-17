# Item 6: Eliminate obsolete object reference

If you have worked in other languages such as C or C++ in which you have to manually manage memories, when you switch to Java, it seems like magic the objects are automatically reclaimed.
It leads to impression that you do not have to think about memory management. but it is not true;

Consider the following [simple stack implementation](https://github.com/farruhx/java-best-practices/tree/master/src/item6/simplestack). Obviously, there is nothing wrong with this program. You could test it exhaustively, 
and it would pass all the tests with flying colors. However, there is a problem  lurking, you can call it memory leak. It leads to reduced performance due to increased garbage collection activity or increased memory footprints.
Sometimes such memory leak can cause disk paging or even program failure with OutOfMemoryError.

The memory leak here is when a stack grows and the shrinks, the objects that were popped off the stack will not be garbage collected, 
even though the program using the stack has no more reference to them.
