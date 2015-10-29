package classes5

import scala.beans.BeanProperty

/**
 * Created by andrey on 18.09.15.
 */
class Student(@BeanProperty var name: String, @BeanProperty var id: Int) {

}
