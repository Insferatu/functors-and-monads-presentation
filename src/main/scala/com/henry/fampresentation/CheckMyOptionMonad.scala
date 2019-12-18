package com.henry.fampresentation

import com.henry.fampresentation.model.{MyNone, MyOption, MySome}

object CheckMyOptionMonad {
  object MonadInstances {
    implicit val myOptionMonad = new Monad[MyOption] {
      override def map[A, B](fa: MyOption[A])(f: A => B): MyOption[B] = fa match {
        case MySome(a) => MySome(f(a))
        case MyNone => MyNone
      }

      override def pure[A](a: A): MyOption[A] = MySome(a)

      override def flatMap[A, B](fa: MyOption[A])(f: A => MyOption[B]): MyOption[B] = fa match {
        case MySome(a) => f(a)
        case MyNone => MyNone
      }
    }
  }
  def main(args: Array[String]): Unit = {
    import Monad._
    import MonadInstances._

    val s1: MyOption[Int] = Monad[MyOption].pure(5)
    val s2: MyOption[String] = Monad[MyOption].pure("hello")
    val s3: MyOption[Boolean] = MyNone

    println(s1.flatMap(i => MySome(i + 10)))
    println(s2.flatMap(i => MySome(i.reverse)))
    println(s3.flatMap(i => MySome(i && true)))
  }
}
