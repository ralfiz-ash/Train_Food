package com.example.train_food.adapters

data class TrainModel(
    var id: String? = null,
    var number: String? = null,
    var name: String? = null,
    var startPoint: String? = null,
    var endPoint: String? = null,
)

data class FoodModel(
    var foodId: String? = null,
    var name: String? = null,
    var price: String? = null,
    var imageUrl: String? = null,
    var adminFlag: Boolean? = null
)

data class StopModel(
    var stopId: String? = null,
    var stopName: String? = null,
    var stopNumber: String? = null,
    var trainNumber: String? = null
)

data class FeedbackModel(
    var complaintId: String? = null,
    var userName: String? = null,
    var complaint: String? = null,
    var ratingValue: String? = null
)

data class DeliveryBoyModel(
    var boyId: String? = null,
    var boyName: String? = null,
    var stopName: String? = null,
    var mobile: String? = null,
    var imageUrl: String? = null
)

data class OrderModel(
    var orderId: String? = null,
    var userName: String? = null,
    var userPhone: String? = null,
    var stopName: String? = null,
    var trainNumber: String? = null,
    var seatNumber: String? = null,
    var coachNumber: String? = null,
    var foodList: Map<String, Double>? = null,
    var quantity: Int? = null,
    var price: String? = null
)
data class StatusModel(
    var statusId:String?=null,
    var userName:String?=null,
    var status:Boolean?=null,
    var foodList: List<HashMap<String, Double>>? = null
)