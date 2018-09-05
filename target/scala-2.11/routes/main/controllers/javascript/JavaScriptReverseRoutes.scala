// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play-http-client/conf/routes
<<<<<<< HEAD
// @DATE:Wed Sep 05 17:59:29 IST 2018
=======
// @DATE:Fri Aug 31 23:35:32 IST 2018
>>>>>>> parent of 91dd95f... okd

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:1
package controllers.javascript {

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def ping: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ping",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ping"})
        }
      """
    )
  
  }


}
