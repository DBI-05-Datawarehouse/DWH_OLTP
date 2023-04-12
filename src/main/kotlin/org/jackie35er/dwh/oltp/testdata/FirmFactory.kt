package org.jackie35er.dwh.oltp.testdata

import org.jackie35er.dwh.oltp.domain.Firm

object FirmFactory {


    fun createFirms() : List<org.jackie35er.dwh.oltp.domain.Firm> {

        return mutableListOf(
            org.jackie35er.dwh.oltp.domain.Firm(0, "Firm 1"),
            org.jackie35er.dwh.oltp.domain.Firm(0, "Firm 2"),
            org.jackie35er.dwh.oltp.domain.Firm(0, "Firm 3"),
        )
    }
}