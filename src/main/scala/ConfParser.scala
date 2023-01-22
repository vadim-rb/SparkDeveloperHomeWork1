class ConfParser extends scopt.OptionParser[Conf]("HomeWork1"){
  head("HomeWork1")
  opt[String]('o', "outfile") valueName "<outfile>" action {
    (of, c) => c.copy(outFile = of)}
  note("Notice")
}
