import scala.io.Source
import com.github.plokhotnyuk.jsoniter_scala.macros._
import com.github.plokhotnyuk.jsoniter_scala.core._
import io.scalaland.chimney.dsl._

import java.io.FileWriter

object Main {
  implicit val codecIn: JsonValueCodec[List[CountryLite]] = JsonCodecMaker.make
  implicit val codecOut: JsonValueCodec[List[OutFileClass]] = JsonCodecMaker.make
  def main(args: Array[String]): Unit = {
    val conf = Conf.parseArgs(args)
    println(f"${conf.outFile}")
    val raw = Source.fromURL("https://raw.githubusercontent.com/mledoze/countries/master/countries.json")
    val raw_string = raw.mkString
    raw.close()
    val deserialized: List[CountryLite] = readFromString[List[CountryLite]](raw_string)
    val out_content = deserialized.filter(_.region == "Africa").sortBy(_.area)(Ordering[BigDecimal ].reverse).take(10)
    val out_content_final = out_content.map(x => x.into[OutFileClass]
      .withFieldComputed(_.name, _.name.official)
      .withFieldComputed(_.capital, _.capital.head)
      .transform)
    val json = writeToArray(out_content_final)
    println(out_content)
    val data_for_file: String = new String(json, "UTF-8")
    println(data_for_file)
    val a = new FileWriter(conf.outFile)
    a.write(data_for_file)
    a.close()
  }
}