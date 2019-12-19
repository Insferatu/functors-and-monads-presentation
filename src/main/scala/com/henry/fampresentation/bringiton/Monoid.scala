package com.henry.fampresentation.bringiton

trait Monoid[T] {
  def combine(l: T, r: T): T

  def empty: T
}

object Monoid {
  def apply[T](implicit m: Monoid[T]): Monoid[T] = m
}