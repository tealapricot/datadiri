package com.example.datadiri.data

import com.example.datadiri.R
import com.example.datadiri.model.Datadiri


class Datasource() {
    fun Loaddatadiri(): List<Datadiri> {
        return listOf<Datadiri>(
            Datadiri(R.string.name, R.drawable.image1),
            Datadiri(R.string.nim, R.drawable.image2),
            Datadiri(R.string.address, R.drawable.image3))

    }
}
