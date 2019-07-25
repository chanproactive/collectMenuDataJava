package com.collectMenuDataJava.collectMenuDataJava.tools.googleReceiveModel


import com.google.gson.annotations.SerializedName

data class CloudReceiveModel(
    @SerializedName("responses")
    val responses: List<Response?>?
) {
    data class Response(
        @SerializedName("fullTextAnnotation")
        val fullTextAnnotation: FullTextAnnotation?,
        @SerializedName("textAnnotations")
        val textAnnotations: List<TextAnnotation?>?
    ) {
        data class FullTextAnnotation(
            @SerializedName("pages")
            val pages: List<Page?>?,
            @SerializedName("text")
            val text: String?
        ) {
            data class Page(
                @SerializedName("property")
                val `property`: Property?,
                @SerializedName("blocks")
                val blocks: List<Block?>?,
                @SerializedName("height")
                val height: Int?,
                @SerializedName("width")
                val width: Int?
            ) {
                data class Property(
                    @SerializedName("detectedLanguages")
                    val detectedLanguages: List<DetectedLanguage?>?
                ) {
                    data class DetectedLanguage(
                        @SerializedName("confidence")
                        val confidence: Double?,
                        @SerializedName("languageCode")
                        val languageCode: String?
                    )
                }

                data class Block(
                    @SerializedName("property")
                    val `property`: Property?,
                    @SerializedName("blockType")
                    val blockType: String?,
                    @SerializedName("boundingBox")
                    val boundingBox: BoundingBox?,
                    @SerializedName("paragraphs")
                    val paragraphs: List<Paragraph?>?
                ) {
                    data class Property(
                        @SerializedName("detectedLanguages")
                        val detectedLanguages: List<DetectedLanguage?>?
                    ) {
                        data class DetectedLanguage(
                            @SerializedName("confidence")
                            val confidence: Int?,
                            @SerializedName("languageCode")
                            val languageCode: String?
                        )
                    }

                    data class BoundingBox(
                        @SerializedName("vertices")
                        val vertices: List<Vertice?>?
                    ) {
                        data class Vertice(
                            @SerializedName("x")
                            val x: Int?,
                            @SerializedName("y")
                            val y: Int?
                        )
                    }

                    data class Paragraph(
                        @SerializedName("property")
                        val `property`: Property?,
                        @SerializedName("boundingBox")
                        val boundingBox: BoundingBox?,
                        @SerializedName("words")
                        val words: List<Word?>?
                    ) {
                        data class Property(
                            @SerializedName("detectedLanguages")
                            val detectedLanguages: List<DetectedLanguage?>?
                        ) {
                            data class DetectedLanguage(
                                @SerializedName("confidence")
                                val confidence: Int?,
                                @SerializedName("languageCode")
                                val languageCode: String?
                            )
                        }

                        data class BoundingBox(
                            @SerializedName("vertices")
                            val vertices: List<Vertice?>?
                        ) {
                            data class Vertice(
                                @SerializedName("x")
                                val x: Int?,
                                @SerializedName("y")
                                val y: Int?
                            )
                        }

                        data class Word(
                            @SerializedName("property")
                            val `property`: Property?,
                            @SerializedName("boundingBox")
                            val boundingBox: BoundingBox?,
                            @SerializedName("symbols")
                            val symbols: List<Symbol?>?
                        ) {
                            data class Symbol(
                                @SerializedName("property")
                                val `property`: Property?,
                                @SerializedName("boundingBox")
                                val boundingBox: BoundingBox?,
                                @SerializedName("text")
                                val text: String?
                            ) {
                                data class Property(
                                    @SerializedName("detectedBreak")
                                    val detectedBreak: DetectedBreak?,
                                    @SerializedName("detectedLanguages")
                                    val detectedLanguages: List<DetectedLanguage?>?
                                ) {
                                    data class DetectedLanguage(
                                        @SerializedName("languageCode")
                                        val languageCode: String?
                                    )

                                    data class DetectedBreak(
                                        @SerializedName("type")
                                        val type: String?
                                    )
                                }

                                data class BoundingBox(
                                    @SerializedName("vertices")
                                    val vertices: List<Vertice?>?
                                ) {
                                    data class Vertice(
                                        @SerializedName("x")
                                        val x: Int?,
                                        @SerializedName("y")
                                        val y: Int?
                                    )
                                }
                            }

                            data class BoundingBox(
                                @SerializedName("vertices")
                                val vertices: List<Vertice?>?
                            ) {
                                data class Vertice(
                                    @SerializedName("x")
                                    val x: Int?,
                                    @SerializedName("y")
                                    val y: Int?
                                )
                            }

                            data class Property(
                                @SerializedName("detectedLanguages")
                                val detectedLanguages: List<DetectedLanguage?>?
                            ) {
                                data class DetectedLanguage(
                                    @SerializedName("languageCode")
                                    val languageCode: String?
                                )
                            }
                        }
                    }
                }
            }
        }

        data class TextAnnotation(
            @SerializedName("boundingPoly")
            val boundingPoly: BoundingPoly?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("locale")
            val locale: String?
        ) {
            data class BoundingPoly(
                @SerializedName("vertices")
                val vertices: List<Vertice?>?
            ) {
                data class Vertice(
                    @SerializedName("x")
                    val x: Int?,
                    @SerializedName("y")
                    val y: Int?
                )
            }
        }
    }
}