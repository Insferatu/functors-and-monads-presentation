package com.henry.fampresentation.model

sealed trait MyList[+T]
case class MyCons[T](h: T, t: MyList[T]) extends MyList[T]
case object MyNil extends MyList[Nothing]

object MyList {
  def concat[T](l: MyList[T], r: MyList[T]): MyList[T] = {
    l match {
      case MyCons(h, t) => MyCons(h, concat(t, r))
      case MyNil => r
    }
  }
}