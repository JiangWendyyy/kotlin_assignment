import com.thoughtworks.kotlin_assignment.Entity.DataProduct
import com.thoughtworks.kotlin_assignment.Entity.HighDemandProduct
import com.thoughtworks.kotlin_assignment.Entity.NormalProduct
import com.thoughtworks.kotlin_assignment.Entity.Product
import com.thoughtworks.kotlin_assignment.RetrofitClient
import com.thoughtworks.kotlin_assignment.service.ProductApi

suspend fun main() {

    val service = RetrofitClient.getInstance().create(ProductApi::class.java)

    // 发起 GET 请求获取产品列表
    val allDataProducts = service.getAllProducts()
    if (service.getAllProducts().isSuccessful) {
        val body = allDataProducts.body()
        if (!body.isNullOrEmpty()) {
            val products = convertToProduct(body)
            val highDemandProducts = products.filterIsInstance<HighDemandProduct>()
            highDemandProducts.forEach {
                val calculatePrice = it.calculatePrice()
                it.setCalculatedPrice(calculatePrice)
            }
            display(products)
        }
    } else {
        println("Error")
    }
}

fun convertToProduct(dataProduct: List<DataProduct>): List<Product> {
    return dataProduct.map {
        val product = when (it.type) {
            "NORMAL" -> NormalProduct(
                id = it.id, SKU = it.SKU, name = it.name, price = it.price, image = it.image, type = "NORMAL"
            )

            "HIGH_DEMAND" -> HighDemandProduct(
                id = it.id, SKU = it.SKU, name = it.name, price = it.price, image = it.image, type = "HIGH_DEMAND"
            )

            else -> Product(
                id = it.id, SKU = it.SKU, name = it.name, price = it.price, image = it.image, type = it.type
            )
        }
        product
    }.toList()
}


fun display(products: List<Product>) {
    for (product in products) {
        println(product.displayProductDetails())
    }
}

