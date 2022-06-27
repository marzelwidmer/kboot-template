package ch.keepcalm.demo.domain

import ch.keepcalm.demo.infrastructure.exception.BusinessException

class GeburtsdatumNotLegalException(birthday: Geburtsdatum) : BusinessException("Not legal age [${birthday.value}]")

