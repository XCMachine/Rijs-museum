package com.example.rijsmuseum.domain.util

interface ResourceMapper <Resource, DomainModel> {
    fun mapFromResource(resource: Resource): DomainModel
}