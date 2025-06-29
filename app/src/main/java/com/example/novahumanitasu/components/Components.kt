package com.example.novahumanitasu.components

<<<<<<< Updated upstream
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
=======
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
>>>>>>> Stashed changes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
<<<<<<< Updated upstream
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
=======
import androidx.compose.ui.Alignment
>>>>>>> Stashed changes
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
<<<<<<< Updated upstream
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
=======
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
>>>>>>> Stashed changes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novahumanitasu.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.graphics.vector.ImageVector

//1: BOTÓN

enum class ButtonStyle{
    PRIMARY,
    SECONDARY,
    OUTLINED,
    DANGER
}

enum class ButtonSize{
    SMALL,
    MEDIUM,
    LARGE
}

@Composable
fun AppButton( //Le pongo este nombre para que no haya conflictos con el Button de JetpackCompose
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    size: ButtonSize = ButtonSize.MEDIUM
){
    val colors = when (style) {
        ButtonStyle.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
        ButtonStyle.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = Color.Black
        )
        ButtonStyle.OUTLINED -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary
        )
        ButtonStyle.DANGER -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        )
    }

    //Desde aquí hacemos validaciones de acuerdo al tamaño elegido del botón:

    //Acá cambiamos la altura del botón:
    val buttonHeight = when (size) {
        ButtonSize.SMALL -> 36.dp
        ButtonSize.MEDIUM -> 48.dp
        ButtonSize.LARGE -> 56.dp
    }

    //Acá cambiamos el tamaño del texto:
    val textStyle = when (size){
        ButtonSize.SMALL -> MaterialTheme.typography.bodySmall
        ButtonSize.MEDIUM -> MaterialTheme.typography.bodyLarge
        ButtonSize.LARGE -> MaterialTheme.typography.bodyLarge
    }

    //Aca cambiamos el largo del botón
    //Solo en el caso de LARGE, el botón ocupa el espacio del objeto que lo contiene.
    val widthModifier = when (size) {
        ButtonSize.LARGE -> Modifier.fillMaxWidth()
        ButtonSize.MEDIUM -> Modifier
        ButtonSize.SMALL -> Modifier
    }

    Button(
        onClick = onClick,
        modifier = modifier
            .then(widthModifier)
            .height(buttonHeight),
        enabled = enabled,
        colors = colors
    ) {
        Text(text = text, style = textStyle)
    }

}

<<<<<<< Updated upstream
//2: INPUT LOGIN

@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false
){
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {Text(label)},
        singleLine = true,
        visualTransformation = if (isPassword && !passwordVisible){
            PasswordVisualTransformation()
        } else VisualTransformation.None,
        trailingIcon = {
            if (isPassword){
                val icon = if (passwordVisible) Icons.Filled.Lock else Icons.Filled.Lock
                IconButton(
                    onClick = {
                        passwordVisible = !passwordVisible
                    }
                )
                {
                    Icon(imageVector = icon, contentDescription = null)
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary
        )

    )

}
=======
@Composable
fun ProfileCard(name: String, career: String, cycle: String, imageUrl: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen de perfil (placeholder)
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(career, style = MaterialTheme.typography.bodyMedium)
            Text(cycle, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun BarcodeCard(barcodeData: String) {
    // Aquí podrías usar una librería de código de barras real, pero para el ejemplo solo es un placeholder
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color.Black, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("[Código de barras]", color = Color.White)
    }
}

@Composable
fun AnnouncementList() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        AnnouncementCard(
            title = "¡Hoy comienza la Feria del Libro NHU!",
            description = "La feria que tanto estabas esperando volvió, encuéntranos desde el 28 al 31 de abril en Aulario. Tendremos más...",
            imageRes = R.drawable.background_pattern
        )
        AnnouncementCard(
            title = "Santa Misa: Papa Francisco",
            description = "El equipo rectoral invita a toda la comunidad universitaria a participar en la misa que se celebrará en memoria...",
            imageRes = R.drawable.ic_launcher_background
        )
    }
}

@Composable
fun AnnouncementCard(title: String, description: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(description, style = MaterialTheme.typography.bodySmall, maxLines = 3)
            }
        }
    }
}

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(text = text, color = Color.White)
    }
}

@Composable
fun BottomNavBar(selectedIndex: Int = 2, onItemSelected: (Int) -> Unit = {}) {
    val items = listOf(
        BottomNavItem("Calendario", Icons.Filled.CalendarToday),
        BottomNavItem("Cuotas", Icons.Filled.List),
        BottomNavItem("Home", Icons.Filled.Home),
        BottomNavItem("Notificaciones", Icons.Filled.Notifications),
        BottomNavItem("Más", Icons.Filled.MoreHoriz)
    )
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                selected = selectedIndex == index,
                onClick = { onItemSelected(index) }
            )
        }
    }
}

data class BottomNavItem(val label: String, val icon: ImageVector)
>>>>>>> Stashed changes
