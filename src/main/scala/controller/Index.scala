package controller

import javax.servlet.http.HttpSession

import bean.Student
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
  * Created by linsixin on 2017/9/23.
  */
@Controller
@RequestMapping(Array("/index"))
class Index {
  private val logger = LoggerFactory.getLogger(getClass)

  @RequestMapping
  def getPageValidate(session:HttpSession) : String = {
    val user = session.getAttribute("user").asInstanceOf[Student]
    if( user!= null) {
      logger.info("has user and id map")
      "index"
    } else {
      logger.info("no user or id not map, go to login page")
      "redirect:login"
    }
  }


//  @RequestMapping(value = Array("/{userId}"))
//  def getWithUserId(@PathVariable
//                    userId:String,
//                    session:HttpSession) : String = {
//    logger.info(s"userId: $userId")
//    val user = session.getAttribute("user").asInstanceOf[Student]
//    if( user!= null) {
//      logger.info("has user and id map")
//      "index"
//    } else {
//      logger.info("no user or id not map, go to login page")
//      "redirect:"
//    }
//  }

}
