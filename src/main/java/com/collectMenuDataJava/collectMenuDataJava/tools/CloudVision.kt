package com.collectMenuDataJava.collectMenuDataJava.tools

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import jdk.nashorn.internal.codegen.CompilerConstants
import jdk.nashorn.internal.ir.RuntimeNode
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import org.apache.catalina.connector.Response
import java.io.IOException
import java.util.*
import okhttp3.RequestBody.Companion.toRequestBody
import javax.security.auth.callback.Callback

class CloudVision(base64: String) {

    val base64 = base64

    fun request() {
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
        detectImageWithCloudVisionApi(json)
    }

    private fun detectImageWithCloudVisionApi(json: String) {
        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val body = json.toRequestBody(mediaType)

        val client = OkHttpClient.Builder().build()

        val request = Request.Builder()
                .post(body)
                .url("https://vision.googleapis.com/v1/images:annotate?key=AIzaSyAmTJTlotJaN1HJfuH814plLChe4wvpXos")
                .build()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onResponse(call: Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                }
                call.cancel()
            }

            override fun onFailure(call: Call, e: IOException) {
                call.cancel()
            }
        })
    }
}


