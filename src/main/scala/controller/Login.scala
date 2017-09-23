package controller

import javax.servlet.http.HttpSession

import dao.{LoginInfo, StudentDAO}
import org.apache.ibatis.session.SqlSession
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import scala.util.{Failure, Success, Try}

/**
  * Created by linsixin on 2017/9/21.
  */
@Controller
class Login {

  private val logger = LoggerFactory.getLogger(getClass)

  @Autowired
  var sqlSession : SqlSession = _

  @RequestMapping(value = Array("","login"),
    method = Array(RequestMethod.GET))
  def showLoginPage() : String = "login"

  @RequestMapping(value = Array("login"),
    method = Array(RequestMethod.POST))
  def doLoginAndGo(@Validated
                   loginInfo: LoginInfo,
                   errors:Errors,
                   model: RedirectAttributes,
                   session:HttpSession): String = {
    if(errors.hasErrors) {
      checkErrorAndPutInfo(errors,model)
      "redirect:login"
    }
    else{
      tryParseUserId(loginInfo.userId) match {
        case Success(userId) =>
          validateUserAndGo(userId,loginInfo.password,model,session)
        case Failure(exception) =>
          logger.error("",exception)
          putNameOrPasswordErrorAndGo(model)
      }
    }
  }

  private def checkErrorAndPutInfo(errors: Errors,model: RedirectAttributes): Unit ={
    errors.getFieldErrors.forEach { e =>
      logger.error(s"field = ${e.getField}")
      logger.error(s"defaultMsg = ${e.getDefaultMessage}")
      if(e.getField == "userId")
        model.addAttribute("userError","userId length must be in 3 to 15")
      if(e.getField == "password")
        model.addAttribute("pswError","password length must be in 6 to 20")
    }
  }

  private def tryParseUserId(strId:String) :Try[Int] = Try{
    strId.toInt
  }

  private def queryUser(userId:Int,password:String) = {
    val userDao = sqlSession.getMapper(classOf[StudentDAO])
    val user = userDao.selectById(userId)
    Option(user)
  }

  private def validateUserAndGo(userId:Int,psw:String,model: RedirectAttributes,session: HttpSession):String = {
    queryUser(userId,psw) match {
      case Some(user) =>
        if(userId == user.getId && psw == user.getPassword){
          logger.info(s"login success : $userId")
          session.setAttribute("user",user)
          "redirect:index"
        }else putNameOrPasswordErrorAndGo(model)
      case None => putNameOrPasswordErrorAndGo(model)

    }
  }

  private def putNameOrPasswordErrorAndGo(model: RedirectAttributes) = {
    model.addAttribute("pswError","name or password error")
    "redirect:login"
  }

}
