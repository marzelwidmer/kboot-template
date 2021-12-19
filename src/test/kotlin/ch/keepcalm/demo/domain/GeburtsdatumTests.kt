package ch.keepcalm.demo.domain

import org.amshove.kluent.`should not be`
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

internal class GeburtsdatumTests {

    @Test
    fun `Should create Geburtsdatum with valid values`() {
        val validBirthday = LocalDate.of(1975, 9, 27)
        val birthday = Geburtsdatum(validBirthday)
        birthday `should not be` null
    }

    @Test
    fun `Age should be legal age`() {
        val legalAge = LocalDate.now().minusYears(18)
        assertThatCode { Geburtsdatum(legalAge) }.doesNotThrowAnyException()
    }

    @Test
    fun `Should throw GeburtsdatumNotLegalException for an age who are not in a legal age`() {
        val inValidBirthday = LocalDate.now().minusYears(17)
        assertThrows<GeburtsdatumNotLegalException> {
            Geburtsdatum(inValidBirthday)
        }
    }
}
