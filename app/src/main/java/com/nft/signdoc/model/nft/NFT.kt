package com.nft.signdoc.model.nft

import com.google.gson.JsonObject
import com.nft.signdoc.data.networks.response.DtoNFTResponse
import com.nft.signdoc.model.User
import com.nft.signdoc.model.toDomain

data class NFT(
    val id: String,
    val name: String,
    val type: String,
    val image: String,
    val author: NFTAuthor,
    val description: String,
    val info: NFTInfo,
    val owner: User? = null,
    val attributes : List<JsonObject>? = null
)

fun DtoNFTResponse.toDomainModel() = NFT(
    id = nftId,
    name = title.orEmpty(),
    image = fileUrl.orEmpty(),
    type = category.orEmpty(),
    author = NFTAuthor(ownerId.orEmpty(), "image"),
    description = description.orEmpty(),
    info = NFTInfo("token", "contact"),
    owner = owner?.toDomain(),
    attributes = attributes
)