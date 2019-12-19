package com.henry.fampresentation.hurtmeplenty.model

sealed trait MyOption[+T]
case class MySome[T](t: T) extends MyOption[T]
case object MyNone extends MyOption[Nothing]
