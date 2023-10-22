package com.dlolhd.a30daysofwellness.model

import com.dlolhd.a30daysofwellness.R


interface WellnessRepository  {
    suspend fun getAllItems(): List<Curiosity>
}


class WellnessLocalRepository : WellnessRepository {
    override suspend fun getAllItems(): List<Curiosity> {
        return WellnessLocal.wellness
    }

}

object WellnessLocal {
    val wellness = listOf(
        Curiosity(
            day = R.string.day_one,
            title = R.string.alone_in_tokyo_1,
            imgRes = R.drawable.alone_in_tokyo_i,
            description = R.string.alone_in_tokyo_1_desc
        ),
        Curiosity(
            day = R.string.day_two,
            title = R.string.alone_in_tokyo_vii_2,
            imgRes = R.drawable.alone_in_tokyo_vii,
            description = R.string.alone_in_tokyo_vii_2_desc
        ),
        Curiosity(
            day = R.string.day_three,
            title = R.string.cliche_3,
            imgRes = R.drawable.cliche,
            description = R.string.cliche_3_desc
        ),
        Curiosity(
            day = R.string.day_four,
            title = R.string.defender_4,
            imgRes = R.drawable.defender,
            description = R.string.defender_4_desc
        ),
        Curiosity(
            day = R.string.day_five,
            title = R.string.dotonbori_5,
            imgRes = R.drawable.dotonbori,
            description = R.string.dotonbori_5_desc
        ),
        Curiosity(
            day = R.string.day_six,
            title = R.string.false_kiva_6,
            imgRes = R.drawable.false_kiva,
            description = R.string.false_kiva_6_desc
        ),
        Curiosity(
            day = R.string.day_seven,
            title = R.string.flame_nebula_7,
            imgRes = R.drawable.flame_nebula,
            description = R.string.flame_nebula_7_desc
        )
    )
}