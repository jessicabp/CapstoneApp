# README #

Some tests on gloun maps' image caching.
gluon maps has it's own image caching system, I originally thought
this would not store images indefinately, but it appears that it does,
so we should not have to worry about the app losing tiles it has loaded 
before. Potentially this could use a lot of storage if the user visits a
lot of locations, but generally the OS has ways of clearing the cache
manually and I doubt it would be a problem.
