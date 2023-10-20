package com.dlolhd.a30daysofwellness.model


interface WellnessRepository  {
    suspend fun getAllItems(): List<Curiosity>
}


class WellnessLocalRepository : WellnessRepository {
    override suspend fun getAllItems(): List<Curiosity> {
        // FIXME: You will have to return a list of curiosities.
        return listOf()
    }

}