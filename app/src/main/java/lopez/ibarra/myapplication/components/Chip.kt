package lopez.ibarra.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopez.ibarra.myapplication.ui.theme.OffWhite
import lopez.ibarra.myapplication.ui.theme.leaf_green

@Composable
fun Chip(text: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier
            .padding(horizontal = 5.dp, vertical = 2.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(color)
            .padding(horizontal = 14.dp, vertical = 4.dp)
    ) {
        Text(text)
    }
}

@Composable
fun NumberChip(text: String, modifier: Modifier = Modifier, colors: Pair<Color, Color>) {
    Row(
        modifier = modifier
            .size(30.dp)
            .background(colors.first, shape = CircleShape)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            color = colors.second
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChipPreview(){
    Chip("Planta", leaf_green)
}

@Preview(showBackground = true)
@Composable
fun NumberChipPreview() {
    NumberChip(text = "1", colors = Pair(leaf_green, OffWhite))
}
