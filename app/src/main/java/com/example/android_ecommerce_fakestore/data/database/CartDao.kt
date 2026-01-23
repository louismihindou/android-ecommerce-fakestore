//V1.0 - PIER - Init
package com.example.android_ecommerce_fakestore.data.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.android_ecommerce_fakestore.data.model.CartItemEntity

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cartItem: CartItemEntity)
    @Delete
    suspend fun delete(cartItem: CartItemEntity)
    @Query("SELECT * FROM cart_items") //cart_item ?
    suspend fun getAllCartItems(): List<CartItemEntity>
    @Query("DELETE FROM cart_items")
    suspend fun clearCart()
}

@Database(entities = [CartItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}