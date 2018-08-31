// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play-http-client/conf/routes
// @DATE:Fri Aug 31 21:42:08 IST 2018

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
