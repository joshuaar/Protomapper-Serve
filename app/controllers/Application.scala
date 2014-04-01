package controllers 
import com.protomapper.compile._
import com.protomapper.update._
import com.protomapper.search._
import org.biojava3.core.sequence.ProteinSequence
import org.apache.lucene.store.NIOFSDirectory
import java.io.File
import play.api._
import play.api.mvc._

object Application extends Controller {
  val parser = new PatternParser
  val compiler = new PatternCompiler(parser,3)
  val ix = new NIOFSDirectory(new File("/root/lucene4"))
  val access = new LuceneAccess(ix)
  val search = new Searcher(compiler,access)
  def index = Action {
    Ok(views.html.index("Your new application asds ready."))
  }
  
  def query(q:String,r:String) = Action {
    val range = r.split("%")
    val from = range(0)
    val to = range(1)
    val res = search.search(q)
    val out = res.getJSON(from.toInt, to.toInt)
    Ok(out)
  }
  
  def summary(q:String) = Action {
    val res = search.search(q)
    val out = res.countOrgsJSON()
    Ok(out)
  }

}
