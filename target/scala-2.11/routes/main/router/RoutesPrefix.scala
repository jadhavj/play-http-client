// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play-http-client/conf/routes
// @DATE:Sat Sep 01 01:35:41 IST 2018


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
