package com.example.menupager.Res

//TODO
class Shoes(
    val name: String,
    var type: Int = 0,
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