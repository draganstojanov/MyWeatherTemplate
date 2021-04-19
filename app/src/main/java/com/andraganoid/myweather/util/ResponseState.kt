package com.andraganoid.myweather.util

import com.andraganoid.myweather.model.AstronomyResponse
import com.andraganoid.myweather.model.CurrentResponse
import com.andraganoid.myweather.model.ForecastResponse

sealed class ResponseState {
    data class Loading(val loaderMsg: String) : ResponseState()
    data class Error(val errorMsg: String) : ResponseState()
    data class CurrentWeather(val currentResponse: CurrentResponse?) : ResponseState()
    data class AstroData(val astronomyResponse: AstronomyResponse?) : ResponseState()
    data class ForecastData(val forecastResponse: ForecastResponse?) : ResponseState()
}