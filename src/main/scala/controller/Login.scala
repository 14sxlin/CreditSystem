package controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

import model.LoginInfo

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
              errors:Errors): String = {
    if(errors.hasErrors) {
      "login"
    }
    else{
      logger.info(s"username = ${loginInfo.username}")
      logger.info(s"password = ${loginInfo.password}")
      "index"
    }
  }

}
