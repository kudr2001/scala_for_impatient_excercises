package inheritance8

/**
 * Created by andrey on 24.09.15.
 */
class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret" // Don't want to reveal name . . .
  override val toString = "secret" // . . . or class name
}

