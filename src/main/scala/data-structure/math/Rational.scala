package `data-structure`.math

class Rational(val n: Int, val d: Int) {
    require(d != 0)

    val gcd: Int = Rational.gcd(n.abs, d.abs)
    val numerator = n / gcd * d.signum
    val denumerator = d.abs / gcd

    def unary_- = Rational(-numerator, denumerator)

    override def equals(other: Any) = other match {
        case o: Rational => numerator == o.numerator && denumerator == o.denumerator
        case x => false
    }
    override def toString = s"$numerator/$denumerator"
}

object Rational {
    private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
}
