package dev.cinnes.health.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import dev.cinnes.health.model.exercise.FlightsClimbed
import dev.cinnes.health.model.nutrition.*
import dev.cinnes.health.model.physical.BodyMassIndex
import dev.cinnes.health.model.physical.Weight

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "name",
    defaultImpl = Void::class
)
@JsonSubTypes(
    // physical
    JsonSubTypes.Type(name = Weight.TYPE_IDENTIFIER, value = Weight::class),
    JsonSubTypes.Type(name = BodyMassIndex.TYPE_IDENTIFIER, value = BodyMassIndex::class),

    // nutrition
    JsonSubTypes.Type(name = Calcium.TYPE_IDENTIFIER, value = Calcium::class),
    JsonSubTypes.Type(name = Carbohydrates.TYPE_IDENTIFIER, value = Carbohydrates::class),
    JsonSubTypes.Type(name = DietaryCholesterol.TYPE_IDENTIFIER, value = DietaryCholesterol::class),
    JsonSubTypes.Type(name = DietaryEnergy.TYPE_IDENTIFIER, value = DietaryEnergy::class),
    JsonSubTypes.Type(name = DietarySugar.TYPE_IDENTIFIER, value = DietarySugar::class),
    JsonSubTypes.Type(name = Fiber.TYPE_IDENTIFIER, value = Fiber::class),
    JsonSubTypes.Type(name = Iron.TYPE_IDENTIFIER, value = Iron::class),
    JsonSubTypes.Type(name = MonounsaturatedFat.TYPE_IDENTIFIER, value = MonounsaturatedFat::class),
    JsonSubTypes.Type(name = PolyunsaturatedFat.TYPE_IDENTIFIER, value = PolyunsaturatedFat::class),
    JsonSubTypes.Type(name = SaturatedFat.TYPE_IDENTIFIER, value = SaturatedFat::class),
    JsonSubTypes.Type(name = TotalFat.TYPE_IDENTIFIER, value = TotalFat::class),
    JsonSubTypes.Type(name = Potassium.TYPE_IDENTIFIER, value = Potassium::class),
    JsonSubTypes.Type(name = Protein.TYPE_IDENTIFIER, value = Protein::class),
    JsonSubTypes.Type(name = Sodium.TYPE_IDENTIFIER, value = Sodium::class),
    JsonSubTypes.Type(name = VitaminC.TYPE_IDENTIFIER, value = VitaminC::class),

    // exercise
    JsonSubTypes.Type(name = FlightsClimbed.TYPE_IDENTIFIER, value = FlightsClimbed::class),
)
abstract class BaseMetric(open val data: Set<MetricReading>) {
    abstract fun typeIdentifier(): String
}