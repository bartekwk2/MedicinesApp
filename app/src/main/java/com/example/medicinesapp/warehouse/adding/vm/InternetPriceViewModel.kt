package com.example.medicinesapp.warehouse.adding.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicinesapp.data.FromInternet
import com.example.medicinesapp.data.PillOrganizerDB
import com.example.medicinesapp.repository.AppRepository
import io.reactivex.Observable
import kotlinx.coroutines.launch

class InternetPriceViewModel (private val repository: AppRepository, private val app: Application): ViewModel(){


    fun getMedicine(name:String,id:String): Observable<FromInternet>? {
        return repository.getMedicine(name,id)
    }

    fun insertPillOrganizer(pillOrganizerDB: PillOrganizerDB){

        viewModelScope.launch {
            repository.insertPillOrganizer(pillOrganizerDB)
        }
    }

    fun convertFromInternetToPillOrganizer(fromInternet: FromInternet):PillOrganizerDB{

        var price = 0.0

        price = fromInternet.price!!.replace(",",".").split(" ").first().toDouble()


        val out = (price/fromInternet.count)
        val out2 = String.format("%.2f", out).replace(",",".").toDouble()

        return PillOrganizerDB(null,fromInternet.idPill,fromInternet.picture,out2,fromInternet.count.toDouble(),fromInternet.amount.toInt(),fromInternet.amount.toInt(),null,false,fromInternet.nameOfPill)
    }

}