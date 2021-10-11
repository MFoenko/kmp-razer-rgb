package ui.viewmodel

import data.NetworkResource
import data.lol.LolApi
import data.lol.model.RawPlayerInfo
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainViewModel(
    val scope: CoroutineScope
) {

    val latestPlayerInfo = MutableStateFlow<RawPlayerInfo?>(null)
    var listenPlayerInfoJob: Job? = null

    fun beginListenPlayerInfo() { //TODO find a better way to listen for a game to begin
        if(listenPlayerInfoJob != null) return //job is already running
        listenPlayerInfoJob = scope.launch {
            while (isActive) {
                val response = requestPlayerInfo().single()
                when (response) {
                    is NetworkResource.Failure -> {
                        delay(5000)
                    }
                    is NetworkResource.Success -> {
                        delay(100)
                    }
                }
            }
        }
    }

    fun cancelListenPlayerInfo(){
        listenPlayerInfoJob?.cancel()
    }


    fun requestPlayerInfo(): Flow<NetworkResource<RawPlayerInfo>>{
        val response = LolApi.getPlayerInfo()
        scope.launch {
            response.collect {
                if(it is NetworkResource.Success)
                    latestPlayerInfo.value = it.resource
            }
        }
        return response
    }

}