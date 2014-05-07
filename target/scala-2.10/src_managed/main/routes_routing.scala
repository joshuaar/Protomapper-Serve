// @SOURCE:/home/josh/code/Protomapper-Serve/conf/routes
// @HASH:ed6860754ae9843ba104396a7ba117234deb1bc4
// @DATE:Tue May 06 12:25:54 MST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_query1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("query"))))
        

// @LINE:8
private[this] lazy val controllers_Application_summary2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("summary"))))
        

// @LINE:9
private[this] lazy val controllers_Application_download3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("download"))))
        

// @LINE:12
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """query""","""controllers.Application.query(q:String, r:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """summary""","""controllers.Application.summary(q:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """download""","""controllers.Application.download(q:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_query1(params) => {
   call(params.fromQuery[String]("q", None), params.fromQuery[String]("r", None)) { (q, r) =>
        invokeHandler(controllers.Application.query(q, r), HandlerDef(this, "controllers.Application", "query", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """query"""))
   }
}
        

// @LINE:8
case controllers_Application_summary2(params) => {
   call(params.fromQuery[String]("q", None)) { (q) =>
        invokeHandler(controllers.Application.summary(q), HandlerDef(this, "controllers.Application", "summary", Seq(classOf[String]),"GET", """""", Routes.prefix + """summary"""))
   }
}
        

// @LINE:9
case controllers_Application_download3(params) => {
   call(params.fromQuery[String]("q", None)) { (q) =>
        invokeHandler(controllers.Application.download(q), HandlerDef(this, "controllers.Application", "download", Seq(classOf[String]),"GET", """""", Routes.prefix + """download"""))
   }
}
        

// @LINE:12
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     