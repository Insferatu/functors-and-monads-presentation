package com.henry.fampresentation.bringiton

import com.henry.fampresentation.hurtmeplenty.model.{MyNone, MyOption, MySome}

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
    import MonadInstances._

    val s1: MyOption[Int] = Monad[MyOption].pure(5)
    val s2: MyOption[String] = Monad[MyOption].pure("hello")
    val s3: MyOption[Boolean] = MyNone

    println(Monad[MyOption].flatMap(s1)(i => MySome(i + 10)))
    println(Monad[MyOption].flatMap(s2)(i => MySome(i.reverse)))
    println(Monad[MyOption].flatMap(s3)(i => MySome(i && true)))
  }
}
