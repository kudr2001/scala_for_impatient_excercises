package classes5

/**
 * Created by andrey on 18.09.15.
 */
class Time(val hrs: Int, val min: Int) {

  if (hrs < 0 || hrs > 24)
    throw new IllegalArgumentException("Hour must be between 0 and 24")

  if (min < 0 || min > 59)
    throw new IllegalArgumentException("Minute must be between 0 and 24")

  def before(other: Time) : Boolean = {
    if (hrs == other.hrs)
      min < other.min
    else
      hrs < other.hrs
  }

}
