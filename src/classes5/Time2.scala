package classes5

/**
  * Created by andrey on 18.09.15.
  */
class Time2(val hrs: Int, val min: Int) {

   if (hrs < 0 || hrs > 24)
     throw new IllegalArgumentException("Hour must be between 0 and 24")

   if (min < 0 || min > 59)
     throw new IllegalArgumentException("Minute must be between 0 and 24")

  private var minutes: Int = 0

  minutes = hrs*60 + min

   def before(other: Time2) : Boolean = {
     minutes < other.minutes
   }

 }
