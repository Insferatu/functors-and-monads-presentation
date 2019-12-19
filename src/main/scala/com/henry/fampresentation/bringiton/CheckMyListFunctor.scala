package com.henry.fampresentation.bringiton

import com.henry.fampresentation.hurtmeplenty.model.{MyCons, MyList, MyNil}

object CheckMyListFunctor {
  object FunctorInstances {
    implicit val myListFunctor = new Functor[MyList] {
      override def map[A, B](fa: MyList[A])(f: A => B): MyList[B] = fa match {
        case MyCons(h, t) => MyCons(f(h), map(t)(f))
        case MyNil => MyNil
      }
    }
  }

  def main(args: Array[String]): Unit = {
    import FunctorInstances._

    val l1: MyList[Int] = MyCons(5, MyCons(4, MyCons(3, MyNil)))
    val l2: MyList[String] = MyCons("hello", MyCons("darkness", MyCons("my old friend", MyNil)))
    val l3: MyList[Boolean] = MyCons(true, MyCons(false, MyCons(true, MyNil)))

    println(Functor[MyList].map(l1)(_ + 10))
    println(Functor[MyList].map(l2)(_.reverse))
    println(Functor[MyList].map(l3)(_ && true))
  }
}
