package ch.keepcalm.demo.domain

import org.jmolecules.ddd.annotation.ValueObject
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@ValueObject
@JvmInline
value class Geburtsdatum(val value: LocalDate) {
    init {
        if (!isOfLegalAge()) throw GeburtsdatumNotLegalException(this)
    }

    private fun isOfLegalAge() = LocalDate.from(value).until(LocalDate.now(), ChronoUnit.YEARS) >= 18
}

