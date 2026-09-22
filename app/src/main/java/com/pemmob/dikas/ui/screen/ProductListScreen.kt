package com.pemmob.dikas.ui.screen

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pemmob.dikas.R
import com.pemmob.dikas.ui.theme.JualanTheme

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val category: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    isDarkTheme: Boolean = false,
    onThemeToggle: () -> Unit = {}
) {
    val context = LocalContext.current
    var selectedCategory by remember { mutableStateOf("Makanan") }
    
    val categories = listOf("Makanan", "Minuman", "Kerajinan")
    
    val allProducts = remember {
        listOf(
            Product(1, "Kripik Singkong", 15000.0, "Makanan"),
            Product(2, "Mendoan", 20000.0, "Makanan"),
            Product(3, "Sale Pisang", 25000.0, "Makanan"),
            Product(4, "Getuk Goreng", 30000.0, "Makanan"),
            Product(5, "Es Kelapa Muda", 8000.0, "Minuman"),
            Product(6, "Wedang Uwuh", 10000.0, "Minuman"),
            Product(7, "Batik Purbalingga", 150000.0, "Kerajinan"),
            Product(8, "Tas Anyaman", 45000.0, "Kerajinan")
        )
    }
    
    val filteredProducts = allProducts.filter { it.category == selectedCategory }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Daftar Produk UMKM", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                actions = {
                    IconButton(onClick = { 
                        Toast.makeText(context, "Keranjang Belanja diklik", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(
                            text = if (isDarkTheme) "Dark" else "Light",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.labelMedium
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Switch(
                            checked = isDarkTheme,
                            onCheckedChange = { onThemeToggle() },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.primary,
                                checkedTrackColor = MaterialTheme.colorScheme.onPrimary,
                                uncheckedThumbColor = MaterialTheme.colorScheme.onPrimary,
                                uncheckedTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                            )
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Kategori Produk",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
            ) {
                items(categories) { category ->
                    val isSelected = category == selectedCategory
                    val containerColor = if (isSelected) MaterialTheme.colorScheme.primary else if (isDarkTheme) Color(0xFF2D2D2D) else Color(0xFFE0E0E0)
                    val contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else if (isDarkTheme) Color.White else Color.Black
                    
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(containerColor)
                            .clickable { selectedCategory = category }
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text(
                            text = category,
                            color = contentColor,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            
            Text(
                text = "Daftar Produk",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredProducts) { product ->
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isDarkTheme) Color(0xFF1E1E1E) else Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                Toast.makeText(context, "Clicked: ${product.name}", Toast.LENGTH_SHORT).show()
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(if (isDarkTheme) Color(0xFF2D2D2D) else Color(0xFFF5F5F5)),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(CircleShape)
                                        .background(Color.White),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.logo_jualan),
                                        contentDescription = product.name,
                                        modifier = Modifier.size(65.dp)
                                    )
                                }
                                
                                // Tag Kategori di pojok kanan atas gambar
                                Box(
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(6.dp)
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Color(0xFF8BC34A))
                                        .padding(horizontal = 6.dp, vertical = 3.dp)
                                ) {
                                    Text(
                                        text = product.category,
                                        color = Color.White,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Text(
                                text = product.name,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.align(Alignment.Start)
                            )
                            
                            Spacer(modifier = Modifier.height(4.dp))
                            
                            Text(
                                text = "Rp ${product.price}",
                                color = Color(0xFF3AA34B),
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.align(Alignment.Start)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProductListScreenPreview() {
    JualanTheme {
        ProductListScreen()
    }
}
