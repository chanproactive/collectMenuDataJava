package com.collectMenuDataJava.collectMenuDataJava.tools

import com.collectMenuDataJava.collectMenuDataJava.respondModel.ResponseModel
import com.collectMenuDataJava.collectMenuDataJava.respondModel.ResponseModelKotlin
import com.collectMenuDataJava.collectMenuDataJava.tools.googleReceiveModel.CloudReceiveModel
import com.example.menudetection.model.FoodWithImage
import com.example.menudetection.tools.ExtractImage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.concurrent.CompletableFuture



class CloudVision() {
    var responseModel: ArrayList<ResponseModel> = arrayListOf()

    fun request(base64 : String): ArrayList<ResponseModel> {
        val json = "{\"requests\": [\n" +
                "{\n" +
                "\"features\": [{\n" +
                "\"type\": \"DOCUMENT_TEXT_DETECTION\"\n" +
                "}\n" +
                "],\n" +
                "\"image\": {\n" +
                "\"content\": \"$base64\"\n" +
                "},\n" +
                "\"imageContext\":{\n" +
                "\"languageHints\": [\"th-t-i0-handwrit\"]\n" +
                "}\n" +
                "}\n" +
                "]\n" +
                "}"
      return  detectImageWithCloudVisionApi(json)
    }

    private fun detectImageWithCloudVisionApi(json: String): ArrayList<ResponseModel> {
        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val body = json.toRequestBody(mediaType)

        val client = OkHttpClient.Builder().build()

        val request = Request.Builder()
                .post(body)
                .url("https://vision.googleapis.com/v1/images:annotate?key=AIzaSyAmTJTlotJaN1HJfuH814plLChe4wvpXos")
                .build()


        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            val body = response.body?.string()
            val collectionType = object : TypeToken<CloudReceiveModel>() {}.type
            val enums = Gson().fromJson<String>(body, collectionType) as CloudReceiveModel
            val dataList = enums.responses?.get(0)?.textAnnotations as ArrayList<CloudReceiveModel.Response.TextAnnotation>
            val data: String? = dataList[0].description
            var array = data?.split("\n")?.toTypedArray()
            val a = array?.toMutableList()
            a!!.removeAt(array!!.size - 1)
            array = a.toTypedArray()

            return  thaiFilter(array)

        }
        else{
            var responseModel: ArrayList<ResponseModel> = arrayListOf()
            return responseModel
        }
    }
            private fun thaiFilter(array: Array<String>): ArrayList<ResponseModel> {
                var data = ArrayList<String>()

                for (i in 0 until array.size) {
                    var stringArray = array[i].replace("[^\\u0E00-\\u0E7F|\\d|\\s|.]".toRegex(), "").trim()
                    if(stringArray.replace("[\\d|.]".toRegex(), "").trim() == "")
                        continue
                    if (stringArray != "" && stringArray.length > 3) {
                        data.add(stringArray)
                        val model =ResponseModel()
                        model.menuName = stringArray
                        responseModel.add(model)
                    }
               }
                extractImageUrl()
                return responseModel
            }
            private fun extractImageUrl() {
                responseModel.forEach {
                        val extractImage = ExtractImage()
                        val imageUrl = extractImage.extract(it.menuName.replace("[^\\u0E00-\\u0E7F|\\s]".toRegex(), "").trim())
                        it.menuImageUrl = imageUrl
                        var pork = "หมู"
                        var squid = "หมึก"
                        var shrimp = "กุ้ง"
                        var chick = "ไก่"
                        var fish = "ปลา"
                        var cow = "วัว"
                        if(it.menuName.toLowerCase().indexOf(pork.toLowerCase()) != -1) {
                            it.tag = 1
                        }
                        if(it.menuName.toLowerCase().indexOf(squid.toLowerCase()) != -1) {
                            it.tag =  7
                        }
                        if(it.menuName.toLowerCase().indexOf(shrimp.toLowerCase()) != -1) {
                            it.tag =  4
                        }
                        if(it.menuName.toLowerCase().indexOf(chick.toLowerCase()) != -1) {
                            it.tag = 5
                        }
                        if(it.menuName.toLowerCase().indexOf(fish.toLowerCase()) != -1) {
                            it.tag =  2
                        }
                        if(it.menuName.toLowerCase().indexOf(cow.toLowerCase()) != -1) {
                            it.tag =  3
                        }
                    it.spicy = (0..3).random()
                    it.rating = (0..5).random()
                }
            }
}