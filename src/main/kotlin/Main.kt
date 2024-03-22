import com.thoughtworks.kotlin_assignment.service.InventoryService
import com.thoughtworks.kotlin_assignment.service.ProductService

suspend fun main() {

    println("-------------库存数据------------")
    // 发起 GET 请求获取库存列表
    val inventoryService = InventoryService()
    val allInventories = inventoryService.getAllInventories()

    println("-------------产品数据------------")
    // 发起 GET 请求获取产品列表
    val productService = ProductService()
    val allProducts = productService.getAllProducts()

    // 给每个产品设置内存
    val haveSetInventoryProducts = productService.setProductInventory(allInventories, allProducts)

    // 根据内存计算产品价格
    productService.setHighDemandProductsPrice(haveSetInventoryProducts)

    productService.display(haveSetInventoryProducts)
}

