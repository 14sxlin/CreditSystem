package controller

import model.LoginInfo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import utils.EncodingUtils

/**
  * Created by linsixin on 2017/9/21.
  */
@Controller
class Login {

  private val logger = LoggerFactory.getLogger(getClass)

  @RequestMapping(value = Array("/","/login"),
    method = Array(RequestMethod.GET))
  def showLoginPage() : String = "login"

  @RequestMapping(value = Array("/login"),
    method = Array(RequestMethod.POST))
  def doLogin(@Validated loginInfo: LoginInfo,
              errors:Errors,
              model: Model): String = {
    if(errors.hasErrors) {
      errors.getFieldErrors.forEach { e =>
        logger.error(s"toString = ${e.toString}")
        logger.error(s"field = ${e.getField}")
        logger.error(s"defaultMsg = ${e.getDefaultMessage}")
        if(e.getField == "username")
          model.addAttribute("userError","length must be in 3 to 15")
        if(e.getField == "password")
          model.addAttribute("pswError","length must be in 6 to 20")
      }
      "redirect:login"
    }
    else{

      logger.info(s"username = ${loginInfo.username} " +
        s"${EncodingUtils.fromISO2UTF8(loginInfo.username)}")
      logger.info(s"password = ${loginInfo.password}")
      "index"
    }
  }

}
