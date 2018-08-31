// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play-http-client/conf/routes
// @DATE:Sat Sep 01 01:35:41 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def ping(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ping")
    }
  
  }


}
