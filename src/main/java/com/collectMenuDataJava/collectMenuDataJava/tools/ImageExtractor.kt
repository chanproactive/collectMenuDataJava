package com.example.menudetection.tools


import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.io.IOException


class ExtractImage {

    fun extract(keyword:String): String {
        val imageURL = ArrayList<String>()
        try {
            val document =
                Jsoup.connect("https://images.search.yahoo.com/search/images;_ylt=Awr9Hr7CeSBdr3MAHCSJzbkF;_ylu=X3oDMTBsZ29xY3ZzBHNlYwNzZWFyY2gEc2xrA2J1dHRvbg--;_ylc=X1MDOTYwNjI4NTcEX3IDMgRhY3RuA2NsawRjc3JjcHZpZANFeGdDdGpFd0xqSnNobk5WWENCOW1BeUZNVEUxTGdBQUFBREo3UFJfBGZyA3lmcC10BGZyMgNzYS1ncARncHJpZAMEbl9zdWdnAzAEb3JpZ2luA2ltYWdlcy5zZWFyY2gueWFob28uY29tBHBvcwMwBHBxc3RyAwRwcXN0cmwDBHFzdHJsAzQEcXVlcnkDZmlzaAR0X3N0bXADMTU2MjQwOTQyOA--?p=$keyword&fr=yfp-t&fr2=sb-top-images.search&ei=UTF-8&n=60&x=wrt")
                    .get()
            val imagesSource: Elements? = document.select("img[src]")
            for (i in 0..1) {
                imageURL.add(imagesSource?.get(i)?.attr("src").toString())
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return imageURL[0]
    }
}