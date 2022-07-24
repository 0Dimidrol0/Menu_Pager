package com.example.menupager.Res

class Shoes(
    val name: String,
    setPrice: Int,
    setImage: Images
) {
    var price: String
    var image: String

    init {
        price = "$setPrice AMD"
        image = setImage.image
    }
}