package ch.keepcalm.demo.domain

import java.time.LocalDate
import java.time.temporal.ChronoUnit

@JvmInline
value class Geburtsdatum(val value: LocalDate) {
    init {
        if (!isOfLegalAge()) throw GeburtsdatumNotLegalException(this)
    }

    private fun isOfLegalAge() = LocalDate.from(value).until(LocalDate.now(), ChronoUnit.YEARS) >= 18
}

