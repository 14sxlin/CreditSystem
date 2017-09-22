package utils

/**
  * Created by linsixin on 2017/9/22.
  */
object EncodingUtils {

  def fromISO2UTF8(data:String):String = {
    new String(data.getBytes("ISO-8859-1"),"utf8")
  }
}
