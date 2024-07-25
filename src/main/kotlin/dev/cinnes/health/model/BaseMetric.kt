package dev.cinnes.health.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "name",
    defaultImpl = Void::class
)
@JsonSubTypes(
    JsonSubTypes.Type(name = Weight.TYPE_IDENTIFIER, value = Weight::class)
)
abstract class BaseMetric