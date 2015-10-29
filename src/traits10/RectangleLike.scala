package traits10

/**
 * Created by andrey on 05.10.15.
 */
trait RectangleLike {
  
  protected def setFrame(x: Double, y: Double, w: Double, h: Double)

  protected def getX : Double

  protected def getY : Double

  protected def getWidth: Double

  protected def getHeight: Double
  
  def translate(dx: Int, dy: Int) = {
    val oldw: Double = this.getX
    var neww: Double = oldw + dx
    val oldv: Double = this.getY
    var newv: Double = oldv + dy

    var width: Double = this.getWidth
    var height: Double = this.getHeight

    if (dx < 0) {
      if (neww > oldw) {
        if (width >= 0) {
          width += neww - Double.MinValue
        }
        neww = Double.MinValue
      }
    }
    else {
      if (neww < oldw) {
        if (width >= 0) {
          width += neww - Double.MaxValue
          if (width < 0) width = Double.MaxValue
        }
        neww = Double.MaxValue
      }
    }

    if (dy < 0) {
      if (newv > oldv) {
        if (height >= 0) {
          height += newv - Double.MinValue
        }
        newv = Double.MinValue
      }
    }
    else {
      if (newv < oldv) {
        if (height >= 0) {
          height += newv - Double.MaxValue
          if (height < 0) height = Double.MaxValue
        }
        newv = Double.MaxValue
      }
    }

    this.setFrame(neww, newv, width, height)
  }

  def grow(h: Int, v: Int) = {
    var x0: Double = this.getX
    var y0: Double = this.getY
    var x1: Double = this.getWidth
    var y1: Double = this.getHeight
    x1 += x0
    y1 += y0

    x0 -= h
    y0 -= v
    x1 += h
    y1 += v

    if (x1 < x0) {
      x1 -= x0
      if (x1 < Double.MinValue) x1 = Double.MinValue
      if (x0 < Double.MinValue) x0 = Double.MinValue
      else if (x0 > Double.MaxValue) x0 = Double.MaxValue
    }
    else {
      if (x0 < Double.MinValue) x0 = Double.MinValue
      else if (x0 > Double.MaxValue) x0 = Double.MaxValue
      x1 -= x0
      if (x1 < Double.MinValue) x1 = Double.MinValue
      else if (x1 > Double.MaxValue) x1 = Double.MaxValue
    }

    if (y1 < y0) {
      y1 -= y0
      if (y1 < Double.MinValue) y1 = Double.MinValue
      if (y0 < Double.MinValue) y0 = Double.MinValue
      else if (y0 > Double.MaxValue) y0 = Double.MaxValue
    }
    else {
      if (y0 < Double.MinValue) y0 = Double.MinValue
      else if (y0 > Double.MaxValue) y0 = Double.MaxValue
      y1 -= y0
      if (y1 < Double.MinValue) y1 = Double.MinValue
      else if (y1 > Double.MaxValue) y1 = Double.MaxValue
    }

    this.setFrame(x0.toInt, y0.toInt, x1.toInt, y1.toInt)
    
  }

}
