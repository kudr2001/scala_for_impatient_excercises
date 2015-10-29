package classes5

/**
 * Created by andrey on 18.09.15.
 */
class Car(val manufacturer : String, val modelName : String) {

  private var modelYear : Int = -1
  private var licensePlate : String = ""

  def this(manufacturer : String, modelName : String, modelYear: Int) {
    this(manufacturer, modelName)
    this.modelYear = modelYear
  }

  def this(manufacturer : String, modelName : String, licensePlate: String) {
    this(manufacturer, modelName)
    this.licensePlate = licensePlate
  }

  def this(manufacturer : String, modelName : String, modelYear: Int, licensePlate: String) {
    this(manufacturer, modelName, modelYear)
    this.licensePlate = licensePlate
  }
}
