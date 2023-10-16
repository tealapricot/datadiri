package com.example.datadiri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.datadiri.ui.theme.DatadiriTheme
import com.example.datadiri.model.Datadiri
import com.example.datadiri.data.Datasource
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DatadiriTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   DatadiriApp()
                }
            }
        }
    }
}

@Composable
fun DatadiriApp() {
    DatadiriList(
        datadiriList = Datasource().Loaddatadiri(),
    )
}

@Composable
fun DatadiriCard(datadiri: Datadiri, modifier: Modifier = Modifier) {
    Card(modifier = modifier){
        Column {
            Image(
                painter = painterResource(datadiri.imageResourceId),
                contentDescription = stringResource(datadiri.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(datadiri.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun DatadiriList(datadiriList: List<Datadiri>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(datadiriList) { datadiri ->
            DatadiriCard(
                datadiri = datadiri,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}