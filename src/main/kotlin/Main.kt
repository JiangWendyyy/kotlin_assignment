import com.thoughtworks.kotlin_assignment.RetrofitClient
import com.thoughtworks.kotlin_assignment.service.ProductApi

suspend fun main() {

    val service = RetrofitClient.getInstance().create(ProductApi::class.java)

    // 发起 GET 请求获取产品列表
    val allProducts = service.getAllProducts()
    if(allProducts.isSuccessful) {
        var body = allProducts.body()
        if (body != null) {
            println(body.get(0).id)
        }
    }else{
        println("Error")
    }
}

