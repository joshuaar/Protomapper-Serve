Protomapper-Serve
=================
This is the source code for the Protomapper Server.
The project consists of a Play! application in addition to the underlying
Lucene-based search library, and can be run in either standalone mode or
as a library to be imported into custom projects

#About
This is a search engine created for biological sequences, although the principals
are useful for any fulltext search for finite nonrecursive regular expressions.
Some examples of finite regular expressions are as follows:

    chic.go

matches chicago, chicego, chicugu, chiczgo, chic@go, etc.

    chic{2,4}ago

matches chiccago, chicccago, and chiccccago but not chicago

    [cd]hicago

maches chicago and dhicago

Basically, this program can search for the regular expressions restricted to the following grammar elements:

    []
    {}
    .
    | (or of two expressions)
    ^ (this means the AND of two expressions, not the beginning of a string as in normal regex)

This means, no parentheses, no * (but you can do ranges), and no lookahead/lookbehinds

These restrictions enable super fast fulltext searches of huge databases for regular expression-like patterns using Lucene

#Build as Server
This software is meant to be built with play 2.2.3 with the following command:

    play dist

The standalone application is zipped in $APP_ROOT/target/universal

Alternatively, if you do not want a standalone zip file for deployment anywhere,
the server can be started with the following command:

    play "start 80"

NOTE: scripts will not work when project is built with "play dist"
You must create the Lucene index some other way when running in standalone mode

#Build as Library
If you just want to use the Protomapper-Search library in your own application,
execute the following:

    play "project protomapperSearch" assembly

The jar file will be placed in target/. This was tested with sbt 0.13.1.

No Maven repo, I will make one if there is need.

