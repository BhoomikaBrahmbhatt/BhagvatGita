package com.android.test.bhagvatgita.mvvm

import com.google.gson.annotations.SerializedName;


data class Chapters (

    @SerializedName("chapter_number"  ) var chapterNumber   : Int?     = null,
    @SerializedName("verses_count"    ) var versesCount     : Int?     = null,
    @SerializedName("name"            ) var name            : String?  = null,
    @SerializedName("translation"     ) var translation     : String?  = null,
    @SerializedName("transliteration" ) var transliteration : String?  = null,
    @SerializedName("meaning"         ) var meaning         : Meaning? = Meaning(),
    @SerializedName("summary"         ) var summary         : Summary? = Summary()
)

data class Meaning (

    @SerializedName("en" ) var en : String? = null,
    @SerializedName("hi" ) var hi : String? = null

)


data class Summary (

    @SerializedName("en" ) var en : String? = null,
    @SerializedName("hi" ) var hi : String? = null

)