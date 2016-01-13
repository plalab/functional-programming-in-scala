
/**
  * Created by pLacebo on 2016. 1. 13..
  */

object MyModule {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)
    go(n, 1)
  }

  def factorial_of_me(n: Int): Int =
    if (n <= 1) n
    else n * factorial_of_me(n - 1)

  // 연습문제 2.1 - 27p
  def fib(n: Int): Int = {
    // TODO 코드 작성 필요
    0
  }

  def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d."
    msg.format(n, factorial(n))
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  // not generic function
  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec def loop(n: Int): Int =
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)

    loop(0)
  }

  // generic function
  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec def loop(n: Int): Int =
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)

    loop(0)
  }

  // 연습문제 2.2 - p31
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec def loop(n: Int): Boolean =
      if (n >= as.length) true
      else if (ordered(as(n), as(n + 1))) loop(n + 1)
      else false

    loop(0)
  }

  def partial1[A,B,C](a: A, f: (A, B) => C): B => C =
    (b: B) => f(a, b)


  // 연습문제 2.3 - 34p
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    (a: A) => (b : B) => f(a, b)


  // 연습문제 2.4 - 35p
  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  // 연습문제 2.5 - 35p
  def compose[A,B,C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))

    println(factorial(7))
    println(factorial_of_me(7))
    println(formatResult("absolute value", -4, abs))
    println(formatResult("factorial", 7, factorial))

    println(findFirst(Array(7, 9, 13), (x: Int) => x == 9))

    println(partial1(10, (a :Int, b: String) => a + b)(" Hello"))

    // TODO curry, uncurry 출력 작성
    // TODO compose 출력 작성
  }

}

