package com.henry.fampresentation.hurtmeplenty

trait Monoid[T] {
  def combine(l: T, r: T): T

  def empty: T
}

object Monoid {
  implicit class MonoidOps[T: Monoid](l: T) {
    def |+|(r: T): T = Monoid[T].combine(l, r)
  }

  def apply[T: Monoid]: Monoid[T] = implicitly[Monoid[T]]
}
