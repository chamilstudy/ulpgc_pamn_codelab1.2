package com.example.tarjetapresentacin

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacin.ui.theme.TarjetaPresentaciónTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaPresentaciónTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PresentationCard(name = "Chamil José Cruz Razeq", job = "Front-End Developer",
                        phone = "+34 665-65-65-65", twitter = "@ChamilCR", mail = "@chamil@mail.com")
                }
            }
        }
    }
}

@Composable
fun Contact(contactInfo: String, contactIcon: Painter) {
    Row {
        Image (
            painter = contactIcon,
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color(0xFF2F7437)),
            modifier = Modifier.size(20.dp)
        )

        Text (
            text = contactInfo,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 15.dp).align(alignment = Alignment.CenterVertically)
        )
    }
}

@Composable
fun ContactInfo(phone: String, twitter: String, mail: String) {
    Column (verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        Contact(phone, painterResource(R.drawable.baseline_call_24))
        Contact(twitter, painterResource(R.drawable.baseline_share_24))
        Contact(mail, painterResource(R.drawable.baseline_mail_24))
    }
}

@Composable
fun HeadInfo(name: String, job: String) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Image (
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.background(Color(0xFF2F3274)).size(200.dp)
        )
        Text(
            text = name,
            fontSize = 30.sp,
        )
        Text(
            text = job,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2F7437)
        )
    }
}

@Composable
fun PresentationInfo(name: String, job: String, phone: String, twitter: String, mail: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        HeadInfo(name, job)
        ContactInfo(phone = phone, twitter = twitter, mail = mail)
    }
}

@Composable
fun PresentationCard(name: String, job: String, phone: String, twitter: String, mail: String) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(Color(0xFFBEDDC2))
    ) {
        PresentationInfo(name = name, job = job, phone = phone, twitter = twitter, mail = mail)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaPresentaciónTheme {
        PresentationCard(name = "Chamil José", job = "Front-End Developer",
            phone = "+34 665-65-65-65", twitter = "@ChamilCR", mail = "chamil@mail.com")
    }
}