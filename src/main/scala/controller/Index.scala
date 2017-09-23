package controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.SessionAttribute

/**
  * Created by linsixin on 2017/9/23.
  */
@Controller
@SessionAttribute("user")
class Index {
  private val logger = LoggerFactory.getLogger(getClass)


}
