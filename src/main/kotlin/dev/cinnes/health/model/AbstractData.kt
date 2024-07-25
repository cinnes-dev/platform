package dev.cinnes.health.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

enum class DataType {
    sodium,
    polyunsaturated_fat,
    monounsaturated_fat,
    protein,
    vitamin_c,
    potassium,
    total_fat,
    saturated_fat,
    carbohydrates,
    dietary_cholesterol,
    dietary_energy,
    sleep_analysis,
    calcium,
    iron,
    walking_speed,
    weight_body_mass,
    walking_asymmetry_percentage,
    walking_step_length,
    walking_double_support_percentage,
    flights_climbed,
    body_mass_index,
    fiber,
    height,
    // these produce alot of data entries
    step_count,
    walking_running_distance,
    active_energy
}

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "name"
)
@JsonSubTypes(
    JsonSubTypes.Type(name = "weight_body_mass", value = Weight::class)
)
abstract class AbstractData(val name: DataType)