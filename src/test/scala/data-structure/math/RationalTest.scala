package `data-structure`.math

import org.junit.Test
import org.junit.Assert.*

class RationalTest {
    @Test def constructor() = {
        assertEquals(Rational(2, 4), Rational(1, 2))
        assertEquals(Rational(-2, 4), Rational(-1, 2))
        assertEquals(Rational(2, -4), Rational(-1, 2))
    }

    @Test def unaryMinus() = {
        assertEquals(-Rational(1, 1), Rational(-1, 1))
        assertEquals(-Rational(1, 2), Rational(-1, 2))
        assertEquals(-Rational(5, 2), Rational(-5, 2))
        assertEquals(-Rational(5, 2), Rational(-5, 2))
        assertEquals(-Rational(0, 2), Rational(0, 2))
    }
}