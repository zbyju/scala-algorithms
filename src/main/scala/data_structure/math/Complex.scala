package `data-structure`.math.complex

import scala.math.sqrt

class Complex(val real: Double, val imaginary: Double) {
    val re = real
    val im = imaginary


    //Math operations on rational numbers
    def unary_- = Complex(-re, -im)
    def conjugate = Complex(re, -im)
    def abs2 = (re * re + im * im)
    def abs = sqrt(abs2)
    def inverse = Complex(re / abs2, -im / abs2)

    def +(o: Complex) = Complex(re + o.re, im + o.im)
    def -(o: Complex) = this + (-o)
    def *(o: Complex) = Complex(re * o.re - im * o.im, o.re * im + re * o.im)
    def /(o: Complex) = this * (o.inverse)

    override def equals(o: Any): Boolean = o match {
        case o: Complex => re == o.re && im == o.im
        case o: Int => im == 0 && re == o.toDouble
        case o: Double => im == 0 && re == o
        case o => false
    }

    override def toString: String = {
        if(re == 0 && im == 0) return "0"
        if(re == 0) return s"${im}i"
        if(im == 0) return re.toString
        s"$re + ${im}i"
    }
}