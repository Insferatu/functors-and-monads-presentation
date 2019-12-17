package com.henry.fampresentation.model

sealed trait MyList[+T]
case class MyCons[T](h: T, t: MyList[T]) extends MyList[T]
case object MyNil extends MyList[Nothing]
