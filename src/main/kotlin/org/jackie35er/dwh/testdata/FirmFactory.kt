package org.jackie35er.dwh.testdata

import org.jackie35er.dwh.domain.Firm

object FirmFactory {


    fun createFirms() : List<Firm> {

        return mutableListOf(
            Firm(0,"Firm 1"),
            Firm(0,"Firm 2"),
            Firm(0,"Firm 3"),
        )
    }
}