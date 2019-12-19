package com.henry.fampresentation.hurtmeplenty.typehiercat

trait JsonEncoder[-T] {
  def encode(t: T): String
}
