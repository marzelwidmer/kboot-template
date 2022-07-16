package ch.keepcalm.demo.infrastructure.persistence.mongodb.complaint

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Document
@TypeAlias("ComplaintQueryObject")
data class ComplaintQueryObject(

    @Id
    val id: String = UUID.randomUUID().toString(),

    @Indexed
    val company: String,

    val description: String
)
