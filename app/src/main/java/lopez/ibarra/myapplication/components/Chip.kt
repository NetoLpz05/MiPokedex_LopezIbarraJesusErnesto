package lopez.ibarra.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Preview(showBackground = true)
@Composable
fun ChipPreview(){
    Chip("Planta", leaf_green)
}