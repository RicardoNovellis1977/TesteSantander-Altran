package com.ricardo.testesantander.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Launches {
    @SerializedName("statementList")
    @Expose
    var statementList: List<StatementList>? = null
    @SerializedName("error")
    @Expose
    var error: Error? = null
}