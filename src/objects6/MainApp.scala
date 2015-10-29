package objects6



/**
 * Created by andrey on 21.09.15.
 */
object MainApp extends App {

  println(args.reverse.mkString(" "))
  printf("2 gallons is %f liters.\n", Conversions.gallonsToLiters(2))
  printf("2 inches is %f cm.\n", Conversions.inchesToCentimeters(2))
  printf("2 miles is %f km.\n", Conversions.milesToKilometers(2))

  printf("2 inches is %f cm.\n", InchesToCentimeters.convert(2))

  printf("Point.x = %d; y=%d", Point.apply(3,4).x, Point.apply(3,4).y)

  for (h <- CardSuits.values) {
    println(h.toString + "; isRed=" + CardSuits.isRed(h))
  }

  for (h <- RgbCube.values) {
    println(h.toString + "; color=" + h.id)  }


  //println("" + CardSuits.Hearts.id + "; " + CardSuits.Hearts + "; " + CardSuits.withName("Hearts sign"))
}
