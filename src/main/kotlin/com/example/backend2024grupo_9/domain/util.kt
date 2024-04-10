package com.example.backend2024grupo_9.domain

fun Double.formatearPrecio(): Double {
    val formatString = "%.2f"
    return String.format(formatString, this).toDouble()
}