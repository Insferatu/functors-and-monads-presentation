package com.henry.fampresentation

import com.henry.fampresentation.model.MyList.concat
import com.henry.fampresentation.model.{MyCons, MyList, MyNil}

object CheckMyListMonad {
  object MonadInstances {
    implicit val myListMonad = new Monad[MyList] {
      override def map[A, B](fa: MyList[A])(f: A => B): MyList[B] = fa match {
        case MyCons(h, t) => MyCons(f(h), map(t)(f))
        case MyNil => MyNil
      }

      override def pure[A](a: A): MyList[A] = MyCons(a, MyNil)

      override def flatMap[A, B](fa: MyList[A])(f: A => MyList[B]): MyList[B] = fa match {
        case MyCons(h, t) => concat(f(h), flatMap(t)(f))
        case MyNil => MyNil
      }
    }
  }

  def main(args: Array[String]): Unit = {
    import Monad._
    import MonadInstances._

    val l1: MyList[Int] = MyCons(5, MyCons(4, MyCons(3, MyNil)))
    val l2: MyList[String] = MyCons("hello", MyCons("darkness", MyCons("my old friend", MyNil)))
    val l3: MyList[Boolean] = MyCons(true, MyCons(false, MyCons(true, MyNil)))

    println(l1.flatMap(i => MyCons(i + 10, MyNil)))
    println(l2.flatMap(i => MyCons(i.reverse, MyNil)))
    println(l3.flatMap(i => MyCons(i && true, MyNil)))
  }
}
