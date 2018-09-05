// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play-http-client/conf/routes
<<<<<<< HEAD
// @DATE:Wed Sep 05 17:59:29 IST 2018
=======
// @DATE:Fri Aug 31 23:35:32 IST 2018
>>>>>>> parent of 91dd95f... okd


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
