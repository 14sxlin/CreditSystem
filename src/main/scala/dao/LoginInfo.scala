package dao

import javax.validation.constraints.{NotNull, Size}

import scala.beans.BeanProperty

/**
  * Created by linsixin on 2017/9/22.
  */
class LoginInfo {

  @NotNull
  @Size(min=3,max = 15)
  @BeanProperty var userId : String = ""
  @NotNull
  @Size(min=6,max = 20)
  @BeanProperty var password :String = ""
}
