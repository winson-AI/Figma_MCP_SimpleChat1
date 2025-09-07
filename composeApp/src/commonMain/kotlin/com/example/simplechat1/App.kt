package com.example.simplechat1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import simplechat1.composeapp.generated.resources.*

@Composable
@Preview
fun App() {
    CustomerSupportChat()
}

@Composable
fun CustomerSupportChat() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(35.dp))
                .background(Color.White)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(35.dp),
                    ambientColor = Color.Black.copy(alpha = 0.1f),
                    spotColor = Color.Black.copy(alpha = 0.1f)
                )
        ) {
            // Header with back arrow and status indicator (Group 68)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                // Back arrow - positioned at x=13, y=22
                IconButton(
                    onClick = { /* Handle back */ },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 13.dp, top = 22.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.arrow_left),
                        contentDescription = "Back",
                        modifier = Modifier.size(28.dp)
                    )
                }

                // Status indicator (Group 68) - positioned at x=389, y=30
                Image(
                    painter = painterResource(Res.drawable.status_indicator),
                    contentDescription = "Status",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 21.dp, top = 30.dp)
                        .size(20.dp, 8.5.dp)
                )
            }

            // Chat messages
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // First support message
                SupportMessage(
                    message = "Hi, how can I help you?",
                    time = ""
                )

                // First customer message
                CustomerMessage(
                    message = "Hello, I ordered two fried chicken burgers. can I know how much time it will get to arrive?",
                    avatar = painterResource(Res.drawable.user_avatar)
                )

                // Second support message
                SupportMessage(
                    message = "Ok, please let me check!",
                    time = ""
                )

                // Second customer message
                CustomerMessage(
                    message = "Sure...",
                    avatar = painterResource(Res.drawable.user_avatar)
                )

                // Third support message
                SupportMessage(
                    message = "It'll get 25 minutes to arrive to your address",
                    time = ""
                )

                // Time stamp
                Text(
                    text = "26 minutes ago",
                    fontSize = 14.sp,
                    color = Color(0xFFDBDADA),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )

                // Third customer message
                CustomerMessage(
                    message = "Ok, thanks you for your support",
                    avatar = painterResource(Res.drawable.user_avatar)
                )
            }

            var text by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, end = 26.dp, bottom = 27.dp)
                    .height(70.dp)
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(20.dp),
                        ambientColor = Color.Black.copy(alpha = 0.18f),
                        spotColor = Color.Black.copy(alpha = 0.18f)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()          // ① 关键：撑满 70.dp
                        .padding(start = 27.dp),
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFDBDADA)
                    ),
                    decorationBox = { innerTextField ->
                        if (text.isEmpty()) {
                            Text(
                                text = "Type here...",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFDBDADA)
                            )
                        }
                        innerTextField()
                    }
                )

                IconButton(
                    onClick = { /* 发送逻辑 */ },
                    modifier = Modifier
                        .size(70.dp)
                        .background(Color(0xFFEF2A39), RoundedCornerShape(20.dp))
                ) {
                    Image(
                        painter = painterResource(Res.drawable.paper_plane),
                        contentDescription = "Send",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SupportMessage(message: String, time: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        // Avatar
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Black, RoundedCornerShape(50.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.user_icon),
                contentDescription = "Support Avatar",
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Message bubble
        Box(
            modifier = Modifier
                .background(Color(0xFFF3F3F3), RoundedCornerShape(20.dp))
                .padding(horizontal = 23.dp, vertical = 15.dp)
        ) {
            Text(
                text = message,
                fontSize = 18.sp,
                color = Color(0xFF3C2F2F),
                fontWeight = FontWeight.Medium,
                lineHeight = 21.sp
            )
        }
    }
}

@Composable
fun CustomerMessage(message: String, avatar: androidx.compose.ui.graphics.painter.Painter?) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top
    ) {
        // Message bubble
        Box(
            modifier = Modifier
                .background(Color(0xFFEF2A39), RoundedCornerShape(20.dp))
                .shadow(
                    elevation = 7.dp,
                    shape = RoundedCornerShape(20.dp),
                    ambientColor = Color.Black.copy(alpha = 0.18f),
                    spotColor = Color.Black.copy(alpha = 0.18f)
                )
                .padding(horizontal = 23.dp, vertical = 15.dp)
        ) {
            Text(
                text = message,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                lineHeight = 21.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Avatar with mask
        Box(
            modifier = Modifier.size(50.dp),
            contentAlignment = Alignment.Center
        ) {
            if (avatar != null) {
                // Avatar image with circular mask
                Image(
                    painter = avatar,
                    contentDescription = "Customer Avatar",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(50.dp)),
                    contentScale = ContentScale.Crop
                )
            } else {
                // Fallback avatar
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Gray, RoundedCornerShape(50.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("👤", fontSize = 20.sp, color = Color.White)
                }
            }
        }
    }
}