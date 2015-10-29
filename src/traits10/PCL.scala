package traits10

object PCL extends java.beans.PropertyChangeListener {

  override def propertyChange(pce:java.beans.PropertyChangeEvent) : Unit = {
    System.out.println("Bean changed its " + pce.getPropertyName +
      " from " + pce.getOldValue +
      " to " + pce.getNewValue)
  }

}