package com.henry.fampresentation

object CheckMonoid1 {
  def main(args: Array[String]): Unit = {
    import Monoid._
    import MonoidInstances._

    println("Hello," |+| " world!")
    println("Hello" |+| Monoid[String].empty)
    println(Monoid[String].empty |+| "Hello")

    println(3 |+| 5)
    println(3 |+| Monoid[Int].empty)
    println(Monoid[Int].empty |+| 3)
  }
}
