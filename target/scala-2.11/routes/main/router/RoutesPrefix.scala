// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play-http-client/conf/routes
// @DATE:Thu Sep 06 19:39:35 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
