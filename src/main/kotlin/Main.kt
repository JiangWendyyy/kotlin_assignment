import com.thoughtworks.kotlin_assignment.Entity.HighDemandProduct
import com.thoughtworks.kotlin_assignment.Entity.NormalProduct
import com.thoughtworks.kotlin_assignment.Entity.Product
import com.thoughtworks.kotlin_assignment.RetrofitClient
import com.thoughtworks.kotlin_assignment.service.ProductApi

suspend fun main() {

    val service = RetrofitClient.getInstance().create(ProductApi::class.java)

    // 发起 GET 请求获取产品列表
    val allProducts = service.getAllProducts()
    if(allProducts.isSuccessful) {
        var body = allProducts.body()
        if (!body.isNullOrEmpty()) {
            val highDemandProducts = body.filter { it.type == "HIGH_DEMAND" }.map { HighDemandProduct(it.id,it.SKU,it.name,it.price,it.type,it.image)}
            val normalProduct = body.filter { it.type == "NORMAL" }.map { NormalProduct(it.id,it.SKU,it.name,it.price,it.type,it.image) }
            highDemandProducts.forEach { it.calculatePrice() }
            display(highDemandProducts)
            display(normalProduct)
        }
    }else{
        println("Error")
    }
}

private fun display(products: List<Product>) {
    for (product in products) {
        println(product.displayProductDetails())
    }
}

