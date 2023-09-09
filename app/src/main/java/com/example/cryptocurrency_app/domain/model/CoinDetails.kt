package com.example.cryptocurrency_app.domain.model

import com.example.cryptocurrency_app.data.remote.dto.TeamMember
import java.io.FileDescriptor
import java.util.IdentityHashMap

data class CoinDetails(
    val coinId : String,
    val name : String,
    val description: String,
    val symbol : String,
    val rank : Int,
    val isActive : Boolean,
    val tags : List<String>,
    val team : List<TeamMember>

)
