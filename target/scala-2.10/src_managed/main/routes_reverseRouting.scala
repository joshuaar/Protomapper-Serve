// @SOURCE:/home/josh/workspace2/Protomapper/Protomapper-Serve/conf/routes
// @HASH:b3124ce9841ad8b48d2d6d08a8af98fccb47f989
// @DATE:Fri Dec 13 13:29:45 MST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:8
def summary(q:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "summary" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)))))
}
                                                

// @LINE:7
def query(q:String, r:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "query" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)), Some(implicitly[QueryStringBindable[String]].unbind("r", r)))))
}
                                                
    
}
                          
}
                  


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:8
def summary : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.summary",
   """
      function(q) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "summary" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q)])})
      }
   """
)
                        

// @LINE:7
def query : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.query",
   """
      function(q,r) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "query" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("r", r)])})
      }
   """
)
                        
    
}
              
}
        


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:8
def summary(q:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.summary(q), HandlerDef(this, "controllers.Application", "summary", Seq(classOf[String]), "GET", """""", _prefix + """summary""")
)
                      

// @LINE:7
def query(q:String, r:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.query(q, r), HandlerDef(this, "controllers.Application", "query", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """query""")
)
                      
    
}
                          
}
        
    