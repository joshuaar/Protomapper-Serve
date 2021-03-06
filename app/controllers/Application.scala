package controllers 
import scala.concurrent.ExecutionContext.Implicits.global
import com.protomapper.compile._
import com.protomapper.update._
import com.protomapper.search._
import org.biojava3.core.sequence.ProteinSequence
import org.apache.lucene.store.NIOFSDirectory
import java.io.File
import play.api._
import play.api.mvc._
import play.api.libs.iteratee.Enumerator
import play.api.mvc.Results._

object Application extends Controller {
  //get lucene directory defined in application.conf
  val ixpath = Play.current.configuration.getString(
      "application.ix_path").get 
  val ixLen = Play.current.configuration.getString(
      "application.ix_len").get.toInt
  val ixMaxHits = Play.current.configuration.getString(
      "application.max_hits").get.toInt
      
  //initialize lucene access singletons
  val parser = new PatternParser
  val compiler = new PatternCompiler(parser,ixLen)
  val ix = new NIOFSDirectory(new File(ixpath))
  val access = new LuceneAccess(ix,ixLen,ixMaxHits)
  val search = new Searcher(compiler,access)
  
  
  def index = Action {
    Redirect(
    "/assets/Protomapper-ui/index.html"
    )
  }
  
  def query(q:String,r:List[String]) = Action {
    val range = r
    val from = range(0)
    val to = range(1)
    val res = search.search(q)
    val out = res.getJSON(from.toInt, to.toInt)
    Ok(out)
  }
   def query(q:String,r:String,orgs:String,db:String) = Action {
    val range = r.split(",")
    val from = range(0)
    val to = range(1)
    val res = search.search(q,parseList(orgs),parseList(db))
    val out = res.getJSON(from.toInt, to.toInt)
    Ok(out)
  }
   
   private def parseList(in:String):List[String] = {
     if(in.length > 0) in.split(",").toList else List()
   }
  
  def getIndexed(field:String) = Action {
    val res = access.getIndexedTerms(field)
    val out = "["+res.map(a=> """"""" + a + """"""").mkString(",")+"]"
    Ok(out)
  }
   
  def download(q:String,orgs:String,db:String) = Action {
    val res = search.search(q,parseList(orgs),parseList(db))
    val (data,reader) = res.getFastaStream()
    val dataBytes = data.view.map(a=>a.getBytes()).toIterator
    class ClosableIterator extends Iterator[Array[Byte]]{
        def hasNext():Boolean = {
            val ret = dataBytes.hasNext
            if(!ret)
                reader.close()
            ret
        }
        def next():Array[Byte] = {
            dataBytes.next()
        }
    }
    val toEnumerate = new ClosableIterator()
    val dataContent:Enumerator[Array[Byte]] = Enumerator.enumerate(toEnumerate)
    Ok.stream(dataContent.andThen({Enumerator.eof})).withHeaders(CONTENT_TYPE -> "text/plain").withHeaders(CONTENT_DISPOSITION -> "attachment; filename=download.fasta")
  }
  
  def summary(q:String,orgs:String,db:String) = Action {
    val res = search.search(q,parseList(orgs),parseList(db))
    val out = res.countOrgsJSON()
    Ok(out)
  }

}
