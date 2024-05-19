package com.denisfominykh.messengeruser.sequence.repository

import com.denisfominykh.messengeruser.sequence.SequenceModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SequenceRepository: MongoRepository<SequenceModel, String> {
    fun findByName(name: String): SequenceModel?
}