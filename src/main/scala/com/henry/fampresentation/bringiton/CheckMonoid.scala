package com.henry.fampresentation.bringiton

object CheckMonoid {
  object MonoidInstances {
    implicit val stringMonoid: Monoid[String] = new Monoid[String] {
      override def combine(l: String, r: String): String = l.concat(r)

      override def empty: String = ""
    }

    implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
      override def combine(l: Int, r: Int): Int = l + r

      override def empty: Int = 0
    }
  }

  def main(args: Array[String]): Unit = {
    import MonoidInstances._

    println(Monoid[String].combine("Hello,", " world!"))
    println(Monoid[String].combine("Hello", Monoid[String].empty))
    println(Monoid[String].combine(Monoid[String].empty, "Hello"))

    println(Monoid[Int].combine(3, 5))
    println(Monoid[Int].combine(3, Monoid[Int].empty))
    println(Monoid[Int].combine(Monoid[Int].empty, 3))

    val strList = List("Foo-", "Bar-", "Boo-", "Bee-")
    println(collapse(strList))

    val intList = List(1, 2, 3, 4)
    println(collapse(intList))
  }

  def collapse[T](list: List[T])(implicit m: Monoid[T]): T = list.foldLeft(m.empty)(m.combine)
}
