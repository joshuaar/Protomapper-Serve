Protomapper-Serve
=================
This is the source code for the Protomapper Server.
The project consists of a Play! application in addition to the underlying
Lucene-based search library, and can be run in either standalone mode or
as a library to be imported into custom projects

#Build as Server
This software is meant to be built with play 2.2.3 with the following command:

    play dist

The standalone application is zipped in $APP_ROOT/target/universal

Alternatively, if you do not want a standalone zip file for deployment anywhere,
the server can be started with the following command:

    play "start 80"

NOTE: scripts will not work unless project is first built with "play dist"
#Build as Library
If you just want to use the Protomapper-Search library in your own application,
execute the following:

    cd modules/Protomapper-Search
    sbt assembly

The jar file will be placed in target/ .This was tested with sbt 0.13.1.
No Maven repo yet, will do if there is need.
