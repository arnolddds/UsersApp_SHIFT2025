package com.sobolev.usersapp.presentation.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.sobolev.usersapp.presentation.ui.theme.Blue100
import com.sobolev.usersapp.presentation.ui.theme.Grey300

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreen(
    userId: Int,
    onFinished: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UserDetailViewModel = hiltViewModel(
        creationCallback = { factory: UserDetailViewModel.Factory ->
            factory.create(userId)

        }
    )
) {

    val state = viewModel.state.collectAsState()

    val currentState = state.value

    when (currentState) {
        is UserDetailState.Checking -> {
            Scaffold(
                modifier = modifier,
                topBar = {
                    TopAppBar(
                        title = {
                            Title(title = "User details")
                        },
                        navigationIcon = {
                            IconButton(onClick = onFinished) {
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.White,
                            actionIconContentColor = MaterialTheme.colorScheme.onBackground
                        )

                    )
                }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            model = currentState.user.picture.large,
                            contentDescription = "User avatar",
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)
                                .background(Blue100),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(Modifier.width(16.dp))

                        Column {
                            Text(
                                text = currentState.user.fullName,
                                style = MaterialTheme.typography.headlineSmall,
                                color = Grey300
                            )
                            Text(
                                text = "@${currentState.user.fullName}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "Age: ${currentState.user.dob} years",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                        }
                    }

                    Spacer(Modifier.height(24.dp))


                    SectionTitle("Contact Information")
                    InfoItem(Icons.Default.Email, "Email", currentState.user.email)
                    InfoItem(Icons.Default.Phone, "Phone", currentState.user.phone)


                    SectionTitle("Address")
                    InfoItem(
                        Icons.Default.LocationOn, "Street",
                        "${currentState.user.location.street.number} ${currentState.user.location.street.name}"
                    )
                    InfoItem(Icons.Default.Lock, "City", currentState.user.location.city)
                    InfoItem(
                        Icons.Default.Home, "State/Country",
                        "${currentState.user.location.state}, ${currentState.user.location.country}"
                    )
                    InfoItem(Icons.Default.ThumbUp, "Postcode", currentState.user.location.postcode)

                    SectionTitle("Additional Info")
                    InfoItem(Icons.Default.Person, "Gender", currentState.user.gender)
                    InfoItem(
                        Icons.Default.Notifications, "ID",
                        "${currentState.user.id}: ${currentState.user.id}"
                    )
                    InfoItem(Icons.Default.Face, "Nationality", currentState.user.nat)
                }
            }
        }

        UserDetailState.Finished -> {
            LaunchedEffect(key1 = Unit) {
                onFinished()
            }
        }
        UserDetailState.Initial -> {}
    }

}



@Composable
private fun Title(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
private fun InfoItem(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {


    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(24.dp)
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}
