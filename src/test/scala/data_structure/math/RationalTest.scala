package `data-structure`.math

import org.junit.Test
import org.junit.Assert.*

class RationalTest {
    @Test def constructor = {
        assertEquals(Rational(1, 2), Rational(2, 4))
        assertEquals(Rational(-1, 2), Rational(-2, 4))
        assertEquals(Rational(-1, 2), Rational(2, -4))
        assertEquals(Rational(-1, 2), Rational(2, -4))
    }

    @Test def unaryMinus = {
        assertEquals(Rational(-1, 1), -Rational(1, 1))
        assertEquals(Rational(-1, 2), -Rational(1, 2))
        assertEquals(Rational(-5, 2), -Rational(5, 2))
        assertEquals(Rational(-5, 2), -Rational(5, 2))
        assertEquals(Rational(0, 2), -Rational(0, 2))
    }

    @Test def abs = {
        assertEquals(Rational(1, 2), Rational(1, 2).abs)
        assertEquals(Rational(1, 2), Rational(-1, 2).abs)
        assertEquals(Rational(1, 2), Rational(1, -2).abs)
        assertEquals(Rational(1, 2), Rational(-1, -2).abs)
    }
    
    @Test def inverse = {
        assertEquals(Rational(2, 1), Rational(1, 2).inverse)
        assertEquals(Rational(1, 2), Rational(2, 1).inverse)
        assertEquals(Rational(-2, 1), Rational(-1, 2).inverse)
    }

    @Test def plus = {
        assertEquals(Rational(2, 3), Rational(1, 3) + Rational(1, 3))
        assertEquals(Rational(3, 4), Rational(1, 4) + Rational(2, 4))
        assertEquals(Rational(1, 2), Rational(1, 4) + Rational(1, 4))
        assertEquals(Rational(1, 1), Rational(1, 2) + Rational(1, 2))
        assertEquals(Rational(0, 1), Rational(1, 2) + Rational(-1, 2))
        assertEquals(Rational(-1, 1), Rational(-1, 2) + Rational(-1, 2))
    }

    @Test def conversionIntToRational = {
        assertEquals(Rational(0, 1), Rational.intToRational(0))
        assertEquals(Rational(1, 1), Rational.intToRational(1))
        assertEquals(Rational(5, 1), Rational.intToRational(5))
        assertEquals(Rational(1234, 1), Rational.intToRational(1234))
    }

    @Test def conversionRationalToDouble = {
        assertEquals(1, Rational.rationalToDouble(Rational(1, 1)), 0.01)
        assertEquals(0.5, Rational.rationalToDouble(Rational(1, 2)), 0.01)
        assertEquals(0.25, Rational.rationalToDouble(Rational(1, 4)), 0.01)
        assertEquals(0.33, Rational.rationalToDouble(Rational(1, 3)), 0.01)
    }

    @Test def intPlus = {
        assertEquals(Rational(3, 2), Rational(1, 2) + 1)
        assertEquals(Rational(5, 2), Rational(1, 2) + 2)
        assertEquals(Rational(21, 2), Rational(1, 2) + 10)
    }
}