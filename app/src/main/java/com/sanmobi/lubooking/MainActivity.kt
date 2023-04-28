package com.sanmobi.lubooking

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sanmobi.lubooking.data.Destination
import com.sanmobi.lubooking.ui.theme.LuBookingTheme
import com.sanmobi.lubooking.ui.widget.StaggeredVerticalGrid

val textColor = Color(0xFF222222)

val dummyDestinations by lazy {
    listOf(
        Destination(R.drawable.malawi, "Malawi", 4.8F),
        Destination(R.drawable.japan, "Japan", 4.8F),
        Destination(R.drawable.bali, "Bali", 4.8F),
        Destination(R.drawable.philis, "philippines", 4.8F),
        Destination(R.drawable.ocean, "Ocean", 4.8F),
        Destination(R.drawable.dolphin, "Dolphin", 4.8F),
        Destination(R.drawable.japan, "Japan", 4.8F),
        Destination(R.drawable.japan, "Japan", 4.8F),
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeComponent()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun HomeComponent() {
    return LuBookingTheme() {
        Scaffold(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            //Top Section
            Column() {
                TopSection()
                Spacer(modifier = Modifier.size(20.dp))
                Events()
                Spacer(modifier = Modifier.size(10.dp))
                EventList()
            }

        }
    }
}

@Composable
fun EventList() {
    return Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            ) {
            Text(
                text = "Best Destination",
                color = textColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 26.sp
            )
            Text(
                text = "SEE ALL",
                color = textColor,
                fontWeight = FontWeight.Medium,
            )
        }

        StaggeredVerticalGrid(maxColumnWidth = 220.dp,
            modifier = Modifier
                .padding(4.dp)
                .verticalScroll(rememberScrollState())
                .weight(weight =1f, fill = false)
        ) {
            dummyDestinations.forEach { destination ->
                DestinationCard(destination)
            }
        }

    }
}

@Composable
fun DestinationCard(destination: Destination) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomStart
    )  {
        Image(
            painter = painterResource(id = destination.destinationImage),
            contentDescription = destination.destinationName,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Column( modifier = Modifier.padding(8.dp)
            ) {
            Text(text = destination.destinationName,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                modifier = Modifier
                    .background(
                        Color.White.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = destination.destinationRating.toString(),
                    color = Color.White)
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
                    tint = Color.White,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.CenterVertically)
                )
            }

        }

    }
}

@Composable
fun Events() {

    return Row(
        Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFF1F6F7)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_hotel),
                    contentDescription = "Hotel",
                    Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.size(6.dp))
            Text(
                text = "HOTELS",
                color = textColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                letterSpacing = 0.2.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(68.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFFFF5F5)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_plane),
                    contentDescription = "flight",
                    Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.size(6.dp))
            Text(
                text = "PLANE",
                color = textColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                letterSpacing = 0.2.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(68.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFFFF7F2)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_food),
                    contentDescription = "food",
                    Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.size(6.dp))
            Text(
                text = "FOODS",
                color = textColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                letterSpacing = 0.2.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(68.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFF4F3FB)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_event),
                    contentDescription = "food",
                    Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.size(6.dp))
            Text(
                text = "EVENTS",
                color = textColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                letterSpacing = 0.2.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(68.dp)
            )
        }

    }
}

@Composable
fun TopSection() {
   return Column(
       modifier = Modifier.fillMaxWidth()
   ) {
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween,
           verticalAlignment = Alignment.CenterVertically,
       ) {
           Text(
               text = "Hi Santhosh",
               color = Color(0xFF222222),
               style = MaterialTheme.typography.h6,
               fontSize = 37.sp,
               textAlign = TextAlign.Start,
               fontWeight = FontWeight.SemiBold
           )
           Icon(
               imageVector = Icons.Default.Search,
               contentDescription = "Search",
               tint = Color(0xFF777974)
           )
       }
       Row(
           modifier = Modifier.padding(4.dp),
           verticalAlignment = Alignment.CenterVertically
       ){
           Text(
               text = buildAnnotatedString {
                   append("WHERE TO ")
                   withStyle(style = SpanStyle(Color.Red)) {
                       append("54 KING PORT")
                   }
               },
               color = Color(0xFF222222),
               fontWeight = FontWeight.Medium,
               fontSize = 14.sp
           )
           Icon(
               imageVector = Icons.Default.KeyboardArrowDown,
               contentDescription = "down",
               tint = Color(0xFF777974),
               modifier = Modifier.padding(start = 4.dp, bottom = 2.dp)
           )
       }
   }
}

