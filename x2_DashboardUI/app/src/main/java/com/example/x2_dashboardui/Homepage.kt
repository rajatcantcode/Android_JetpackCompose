package com.example.x2_dashboardui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.x2_dashboardui.ui.theme.Data

@Composable
fun Homepage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = colorResource(id = R.color.jet_black)),
    ) {

        Column {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.jet_black)),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Handle menu button click */ },
                    modifier = Modifier.size(48.dp), // Adjust the size as needed
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = null,
                            tint = Color.White // Optionally, you can set the tint color for the icon
                        )
                    },
                )
                Text(
                    text = stringResource(R.string.Navbar_title),
                    color = colorResource(id = R.color.cam_blue),
                    fontSize = 30.sp
                )
                IconButton(
                    onClick = { /* Handle menu button click */ },
                    modifier = Modifier.size(48.dp), // Adjust the size as needed
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                )

            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = colorResource(id = R.color.hunter_green)),
                content = {
                    items(Data.data) { item ->
                        showData(item)
                    }
                }
            )

        }

    }
}

@Composable
fun showData(item: Data.Demo) {
    Card(
        modifier = Modifier
            .padding(15.dp)
            .size(width = 160.dp, height = 220.dp)
            .border(
                width = 5.dp,
                color = colorResource(id = R.color.cam_blue),
                shape = RoundedCornerShape(16.dp)
            ),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(item.img),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.name,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${item.price}",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            }
        }
    )
}


@Preview
@Composable
fun HomepagePreview() {
    Homepage()
}

