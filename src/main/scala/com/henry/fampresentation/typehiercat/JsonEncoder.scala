package com.henry.fampresentation.typehiercat

trait JsonEncoder[-T] {
  def encode(t: T): String
}
