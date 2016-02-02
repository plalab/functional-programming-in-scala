/**
  * Created by pLacebo on 2016. 1. 19..
  */

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  // 연습문제 3.2 - 45p
  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(x, xs) => xs
    // prefer case Cons(_, xs) => xs
  }

  // 연습문제 3.2 - 45p
  def setHead[A](a: A, as: List[A]): List[A] = as match {
    case Nil => Cons(a, Nil)
    case Cons(_, xs) => Cons(a, as)
    // prefer case Cons(_, xs) => xs
  }

  // 연습문제 3.4 - 46p
  def drop[A](l: List[A], n: Int): List[A] = {
    if (n <= 0) l
    else l match {
      case Nil => Nil
      case Cons(_, xs) => drop(xs, n - 1)
    }
  }

  // 연습문제 3.5 - 46p
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(x, xs) if f(x) => dropWhile(xs, f)
    case _ => l
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)(_ + _)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _)
}

// def dropWhile[A](l: List[A], f: A => Boolean): List[A]

object Runner {
  def main(args: Array[String]): Unit = {
    // 연습문제 3.1 - 43p
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + List.sum(t)
      case _ => 101
    }
    def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = as match {
      case Cons(h, t) if f(h) => dropWhile(t)(f)
      case _ => as
    }
    println(x)

    val xs: List[Int] = List(1, 2, 3, 4, 5)
    //    val ex1 = dropWhile(xs, (x:Int) => x < 4 )
    val ex1 = dropWhile(xs)(_ < 4)
    println(ex1)

    println(List.tail(xs))

    println(List.setHead(9, xs))

    println(List.drop(xs, 3))

    println(List.dropWhile(xs, (x: Int) => x > 4))

    val l :List[Double] = List(1, 2, 3, 0.0, 4 ,5)
    println(l)
    println(List.product2(l))
    println(List.foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_)))
  }
}