package com.denisfominykh.messengeruser.sequence

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("sequence")
class SequenceModel(
    @Id
    val name: String,
    val lastValue: Long,
)