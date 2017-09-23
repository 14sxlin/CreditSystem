package spring

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.{SqlSession, SqlSessionFactoryBuilder}
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component


/**
  * Created by linsixin on 2017/9/23.
  */
@Component
class BeansConfig {

  @Bean
  def getSqlSession:SqlSession = {
    val in = Resources.getResourceAsReader("Configuration.xml")
    assert(in != null)
    val sqlFac = new SqlSessionFactoryBuilder().build(in)
    in.close()
    sqlFac.openSession()
  }
}
