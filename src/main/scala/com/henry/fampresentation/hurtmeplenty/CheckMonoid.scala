package com.henry.fampresentation.hurtmeplenty

object CheckMonoid {
  object MonoidInstances {
    implicit val stringMonoid: Monoid[String] = new Monoid[String] {
      override def append(l: String, r: String): String = l.concat(r)

      override def empty: String = ""
    }

    implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
      override def append(l: Int, r: Int): Int = l + r

      override def empty: Int = 0
    }
  }

  def main(args: Array[String]): Unit = {
    import Monoid._
    import MonoidInstances._

    println("Hello," |+| " world!")
    println("Hello" |+| Monoid[String].empty)
    println(Monoid[String].empty |+| "Hello")

    println(3 |+| 5)
    println(3 |+| Monoid[Int].empty)
    println(Monoid[Int].empty |+| 3)

    val strList = List("Foo-", "Bar-", "Boo-", "Bee-")
    println(collapse(strList))

    val intList = List(1, 2, 3, 4)
    println(collapse(intList))
  }

  def collapse[T: Monoid](list: List[T]): T = list.foldLeft(Monoid[T].empty)(Monoid[T].append)
}
