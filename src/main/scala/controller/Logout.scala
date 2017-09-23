package controller

import javax.servlet.http.HttpSession

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
  * Created by linsixin on 2017/9/23.
  */
@Controller
class Logout {
  private val logger = LoggerFactory.getLogger(getClass)

  @RequestMapping(Array("logout"))
  def logout(session:HttpSession) : String = {
    if(session.getAttribute("user")!=null){
      logger.info(s"invalidate session : ${session.getId}")
      session.invalidate()
      "login"
    }else{
      "login"
    }
  }

}
