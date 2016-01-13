
class CreditCard(var price: Int = 0) {
  def charge(p: Int): Int = {
    price = p
    price
  }
}

class Coffee(var price: Int = 0) {

}

class Payments(var price: Int = 0) {
  def charge(cc: CreditCard, p: Int): Int = {
    price = p
    price
  }
}

case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge =
    if(cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges to different cards")
}

class Cafe {
  // not good
//  def buyCoffee(cc: CreditCard): Coffee = {
//    val cup = new Coffee()
//    cc.charge(cup.price)
//    cup
//  }

  // better than before
  def buyCoffee(cc: CreditCard, p: Payments): Coffee = {
    val cup = new Coffee()
    p.charge(cc, cup.price)
    cup
  }

  // best case in 1.1 chapter
  def buyCoffee(cc:CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  }
  def buyCoffees(cc: CreditCard, n: Int) :(List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
  }

  def coalesce(charges: List[Charge]): List[Charge] =
  charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList
}


