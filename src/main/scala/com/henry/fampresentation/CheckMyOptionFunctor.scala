package com.henry.fampresentation

import com.henry.fampresentation.model.{MyNone, MyOption, MySome}

object CheckMyOptionFunctor {
  object FunctorInstances {
    implicit val myOptionFunctor = new Functor[MyOption] {
      override def map[A, B](fa: MyOption[A])(f: A => B): MyOption[B] = fa match {
        case MySome(a) => MySome(f(a))
        case MyNone => MyNone
      }
    }
  }

  def main(args: Array[String]): Unit = {
    import Functor._
    import FunctorInstances._

    val s1: MyOption[Int] = MySome(5)
    val s2: MyOption[String] = MySome("hello")
    val s3: MyOption[Boolean] = MyNone

    println(s1.map(_ + 10))
    println(s2.map(_.reverse))
    println(s3.map(_ && true))
  }
}
