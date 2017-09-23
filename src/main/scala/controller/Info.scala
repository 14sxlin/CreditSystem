package controller

import javax.servlet.http.HttpSession

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

/**
  * Created by linsixin on 2017/9/23.
  */
@Controller
class Info {

  @RequestMapping(value = Array("/info"),
    method = Array(RequestMethod.POST,RequestMethod.GET))
  def getPersonInfo(session:HttpSession):String = {
    val student = session.getAttribute("user")
    if(student == null)
      "redirect:login"
    else{
      "userInfo"
    }
  }
}
