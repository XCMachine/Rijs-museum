package com.example.network.domain.util

interface ResourceMapper <Resource, DomainModel> {
    //Mapping from the resource model
    fun mapFromResource(resource: Resource): DomainModel
}