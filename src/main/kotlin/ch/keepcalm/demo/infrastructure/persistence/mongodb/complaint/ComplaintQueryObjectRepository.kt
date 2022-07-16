package ch.keepcalm.demo.infrastructure.persistence.mongodb.complaint

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface  ComplaintQueryObjectRepository : ReactiveMongoRepository<ComplaintQueryObject, String>
