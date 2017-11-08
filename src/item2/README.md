# Item 2: Consider a builder when faced with many constructor parameters

Static factories and public constructors share a limitation when it comes to a time 
they need to  scale well to large numbers of optional parameters. Imagine a class
representing the Nutrition Facts label that appears on packaged foods. These labels have a few required fields such as serving size and 
calories per serving and over twenty optional fields such as total fat, saturated fat and so on. Most products
have non zero values for only a few of these optional fields.


To implement static factories or public constructors for such classes, the programmers have traditionally 
used [_telescoping constructor_]() pattern, in which you provide first constructor with only the required parameters,
the second one with single optional parameters, the third one with two optional parameters and so on.
