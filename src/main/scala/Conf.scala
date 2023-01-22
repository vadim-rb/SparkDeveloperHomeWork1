case class Conf(outFile: String = "out.file")

object Conf {
  def parseArgs(args: Array[String]): Conf = {
    val parser: ConfParser = new ConfParser()
    parser.parse(args, Conf()) match {
      case Some(conf) => conf
      case None =>
        sys.error("Could not parse arguments")
    }
  }
}