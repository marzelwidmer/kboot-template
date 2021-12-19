package ch.keepcalm.demo.domain

class GeburtsdatumNotLegalException(birthday: Geburtsdatum) : RuntimeException("Not legal age [${birthday.value}]")
