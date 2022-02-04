package `data-structure`.math

class Rational(private val n: Int, private val d: Int) {
    require(d != 0)

    val gcd: Int = Rational.gcd(n.abs, d.abs)
    val numerator = n / gcd * d.signum
    val denumerator = d.abs / gcd

    // Math operations on rational numbers
    def unary_- = Rational(-numerator, denumerator)
    def abs = Rational(numerator.abs, denumerator)
    def inverse = Rational(denumerator, numerator)
    def +(o: Rational) = {
        val lcd = Rational.lcd(denumerator, o.denumerator)
        Rational(numerator * (lcd / denumerator) + o.numerator * (lcd / o.denumerator), lcd)
    }
    def -(o: Rational) = this + (-o)
    def *(o: Rational) = Rational(numerator * o.numerator, denumerator * o.denumerator)
    def /(o: Rational) = this * (o.inverse)

    override def equals(other: Any) = other match {
        case o: Rational => numerator == o.numerator && denumerator == o.denumerator
        case x => false
    }
    override def toString = if(denumerator == 1) numerator.toString else s"$numerator / $denumerator"
}

object Rational {
    private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
    private def lcd(a: Int, b: Int): Int = a * b / gcd(a, b)
}
