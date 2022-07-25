package com.example.menupager.Res

data class Shoes(
    var name: String,
    var type: Int = 0,
    var price: String,
    var image: String
) {
    init {
        price += " AMD"
    }
}