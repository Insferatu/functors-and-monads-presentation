package com.henry.fampresentation.bringiton

import com.henry.fampresentation.hurtmeplenty.model.{MyNone, MyOption, MySome}

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
    import FunctorInstances._

    val s1: MyOption[Int] = MySome(5)
    val s2: MyOption[String] = MySome("hello")
    val s3: MyOption[Boolean] = MyNone

    println(Functor[MyOption].map(s1)(_ + 10))
    println(Functor[MyOption].map(s2)(_.reverse))
    println(Functor[MyOption].map(s3)(_ && true))
  }
}
